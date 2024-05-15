//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package modele;


import com.company.ExceptionProjet;

public class Tas {
    private final int[][] etat;
    private Joueur joueur;
    private boolean contrainte = false;

    Tas(int nbLignes) {
        this.etat = new int[nbLignes][];

        for(int i = 1; i < this.etat.length + 1; ++i) {
            this.etat[i - 1] = new int[2 * i - 1];
        }

    }

    public Tas(int i, int[][] etat) {
        this.etat = etat;
    }

    private int[] convertTab() {
        int[] tab = new int[this.etat.length];
        int v = 0;
        int[][] var4 = this.etat;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            int[] x = var4[var6];
            int c = 0;
            int[] var8 = x;
            int var9 = x.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                int y = var8[var10];
                if (y == 0) {
                    ++c;
                }
            }

            tab[v] = c;
            ++v;
        }

        return tab;
    }

    public int[][] getEtat() {
        return this.etat;
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    private boolean isExiste() {
        int[][] var1 = this.etat;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int[] ints = var1[var3];
            int[] var5 = ints;
            int var6 = ints.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                int anInt = var5[var7];
                if (0 == anInt) {
                    return true;
                }
            }
        }

        return false;
    }

    public void coup(Coup c) throws ExceptionProjet {
        int y = 0;
        int i = 0;
        int nbLigne = c.getLigne() - 1;
        int nbAllumettes = c.getNbAllumettes();
        if (nbLigne >= 0 && nbLigne <= this.getEtat().length) {
            for(; i < this.getEtat()[nbLigne].length && y < nbAllumettes; ++i) {
                if (this.getEtat()[nbLigne][i] != 1) {
                    ++y;
                }
            }

            if (nbAllumettes != y) {
                throw new ExceptionProjet("Pas assez d'allumettes sur la ligne");
            } else if (this.contrainte && nbAllumettes > 3) {
                throw new ExceptionProjet("La contrainte de 3 allumettes n'est pas respecté ");
            } else {
                y = 0;

                for(i = 0; i < this.getEtat()[nbLigne].length && y < nbAllumettes; ++i) {
                    if (this.getEtat()[nbLigne][i] != 1) {
                        this.getEtat()[nbLigne][i] = 1;
                        ++y;
                    }
                }

            }
        } else {
            throw new ExceptionProjet("Ligne invalide");
        }
    }

    public Coup coupIA(String s) throws InterruptedException {
        int nblignes = this.etat.length;
        int ouexcl = 0;
        Coup c = new Coup();

        int l;
        for(l = 0; l < nblignes; ++l) {
            ouexcl ^= this.convertTab()[l];
        }

        if (ouexcl != 0) {
            for(l = 0; l < nblignes; ++l) {
                int nbAllumette = this.convertTab()[l];
                int res = ouexcl ^ nbAllumette;
                if (nbAllumette >= res) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(nbAllumette - res);
                    if (!this.contrainte || nbAllumette <= 3) {
                        break;
                    }

                    for(int y = 0; y < nblignes; ++y) {
                        if (this.convertTab()[y] > 0) {
                            c.setLigne(y + 1);
                            c.setNbAllumettes(1);
                            break;
                        }
                    }
                }
            }
        } else {
            for(l = 0; l < nblignes; ++l) {
                if (this.convertTab()[l] > 0) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(1);
                    break;
                }
            }
        }

        System.out.println("\u001b[0;33m" + s + " : à vous de jouer un coup\u001b[0m");
        Thread.sleep(1000L);
        System.out.println("\u001b[0;32m" + c.toString());
        return c;
    }

    public Coup coupIAn(String s) throws InterruptedException {
        Coup c = new Coup();
        boolean valide = false;

        while(true) {
            int ligne;
            int nbAllu;
            do {
                do {
                    if (valide) {
                        System.out.println("\u001b[0;33m" + s + " : à vous de jouer un coup\u001b[0m");
                        Thread.sleep(1000L);
                        System.out.println("\u001b[0;32m" + c.toString());
                        return c;
                    }

                    ligne = (int)Math.floor(Math.random() * (double)this.etat.length) + 1;
                } while(this.convertTab()[ligne - 1] == 0);

                nbAllu = (int)Math.floor(Math.random() * (double)(this.convertTab()[ligne - 1] - 1)) + 1;
            } while(this.contrainte && nbAllu > 3);

            c.setNbAllumettes(nbAllu);
            c.setLigne(ligne);
            valide = true;
        }
    }

    public boolean isGagner() {
        return !this.isExiste();
    }

    public void setContrainte(boolean contrainte) {
        this.contrainte = contrainte;
    }

    public boolean getContrainte() {
        return this.contrainte;
    }
}
