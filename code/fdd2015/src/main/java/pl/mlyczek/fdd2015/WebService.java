package pl.mlyczek.fdd2015;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Interface with methods to invoke on web service.
 */
public interface WebService {
    @GET("/users/{username}/fullname")
    Observable<String> getUserFullName(@Path("username") String username);

    @GET("/users/{username}/position")
    Observable<String> getUserPosition(@Path("username") String username);
}
