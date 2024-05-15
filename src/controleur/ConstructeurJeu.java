//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controleur;

import com.company.ExceptionProjet;
import vue.Ihm;
import modele.*;

public class ConstructeurJeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Tas tas;
    private final Ihm ihm = new Ihm();
    private String type;

    public ConstructeurJeu(Ihm ihm) {
    }

    public void setJ1(String s) {
        this.joueur1 = new Joueur(s);
    }

    public void setJ2(String s) {
        this.joueur2 = new Joueur(s);
    }

    public void setTas(int i) {
        int[][] etat = new int[0][];
        this.tas = new Tas(i, etat);
    }

    private void affichePartie() {
        this.ihm.affiche(this.tas.getEtat());
    }

    public void setType(String type) {
        this.type = type;
    }

    public void jouer() {
        int i = 0;

        while(true) {
            if (this.tas.isGagner()) {
                this.ihm.gagner(this.tas.getJoueur().getNom());
                this.tas.getJoueur().addPartiesGagnees();
                if (this.ihm.rejouer()) {
                    int[][] etat = new int[0][];
                    this.tas = new Tas(this.ihm.nbLignes(), etat);
                    i = 0;
                } else {
                    this.ihm.resultat(this.joueur1, this.joueur2);
                    System.exit(0);
                }
            }

            if ((i & 1) == 0) {
                this.tas.setJoueur(this.joueur1);
            } else {
                this.tas.setJoueur(this.joueur2);
            }

            boolean isValide = true;

            while(isValide) {
                try {
                    this.affichePartie();
                    if (this.type.equals("IA") && this.tas.getJoueur().getNom().contains("IA")) {
                        if (this.tas.getJoueur().getNom().contains("IAN")) {
                            this.tas.coup(this.tas.coupIAn(this.tas.getJoueur().getNom()));
                        } else {
                            this.tas.coup(this.tas.coupIA(this.tas.getJoueur().getNom()));
                        }

                        Thread.sleep(1000L);
                    } else if (this.type.equals("IA") && this.tas.getJoueur().getNom().contains("IA")) {
                        this.tas.coup(this.tas.coupIA(this.tas.getJoueur().getNom()));
                        Thread.sleep(1000L);
                    } else {
                        this.tas.coup(this.ihm.coup(this.tas.getJoueur().getNom()));
                    }

                    isValide = false;
                } catch (InterruptedException | ExceptionProjet var4) {
                    this.ihm.clearScreen();
                    this.ihm.invalideCoup(var4.getMessage());
                }
            }

            this.ihm.clearScreen();
            ++i;
        }
    }

    public void setContrainte(boolean contrainte) {
        this.tas.setContrainte(contrainte);
    }

    public void construireJeu() {
    }

    public Tas getLesTas() {
        return null;
    }
}
