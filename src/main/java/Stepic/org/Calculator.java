package Stepic.org;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String Expression = sc.nextLine();
        String [] symbols = Expression.split(" ");

        String op = symbols[1];

            try {
                double a = Double.parseDouble(symbols[0]);
                double b = Double.parseDouble(symbols[2]);

                if (b == 0.0 && op.equals("/")) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Error! Division by zero");
                    }
                } else if (op.equals("/") || op.equals("*") || op.equals("+") || op.equals("-")) {
                    switch (op) {
                        case "/" -> System.out.println(a / b);
                        case "*" -> System.out.println(a * b);
                        case "+" -> System.out.println(a + b);
                        case "-" -> System.out.println(a - b);
                    }
                } else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Operation Error!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error! Not number");
            }
        }
    }

