package com.example.praktika1;
public class Admin {
    private String idadmin;
    private String adminName;
    private String adminPassword;
    public Admin(String idadmin, String adminName, String adminPassword) {
        this.idadmin = idadmin;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
    public Admin() {
    }
    public String getIdadmin() {
        return idadmin;
    }
    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminPassword() {
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}