package com.example.buddyy;

public class UserModel {
    private String email;
    private String password;
    private String name;

    //cons


    public UserModel(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
