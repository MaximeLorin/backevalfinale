package com.zenika.academy.barbajavas.backFinalProject.domain.model.users;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User {
    @Id
    private String id;
    private boolean admin;
    private String email;
    private String password;
    private String username;

    public User(String id, boolean admin, String email, String password, String username) {
        this.id = id;
        this.admin = admin;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    protected User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
