package com.xiaojiang;

public class Students {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
