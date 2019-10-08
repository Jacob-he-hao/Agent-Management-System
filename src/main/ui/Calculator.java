package ui;


import java.io.IOException;
import model.Agentlist;
import java.util.Scanner;

//Represents a calculator
public class Calculator {
    private Scanner scanner;

    //Effects: construct a calculator with an empty scanner
    private Calculator() throws IOException {
        scanner = new Scanner(System.in);
        Agentlist af1 = new Agentlist();
        System.out.println("Add or Search or Renderadd?");
        while (true) {
            String y = scanner.nextLine();
            switch (y) {
                case "Add":
                    System.out.print("Please enter the name of the agent you want to add: ");
                    String name = scanner.nextLine();
                    af1.addAgent(name);
                    break;
                case "Search":
                    System.out.print("Please enter the name of the agent you want to search: ");
                    String name1 = scanner.nextLine();
                    af1.searchAgent(name1);
                    break;
                case "Renderadd":
                    System.out.print("Please enter the job of the agent you want to render: ");
                    String job1 = scanner.nextLine();
                    System.out.print("Please enter the star of the agent you want to render: ");
                    Integer star1 = Integer.valueOf(scanner.nextLine());
                    af1.renderAddAgent(job1, star1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + y);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Calculator();
    }
}


