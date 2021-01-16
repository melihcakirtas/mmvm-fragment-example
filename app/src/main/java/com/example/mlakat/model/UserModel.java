package com.example.mlakat.model;

public class UserModel {
    public String name;
    public String username;
    public String email;
    public String phone;
    public String website;


    public UserModel(String name , String username , String email , String phone , String website){
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
