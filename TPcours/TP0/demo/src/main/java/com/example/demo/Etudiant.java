package com.example.demo;

public class Etudiant {
    private int identifiant;
    private String nom;
    private double moyenne;

    public Etudiant(){

    }

    public Etudiant(int identifiant, String nom, double moyenne) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.moyenne = moyenne;
    }
}
