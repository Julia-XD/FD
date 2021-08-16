package com.example.demo.req;

public class UserQueryReq extends PageReq{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserQueryReq{" +
                "email='" + email + '\'' +
                '}';
    }
}
