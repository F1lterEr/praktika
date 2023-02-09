package com.example.praktika1;
public class User {
    private String idUsers;
    private String login;
    private String password;
    public User(String idUsers, String login, String password) {
        this.idUsers = idUsers;
        this.login = login;
        this.password = password;
    }
    public User() {}
    public String getIdUsers() {
        return idUsers;
    }
    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
