package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nom_Art cannot be blank")
    private String Nom_Art;

    @Positive(message = "Qte must be a positive number")
    private int qte;

    @Positive(message = "Prix must be a positive number")
    private float prix;


    public Article() {
    }

    public Article(int id, String nom_Art, int qte, float prix) {
        this.id = id;
        Nom_Art = nom_Art;
        this.qte = qte;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_Art() {
        return Nom_Art;
    }

    public void setNom_Art(String nom_Art) {
        Nom_Art = nom_Art;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


}
