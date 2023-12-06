package fr.hulkug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solver {
    private String fileName;
    private final int maxBlue;
    private final int maxGreen;
    private final int maxRed;

    public Solver(String fileName, int maxBlue, int maxGreen, int maxRed) {
        this.fileName = fileName;
        this.maxBlue = maxBlue;
        this.maxGreen = maxGreen;
        this.maxRed = maxRed;
    }

    public void SolvePart1() throws IOException {
        String file = getClass().getClassLoader().getResource(fileName).getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        int sumIds = 0;
        while (currentLine != null){
//            System.out.println(currentLine);
            currentLine = currentLine.toLowerCase();
            String id = "";
            boolean validLine = true;
            int i;
            for (i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))){
                    id += currentLine.charAt(i);
                } else if (Character.toString(currentLine.charAt(i)).equals(":")) {
                    break;
                }
            }

            String currentNumber = "";
            for (int j = i ; j < currentLine.length(); j++) {
                char currentChar = currentLine.charAt(j);
                if(Character.isDigit(currentChar)){
                    currentNumber += Character.getNumericValue(currentChar);
                } else if (Character.toString(currentChar).equals("r") && Integer.parseInt(currentNumber) > maxRed) {
                    validLine = false;
//                    System.out.println(currentLine);
                    break;
                } else if (Character.toString(currentChar).equals("g") && Integer.parseInt(currentNumber) > maxGreen) {
                    validLine = false;
//                    System.out.println(currentLine);
                    break;
                } else if (Character.toString(currentChar).equals("b") && Integer.parseInt(currentNumber) > maxBlue) {
                    validLine = false;
//                    System.out.println(currentLine);
                    break;
                } else if (Character.toString(currentChar).equals(",") || Character.toString(currentChar).equals(";")) {
                    currentNumber = "";
                }
            }

            if (validLine){
//                System.out.println(currentLine);
                sumIds += Integer.parseInt(id);
            }
//            System.out.println(id);
            currentLine = reader.readLine();
        }
        System.out.println(sumIds);
        reader.close();
    }

    public void SolvePart2() throws IOException {
        String file = getClass().getClassLoader().getResource(fileName).getFile();
        System.out.println(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        int sumPowerSets = 0;
        while (currentLine != null){
//            System.out.println(currentLine);
            currentLine = currentLine.toLowerCase();
            currentLine = currentLine.replace("green","g");
            currentLine = currentLine.replace("red","r");
            currentLine = currentLine.replace("blue","b");
            String id = "";
            boolean validLine = true;
            int i;
            for (i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))){
                    id += currentLine.charAt(i);
                } else if (Character.toString(currentLine.charAt(i)).equals(":")) {
                    break;
                }
            }

            String currentNumber = "";
            int currentMaxRed = 0;
            int currentMaxGreen = 0;
            int currentMaxBlue = 0;
            for (int j = i ; j < currentLine.length(); j++) {
                char currentChar = currentLine.charAt(j);
                if(Character.isDigit(currentChar)){
                    currentNumber += Character.getNumericValue(currentChar);
                } else if (Character.toString(currentChar).equals("r") && Integer.parseInt(currentNumber) > currentMaxRed) {
                    currentMaxRed = Integer.parseInt(currentNumber);
//                    System.out.println(currentLine);
                } else if (Character.toString(currentChar).equals("g") && Integer.parseInt(currentNumber) > currentMaxGreen) {
                    currentMaxGreen = Integer.parseInt(currentNumber);
//                    System.out.println(currentLine);
                } else if (Character.toString(currentChar).equals("b") && Integer.parseInt(currentNumber) > currentMaxBlue) {
                    currentMaxBlue = Integer.parseInt(currentNumber);
//                    System.out.println(currentLine);
                } else if (Character.toString(currentChar).equals(";") || Character.toString(currentChar).equals(",")) {
                    currentNumber = "";
                }
            }
            sumPowerSets += currentMaxRed * currentMaxGreen * currentMaxBlue;
//            System.out.println(sumPowerSets);
            currentLine = reader.readLine();
        }
        System.out.println(sumPowerSets);
        reader.close();
    }
}
