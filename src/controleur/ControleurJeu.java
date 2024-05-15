//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controleur;
import modele.Tas;
import vue.Ihm;

public class ControleurJeu {

    private Ihm ihm;
    private final ConstructeurJeu constructeurJeu = new ConstructeurJeu(ihm);

    public ControleurJeu(Ihm ihm, Tas lesTas) {
        int type = this.ihm.IA();
        if (type == 1) {
            this.constructeurJeu.setJ1(this.ihm.nomJoueur("1"));
            this.constructeurJeu.setJ2(this.ihm.nomJoueur("2"));
            this.constructeurJeu.setType("JVJ");
        } else if (type == 0) {
            this.constructeurJeu.setJ1(this.ihm.nomJoueur("1"));
            this.constructeurJeu.setJ2("IA");
            this.constructeurJeu.setType("IA");


        this.constructeurJeu.setTas(this.ihm.nbLignes());
        this.constructeurJeu.setContrainte(this.ihm.contrainte());
        this.constructeurJeu.jouer();
    }
}

    public void commencerJeu() {
    }
}
