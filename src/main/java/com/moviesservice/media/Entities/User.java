package com.moviesservice.media.Entities;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;

    private String username;

    private String password;



    public User(String username, String password, String token) {
        this.username = username;
        this.password = password;

    }

    public User(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
