package modele;
import vue.Ihm;
import modele.*;
import controleur.*;
import com.company.ExceptionProjet;
public class Coup {
    private int ligne;
    private int nbAllumettes;

    public Coup() {
    }

    int getLigne() {
        return this.ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    int getNbAllumettes() {
        return this.nbAllumettes;
    }

    public void setNbAllumettes(int nbAllumettes) {
        this.nbAllumettes = nbAllumettes;
    }

    public String toString() {
        return this.ligne + " " + this.nbAllumettes;
    }
}
