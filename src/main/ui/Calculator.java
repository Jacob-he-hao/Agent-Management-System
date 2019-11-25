package ui;


import java.io.IOException;

import exception.NoSuchOperationException;
import observer.Counter;

import java.util.Scanner;

//Represents a calculator
public class Calculator {
    private Scanner scanner;


    //Effects: construct a calculator with an empty scanner
    private Calculator() throws IOException, NoSuchOperationException {
        Counter counter = new Counter();
        scanner = new Scanner(System.in);
        System.out.println("Welcome to Agent Calculator!");
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What would you like to do? "
                + "(Add/Drop/Search/Search Recruited/Print Tag Map for agents or Over)");
        while (true) {
            String operation;
            operation = scanner.nextLine();
            if (!operation.equals("Over")) {
                try {
                    new OriginalState(name, operation, counter);
                } catch (NoSuchOperationException e) {
                    System.out.println("Not available function");
                } finally {
                    System.out.println("The next operation?");
                }
            }

        }
    }

    public static void main(String[] args) throws IOException, NoSuchOperationException {
        new Calculator();
    }
}


