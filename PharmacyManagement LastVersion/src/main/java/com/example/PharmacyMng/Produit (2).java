package com.example.PharmacyMng;

public class Produit {
    private int idProduit;
    private String nomProduit;
    private String lotProduit;
    private int pAchatProduit;
    private int pVenteProduit;
    private int qteProduit;
    private String familleProduit;

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, String lotProduit, int pAchatProduit, int pVenteProduit, int qteProduit, String familleProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.lotProduit = lotProduit;
        this.pAchatProduit = pAchatProduit;
        this.pVenteProduit = pVenteProduit;
        this.qteProduit = qteProduit;
        this.familleProduit = familleProduit;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getLotProduit() {
        return lotProduit;
    }

    public int getpAchatProduit() {
        return pAchatProduit;
    }

    public int getpVenteProduit() {
        return pVenteProduit;
    }

    public int getQteProduit() {
        return qteProduit;
    }

    public String getFamilleProduit() {
        return familleProduit;
    }
}

