package pl.mlyczek.fdd2015.domain;

public class User {
    private String username;
    private String fullName;
    private String position;

    public User(String username, String fullName, String position) {
        this.username = username;
        this.fullName = fullName;
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }
}
