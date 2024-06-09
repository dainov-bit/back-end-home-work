package de.darom.domain;

public class User {
    private Long id;
    private String login;
    private String email;
    public User(String login,String email) {
        this.login = login;
        this.email = email;
    }
    public String getLogin() {
        return login;
    }
    public String getEmail() {
        return email;
    }
}
