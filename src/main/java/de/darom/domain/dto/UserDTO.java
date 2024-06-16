package de.darom.domain.dto;


import java.util.Objects;

public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private String email;

    public UserDTO() {

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass() || o == null) {
            return false;
        }
        UserDTO u = (UserDTO) o;
        return id == u.getId() && Objects.equals(login, u.getLogin()) && Objects.equals(email, u.getEmail()) && Objects.equals(password, u.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, password);
    }
}
