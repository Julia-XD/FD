package com.example.demo.resp;

public class UserLoginResp {
    private int userId;

    private String email;


    private String token;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginResp{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
