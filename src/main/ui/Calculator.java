package ui;



import Model.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static int num;
    private Scanner scanner;




    public Calculator() {
        scanner = new Scanner(System.in);
    }


    public void processLoggings() {
        System.out.println("Please select an number (from 1 to 6):");
        num = Integer.parseInt(scanner.nextLine());
        System.out.println("you selected: " + num);
        scanner.nextLine();
    }

    public static List<Agent> Agents() {
        List<Agent> agents = new ArrayList<>();
        Agent agent1 = new Agent("Lapland", "Guard", 5);
        Agent agent2 = new Agent("Lava", "Caster", 3);
        Agent agent3 = new Agent("Exusiai", "Sniper", 6);
        Agent agent4 = new Agent("Saria", "Defender", 6);

        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);
        agents.add(agent4);

        return agents;
    }


    public static boolean pickAgent(){
        return num <=Agent.getStar();

    }

    public static void  main(String[] args) {
        Calculator Calculator=new Calculator();
        Calculator.processLoggings();
        List<Agent> agentName = Agents();
        for (int j = 0; j < agentName.size(); j++) {
            if(pickAgent()) {
                System.out.println(agentName.get(j));
            };
            System.out.println("");

        }

    }
}

