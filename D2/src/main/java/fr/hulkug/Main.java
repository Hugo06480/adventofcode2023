package fr.hulkug;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solver s1 = new Solver("input.txt", 14, 13, 12);
        Solver s2 = new Solver("input.txt", 14, 13, 12);
        s1.SolvePart1();
        s2.SolvePart2();
    }

}