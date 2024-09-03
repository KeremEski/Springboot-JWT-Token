package com.security.base.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id",nullable = false,unique = true)
    private UUID userId;
    @Column(name = "user_name",nullable = false,unique = true)
    private String username;
    @Column(name = "user_first_name",nullable = false)
    private String userFname;
    @Column(name = "user_last_name",nullable = false)
    private String userLname;
    @Column(name = "user_email",nullable = false,unique = true)
    private String userEmail;
    @Column(name = "user_password",nullable = false)
    private String userPassword;
    public User() {
    }
    
    public User(String username, String userFname, String userLname, String userEmail, String userPassword) {
        this.username = username;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserFname() {
        return userFname;
    }
    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }
    public String getUserLname() {
        return userLname;
    }
    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
}
