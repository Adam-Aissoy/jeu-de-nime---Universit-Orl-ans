package com.company;
import controleur.ControleurJeu;
import vue.Ihm;
import modele.*;
import controleur.*;

public class Main {
    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        ConstructeurJeu constructeurJeu = new ConstructeurJeu(ihm);
        constructeurJeu.construireJeu();
        Tas lesTas = constructeurJeu.getLesTas();
        ControleurJeu controleurJeu = new ControleurJeu(ihm, lesTas);
        controleurJeu.commencerJeu();
    }
}