package ui;


import java.io.IOException;

import exception.ImpossibleAgentException;
import exception.NoSuchOperationException;
import exception.NotGoingOnException;
import model.*;

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
        Tag tag = new Tag("support");
        Employer employer = new Employer("Ryan");
        Employer employer1 = new Employer("WeiDun");
        Agent agent = new RhineLifeAgent("k", "Guard", 4);
        Agent agent1 = new RhineLifeAgent("h", "Vanguard", 5);
        Counter counter = new Counter();
        tag.addAgent(agent);
        tag.addAgent(agent1);
        tag.addObserver(counter);
        tag.addEmployer(employer);
        tag.addEmployer(employer1);
        new Calculator();
    }
}


