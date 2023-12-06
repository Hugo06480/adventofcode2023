package fr.hulkug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    String fileName;

    public Solver(String fileName) {
        this.fileName = fileName;
    }

    public void SolvePart1() throws IOException {
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

    public void SolvePart2() throws IOException{
        String file = getClass().getClassLoader().getResource(fileName).getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        Map<String, String> numberLettered = Map.of("one", "on1e", "two", "tw2o", "three", "thr3ee", "four", "fo4ur", "five", "fi5ve", "six", "si6x", "seven", "sev7en", "eight", "eig8ht", "nine", "ni9ne");
        int sum = 0;
        while (currentLine != null){
            String number = "";
            for (Map.Entry<String, String> entry : numberLettered.entrySet()) {
                currentLine = currentLine.replace(entry.getKey(), entry.getValue());
            }
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
