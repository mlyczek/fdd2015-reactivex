package pl.mlyczek.fdd2015;

import com.google.gson.Gson;
import pl.mlyczek.fdd2015.converters.StringConverterFactory;
import pl.mlyczek.fdd2015.domain.User;
import pl.mlyczek.fdd2015.repositories.UsersRepository;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;
import spark.Spark;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(new StringConverterFactory())
                .build();

        final WebService webService = retrofit.create(WebService.class);

        final Gson gson = new Gson();
        final UsersRepository usersRepository = new UsersRepository();

        Spark.staticFileLocation("static/");

        Spark.get("/users/:username/position", (request, response) -> {
            // simulate some processing
            Thread.sleep(300);
            return String.format("Position of %s", request.params(":username"));
        });

        Spark.get("/users/:username/fullname", (request, response) -> {
            // simulate some processing
            Thread.sleep(500);
            return String.format("Full %s name", request.params(":username"));
        });

        Spark.get("/users/find", "application/json", (request, response) -> {
            String username = request.queryParams("username");

            String[] usernames = usersRepository
                    .getUsernamesForPart(username);

            Observable<User> users = Observable.from(usernames)
                    .flatMap(name ->
                            getUserObservable(webService, name));

            List<User> userResult = new ArrayList<User>();
            users.toBlocking().forEach(userResult::add);
            return userResult;
        }, gson::toJson);
    }

    /**
     * Creates observable emitting {@link User} instances with full information.
     * @param webService web service to invoke requests on
     * @param username username of user to retrieve full information
     * @return {@link User} with full name and position
     */
    private static Observable<User> getUserObservable(WebService webService, String username) {
        Observable<String> fullnameObservable = webService
                .getUserFullName(username)
                .subscribeOn(Schedulers.io());

        Observable<String> positionObservable = webService
                .getUserPosition(username)
                .subscribeOn(Schedulers.io());

        // zip two observables into third one emitting combined items
        return fullnameObservable.zipWith(positionObservable,
                (fullname, userPosition) ->
                    new User(username, fullname, userPosition));
    }
}
