package main;

import transformationDonnees.RecuperateurDonnees;

public class Main {	 // 		/!\ La bibliothèque utilisée est compatible jusqu'à OpenDocument 1.2 /!\

    public static void main(String[] args) {
	RecuperateurDonnees recuperateurDonnees = new RecuperateurDonnees("C:/Users/matth/Desktop/CDApp/Exemple/MonExemple.ods");
	String[][] tableau = recuperateurDonnees.readOds();

	// Provisoire à partir d'ici
	System.out.println(tableau[0][0]);
	System.out.println(tableau[3][6]);
	System.out.println("nb of column : " + tableau.length);
	System.out.println("nb of row : " + tableau[0].length);

	// Test affichage tableau
		String str ="";
		for(int i = 0; i < tableau[0].length; i++){
			for(int j = 0; j < tableau.length; j++){
				str+=" | " + tableau[j][i];
			}
				str+=" | \n";
		}
		System.out.println(str);
	}
}
