package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//JPA...
//H2 en mémoire...
//philosophie maven: spring boot
import java.util.ArrayList;

@RestController
public class MyApi {

    public static ArrayList<Etudiant> liste = new ArrayList();

    static {
        liste.add(new Etudiant(0, "A",19));
        liste.add(new Etudiant(1, "A",19));
        liste.add(new Etudiant(2, "A",19));
        liste.add(new Etudiant(3, "A",19));
    }

    @GetMapping(value ="/liste")
    public Collection<Etudiant> getAllEtudiant() {
        return liste;
    }

    @GetMapping(value ="/getEtudiant")
    public Etudiant getEtudiant(int identifiant) {
        return liste.get(identifiant);
    }

    @PostMapping(value ="/addEtudiant")
    public Etudiant addEtudiant(Etudiant etudiant) {
        liste.add(etudiant);
        return etudiant;
    }

    @PutMapping(value ="/modifierEtudiant")
    public void modifierEtudiant(int identifiant, String nom) {
        liste.get(identifiant).setNom(nom);
    }

    @DeleteMapping(value ="/supprimerEtudiant")
    public void supprimerEtudiant(int identifiant) {
        liste.remove(identifiant);
    }




    @GetMapping(value ="/b")
    public String bonjour(){
        return "Bonjour!";
    }





    @GetMapping(value ="/bn")
    public String bonsoir(){
        return "Bonsoir!";
    }

    @GetMapping(value ="Etudiant")
    public Etudiant getEtudiant(){
        return new Etudiant( 1, "A", 19);
    }

    @GetMapping(value ="somme")
    public double somme(double a, double b){
        return a+b;
    }
}

