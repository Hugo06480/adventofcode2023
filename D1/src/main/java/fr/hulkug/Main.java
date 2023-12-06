package fr.hulkug;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solver s1 = new Solver("input.txt");
        Solver s2 = new Solver("test1.txt");
        Solver s3 = new Solver("input.txt");
//        s1.SolvePart1();
//        s2.SolvePart2();
        s3.SolvePart2();
    }

}