package pl.mlyczek.fdd2015.repositories;

import java.util.Random;

/**
 * Repository of Users.
 */
public class UsersRepository {
    private final Random random;

    public UsersRepository() {
        random = new Random();
    }

    /**
     * Returns some generated user names based on provided part. For presentation purposes only.
     * @param part part to be a base for generated user names
     * @return an array of generated user names
     */
    public String[] getUsernamesForPart(String part) {
        final int number = random.nextInt(5);
        final String[] usernames = new String[number];
        for (int i = 0; i < number; i++) {
            usernames[i] = String.format("%s%d", part, i);
        }

        return usernames;
    }
}
