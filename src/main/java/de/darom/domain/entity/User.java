package de.darom.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    // сеттеры
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User u = (User) o;
        return id == u.getId() && Objects.equals(login, u.getLogin()) && Objects.equals(email, u.getEmail()) && Objects.equals(password,u.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email,password);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Login: %s, Email: %s,", id, login, email);
    }

}

