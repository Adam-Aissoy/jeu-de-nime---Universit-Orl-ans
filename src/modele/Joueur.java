package modele;

import vue.Ihm;
import modele.*;
import controleur.*;
import com.company.ExceptionProjet;
public class Joueur {
    private final String nom;
    private int nbPartiesGagees;

    public Joueur(String nom) {
        this.nom = nom;
        this.nbPartiesGagees = 0;
    }

    public String getNom() {
        return this.nom;
    }

    public void addPartiesGagnees() {
        ++this.nbPartiesGagees;
    }

    public int getNbPartiesGagees() {
        return this.nbPartiesGagees;
    }
}
