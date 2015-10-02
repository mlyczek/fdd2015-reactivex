package pl.mlyczek.fdd2015.repositories;

import java.util.Random;

public class UsersRepository {
    private final Random random;

    public UsersRepository() {
        random = new Random();
    }

    public String[] getUsernamesForPart(String part) {
        final int number = random.nextInt(5);
        final String[] usernames = new String[number];
        for (int i = 0; i < number; i++) {
            usernames[i] = String.format("%s%d", part, i);
        }

        return usernames;
    }
}
