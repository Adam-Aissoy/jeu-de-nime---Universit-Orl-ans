package transformationDonnees;

import java.io.*; // On importe le package java.io permettant les entrées et sorties systèmes

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;


public class RecuperateurDonnees {
    private Sheet sheet;

    public RecuperateurDonnees(String path) {
        final File file = new File(path);

        try {
            this.sheet = SpreadSheet.createFromFile(file).getSheet(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] readOds () {
        //On crée la variable contenant le tableau
        String[][] tableau = new String[this.sheet.getColumnCount()][this.sheet.getRowCount()];

        // On insert les éléments dans le tableau
        for(int i = 0; i < this.sheet.getColumnCount(); i++){

            for (int j = 0; j < this.sheet.getRowCount(); j++){
                tableau[i][j] = this.sheet.getCellAt(i,j).getValue().toString();

            }
        }

        return tableau;
    }

}
