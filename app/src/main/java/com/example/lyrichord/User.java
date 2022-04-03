package com.example.lyrichord;

public class User {
    private Integer uid;
    private String username;
    private String email;

    public User(){

    }

    public User(Integer uid, String username, String email) {
        this.uid = uid;
        this.username = username;
        this.email = email;
    }

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
