package ui;


import java.io.IOException;
import model.Agentlist;
import java.util.Scanner;

//Represents a calculator
public class Calculator {
    private Scanner scanner;

    //Effects: construct a calculator with an empty scanner
    public Calculator() {
        scanner = new Scanner(System.in);

    }

    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();
        Agentlist af1 = new Agentlist();
        System.out.println("Add or Search or Renderadd?");
        if (calculator.scanner.nextLine().equals("Add")) {
            af1.addAgent();
        } else if (calculator.scanner.nextLine().equals("Search")) {
            af1.searchAgent();
        } else if (calculator.scanner.nextLine().equals("Renderadd")) {
            af1.renderAddAgent();
        }
    }
}



