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
        processlogggings();
    }


    public void processlogggings() {
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
        Agent agent5 = new Agent("Vigna", "Vanguard", 4);
        Agent agent6 = new Agent("Cuora", "Defender", 4);
        Agent agent7 = new Agent("Gravel", "Specialist", 4);
        Agent agent8 = new Agent("Castle", "Guard", 1);
        Agent agent9 = new Agent("Glaucus", "Supporter", 5);
        Agent agent10 = new Agent("Ptilopsis", "Medic", 5);
        Agent agent11 = new Agent("Meteorite", "Sniper", 5);
        Agent agent12 = new Agent("Gitano", "Caster", 4);
        Agent agent13 = new Agent("Midnight", "Guard", 3);
        Agent agent14 = new Agent("Myrtle", "Vanguard", 4);
        Agent agent15 = new Agent("Noir Corne", "Defender", 2);
        Agent agent16 = new Agent("Lancet", "Medic", 1);

        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);
        agents.add(agent4);
        agents.add(agent5);
        agents.add(agent6);
        agents.add(agent7);
        agents.add(agent8);
        agents.add(agent9);
        agents.add(agent10);
        agents.add(agent11);
        agents.add(agent12);
        agents.add(agent13);
        agents.add(agent14);
        agents.add(agent15);
        agents.add(agent16);
        return agents;
    }


    public static boolean pickagent(){
        return num >=Agent.getstar();

    }

    public static void  main(String[] args) {
        Calculator Calculator=new Calculator();
        Calculator.processlogggings();
        List<Agent> agentname = Agents();
        for (int j = 1; j <= agentname.size(); j++) {
            if(pickagent()) {
                System.out.println(agentname.get(j));
            };
            System.out.println("");

        }

    }
}

