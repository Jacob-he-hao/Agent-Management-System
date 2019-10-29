package ui;


import java.io.IOException;

import exception.ImpossibleAgentException;
import exception.NoSuchOperationException;
import exception.NotGoingOnException;
import model.Agentlist;
import java.util.Scanner;

//Represents a calculator
public class Calculator {
    private Scanner scanner;

    //Effects: construct a calculator with an empty scanner
    private Calculator() throws IOException, NoSuchOperationException {
        scanner = new Scanner(System.in);
        System.out.println("Add or Search  or Print or Over?");
        while (true) {
            String operation;
            operation = scanner.nextLine();
            if (!operation.equals("Over")) {
                try {
                    new OriginalState(operation);
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


