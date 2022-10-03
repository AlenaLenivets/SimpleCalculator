package Stepic.org;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws FileNotFoundException {
        String path1 = "input.txt";
        File file1 = new File(path1);
        Scanner sc1 = new Scanner (file1);
        String path2 = "output.txt";
        File file2 = new File(path2);
        PrintWriter pw = new PrintWriter(file2);
        while(sc1.hasNextLine()) {
            String Expression = sc1.nextLine();
            String[] symbols = Expression.split(" ");

            String op = symbols[1];

            try {
                double a = Double.parseDouble(symbols[0]);
                double b = Double.parseDouble(symbols[2]);

                if (b == 0.0 && op.equals("/")) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + "Error! Division by zero");
                    }
                } else if (op.equals("/") || op.equals("*") || op.equals("+") || op.equals("-")) {
                    switch (op) {
                        case "/" -> pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + a / b);
                        case "*" -> pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + a * b);
                        case "+" -> pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + a + b);
                        case "-" -> pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + Double.toString(a - b));
                    }
                } else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        pw.println(symbols[0] + " " + op + " " + symbols[2] +  " " + "=" + " " + "Operation Error!");
                    }
                }
            } catch (Exception e) {
                String c = symbols[0];
                String d = symbols[2];
                pw.println(c + " " + op + " " + d +  " " + "=" + " " + "Error! Not number");
            }

        }
        sc1.close();
        pw.close();
        }
    }

