package com.example.PharmacyMng;

import java.security.PrivateKey;

public class Achats {
    private int AchatsID;
    private String Fournisseur;
    private String Type;
    private String Famille;
    private int Qte;
    private int PrixAchats;
    private String Produit;
    private int PrixVente;

    Achats(){

    }
    Achats(int idClient,String Fournisseur,String Type, int PrixAchats , String Produit , int PrixVente, int Qte , String Famille ){
        this.AchatsID = idClient;
        this.Fournisseur = Fournisseur;
        this.Type= Type;
        this.PrixAchats = PrixAchats;
        this.Produit = Produit ;
        this.PrixVente = PrixVente;
        this.Qte=Qte;
        this.Famille = Famille ;
    }

    public int getAchatsID() {
        return AchatsID;
    }

    public String getFournisseur() {
        return Fournisseur;
    }

    public String getType() {
        return Type;
    }

    public String getProduit() {
        return Produit;
    }

    public int getPrixAchats() {
        return PrixAchats;
    }

    public int getPrixVente() {
        return PrixVente;
    }

    public int getQte(){return Qte;}

    public String getFamille(){return Famille;}

}
