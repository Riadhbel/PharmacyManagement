package com.example.PharmacyMng;

public class Client {
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String adresseClient;
    private int age;
    private int numTel;
    private int numAssurance;

    Client(){

    }
    Client(int idClient,String nomClient,String prenomClient){
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setNumAssurance(int numAssurance) {
        this.numAssurance = numAssurance;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public int getAge() {
        return age;
    }

    public int getNumTel() {
        return numTel;
    }

    public int getNumAssurance() {
        return numAssurance;
    }
}
