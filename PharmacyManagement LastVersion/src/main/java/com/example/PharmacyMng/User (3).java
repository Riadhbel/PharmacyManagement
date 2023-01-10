package com.example.PharmacyMng;

public class User {
    private int idUser;
    private String username;
    private String password;
    private int typeUser;
    public User(){

    }
    public User(int idUser, String username, String password, int typeUser) {
        this.idUser = idUser;
        this.username = username;
        this.password =password;
        this.typeUser = typeUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTypeUser() {
        return typeUser;
    }
}
