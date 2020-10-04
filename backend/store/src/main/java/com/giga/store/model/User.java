package com.giga.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Set;

/**
 * User abstract class
 */
@Entity(name = "users")
public abstract class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String userID;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    // constructor
    public User(String userID, String firstName, String lastName, String username, String email, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getters
    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }

    // setters
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
    }
}