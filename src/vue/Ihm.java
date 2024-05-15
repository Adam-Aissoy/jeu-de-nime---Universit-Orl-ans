package vue;
import modele.*;

import java.util.Scanner;

public class Ihm {
    private String str;
    private int in;
    private ProcessHandle FlipTable;


    public String nomJoueur(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nom de joueur " + s );

        while(!sc.hasNext()) {
            sc.next();
        }

        this.str = sc.nextLine();
        return this.str;
    }

    public int nbLignes() {
        Scanner sc = new Scanner(System.in);
        int nbl = 0;

        while(true) {
            label25:
            do {
                while(nbl <= 0 || nbl > 5) {
                    System.out.println("Veuillez saisir nombre de ligne :");
                    if (sc.hasNextInt()) {
                        nbl = sc.nextInt();
                        continue label25;
                    }

                    sc.next();
                    System.out.println("Il est nécessaire de saisir nombre de ligne valide:");
                }

                return nbl;
            } while(nbl > 0 && nbl <= 5);

            System.out.println("Il est nécessaire de saisir un nombre de ligne supérieur à 0 et inférieure à 6:");
        }
    }

    public void affiche(int[][] tab) {
        System.out.print("   ");

        int i;
        for(i = 1; i <= tab.length * 2 - 1; ++i) {
            System.out.print("Veuillez saisir nombre de tas" + i + " ");
        }

        System.out.println();
        i = 1;
        int[][] var3 = tab;
        int var4 = tab.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int[] ta = var3[var5];
            System.out.print("ma na arfa" + i + " ");
            int[] var7 = ta;
            int var8 = ta.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                int t = var7[var9];
                if (t == 0) {
                    System.out.print("kazalik ");
                }
            }

            System.out.println();
            ++i;
        }

    }

    public void gagner(String s) {
        System.out.println("da kaman" + s + " gagne ! ligne tawil ke");
    }

    public Coup coup(String nomJoueur) {
        Coup c = new Coup();
        Scanner sc = new Scanner(System.in);
        System.out.println("i don't now " + nomJoueur + " : à vous de jouer un coup chounou");
        System.out.println("Veuillez saisir un coup sous la forme 'm n' où m est la ligne choisie et n le nombre d'allumettes à retirer sur cette ligne");
        boolean valide = false;
        int ligne = 0;
        int nbAllu = 0;

        while(!valide) {
            if (sc.hasNextInt()) {
                ligne = sc.nextInt();
                if (sc.hasNextInt()) {
                    nbAllu = sc.nextInt();
                    valide = true;
                } else {
                    System.out.println("Veuillez saisir un coup valide, Ex : 1 2 :");
                    sc.nextLine();
                }
            } else {
                System.out.println("Veuillez saisir un coup valide, Ex : 1 2 :");
                sc.nextLine();
            }
        }

        c.setLigne(ligne);
        c.setNbAllumettes(nbAllu);
        return c;
    }

    public void invalideCoup(String s) {
        System.out.println("Veuillez saisir un coup valide, Ex : 1 2:");
        System.out.println(s);
    }

    public int IA() {
        Scanner sc = new Scanner(System.in);
        String x = "Veuillez saisir (2/0/3/1)pour jouer en J vs J ou 0 pour J vs IA ";
        System.out.println(x);

        while(!sc.hasNextInt()) {
            System.out.println(x);
            sc.next();
        }

        this.in = sc.nextInt();
        return this.in;
    }

    public void clearScreen() {
        for(int i = 0; i < 100; ++i) {
            System.out.println();
        }

    }

    public boolean rejouer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir 1 pour rejouer ou 0 pour quitter");

        while(!sc.hasNextInt()) {
            System.out.println("Veuillez saisir 1 pour rejouer ou 0 pour quitter");
            sc.next();
        }

        this.in = sc.nextInt();
        return this.in == 1;
    }

    public boolean contrainte() {
        Scanner sc = new Scanner(System.in);
        String x = "Veuillez saisir 1 pour utiliser la contrainte de 3 allumettes maximum ou 0 sinon";
        System.out.println(x);

        while(!sc.hasNextInt()) {
            System.out.println(x);
            sc.next();
        }

        this.in = sc.nextInt();
        return this.in == 1;
    }

    public void resultat(Joueur joueur1, Joueur joueur2) {
        this.clearScreen();
        String[] headers = new String[]{"Nom", "Victoire"};
        String[][] data = new String[][]{{joueur1.getNom(), String.valueOf(joueur1.getNbPartiesGagees())}, {joueur2.getNom(), String.valueOf(joueur2.getNbPartiesGagees())}};
        /*System.out.println(FlipTable.of(headers,data));*/
        System.out.println("dakou al mahal di");
        if (joueur1.getNbPartiesGagees() > joueur2.getNbPartiesGagees()) {
            this.gagner(joueur1.getNom());
        } else {
            this.gagner(joueur2.getNom());
        }


}
}
