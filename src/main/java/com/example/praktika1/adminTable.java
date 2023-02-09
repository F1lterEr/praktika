package com.example.praktika1;
public class adminTable {
    String idUsers, login, password;
    public adminTable(String idUsers, String login, String password) {
        this.idUsers = idUsers;
        this.login = login;
        this.password = password;
    }
    public adminTable() {}
    public String getIdUsers(){
        return idUsers;
    }
    public void setIdUsers(String idUsers){
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
    }
}
