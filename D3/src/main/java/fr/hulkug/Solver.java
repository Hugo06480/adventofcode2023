package fr.hulkug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Solver {
    public void Solve() throws IOException {
        String file = getClass().getClassLoader().getResource("input.txt").getFile();
        char[][] charMatrix = createCharMatrixFromFile(file);

        int sumNumber = 0;
        for (int i = 0; i < charMatrix.length; i++) {
            String number = "";
            boolean isSymbolPresent = false;
            for (int j = 0; j < charMatrix[i].length; j++) {
                if(Character.isDigit(charMatrix[i][j]) && isSymbolPresent){
                    number += charMatrix[i][j];
                }
                else if(Character.isDigit(charMatrix[i][j])){

                    number += charMatrix[i][j];
                    // verification gauche
                    if (j - 1 >= 0 && !Character.isLetterOrDigit(charMatrix[i][j-1]) && !Character.toString(charMatrix[i][j-1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    // verification droite
                    if (j + 1 < charMatrix[i].length && !Character.isLetterOrDigit(charMatrix[i][j+1]) && !Character.toString(charMatrix[i][j+1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //haut gauche
                    if (j - 1 >= 0 && i - 1 >= 0 && !Character.isLetterOrDigit(charMatrix[i-1][j-1]) && !Character.toString(charMatrix[i-1][j-1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //haut milieu
                    if (i - 1 >= 0 && !Character.isLetterOrDigit(charMatrix[i-1][j]) && !Character.toString(charMatrix[i-1][j]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //haut droite
                    if (j + 1 < charMatrix[i].length && i - 1 >= 0 && !Character.isLetterOrDigit(charMatrix[i-1][j+1]) && !Character.toString(charMatrix[i-1][j+1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //bas gauche
                    if (j - 1 >= 0 && i + 1 < charMatrix.length && !Character.isLetterOrDigit(charMatrix[i+1][j-1]) && !Character.toString(charMatrix[i+1][j-1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //bas milieu
                    if (i + 1 < charMatrix.length && !Character.isLetterOrDigit(charMatrix[i+1][j]) && !Character.toString(charMatrix[i+1][j]).equals(".")) {
                        isSymbolPresent = true;
                    }
                    //bas droite
                    if (j + 1 < charMatrix[i].length && i + 1 < charMatrix.length && !Character.isLetterOrDigit(charMatrix[i+1][j+1]) && !Character.toString(charMatrix[i+1][j+1]).equals(".")) {
                        isSymbolPresent = true;
                    }
                } else if(!Character.isLetterOrDigit(charMatrix[i][j]) && isInteger(number) && isSymbolPresent){
                    sumNumber+=Integer.parseInt(number);
                    isSymbolPresent = false;
                    number = "";
                }
                else {
                    number = "";
                }
            }
            if(isInteger(number) && isSymbolPresent) {
                sumNumber += Integer.parseInt(number);
            }
        }
        System.out.println(sumNumber);

    }

    public static char[][] createCharMatrixFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int rowCount = 0;
            int colCount = 0;

            // Compter le nombre de lignes et de colonnes dans le fichier
            while (reader.readLine() != null) {
                rowCount++;
            }

            // Réinitialiser le lecteur pour relire le fichier
            reader.close();
            BufferedReader reader2 = new BufferedReader(new FileReader(filePath));

            // Lire la première ligne pour déterminer le nombre de colonnes
            String firstLine = reader2.readLine();
            if (firstLine != null) {
                colCount = firstLine.length();
            }

            // Créer la matrice de caractères
            char[][] charMatrix = new char[rowCount][colCount];
            BufferedReader matrixReader = new BufferedReader(new FileReader(filePath));

            for (int i = 0; i < rowCount; i++) {
                String line = matrixReader.readLine();
                charMatrix[i] = line.toCharArray(); // Convertir la ligne en un tableau de caractères
            }

            return charMatrix;
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // The string is not a valid integer
            return false;
        }
    }
}
