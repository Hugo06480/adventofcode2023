package fr.hulkug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    String fileName;

    public Solver(String fileName) {
        this.fileName = fileName;
    }

    public void Solve() throws IOException {
        String file = getClass().getClassLoader().getResource(fileName).getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        int sum = 0;
        while (currentLine != null){
//            System.out.println(currentLine);
            String number = "";
            for ( int i = 0 ; i < currentLine.length() ; i++){
                char currentChar = currentLine.charAt(i);
                if (Character.isDigit(currentChar)) {
                    number += currentChar;
                    break;
                }
            }
            for ( int i = currentLine.length() - 1 ; i >= 0 ; i--){
                char currentChar = currentLine.charAt(i);
                if (Character.isDigit(currentChar)) {
                    number += currentChar;
                    break;
                }
            }
            sum += Integer.parseInt(number);
            System.out.println(number);
            currentLine = reader.readLine();
        }
        System.out.println(sum);
        reader.close();
    }
}
