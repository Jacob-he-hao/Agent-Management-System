package ui;



import Model.Agent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Represents a calculator
public class Calculator {
    private static int num;
    private Scanner scanner;
    private static String str;


    //Effects: construct a calculator with an empty scanner
    public Calculator() {
        scanner = new Scanner(System.in);
    }


    //MODIFIES: scanner
    //EFFECTS: scanner refreshed to give out the instruction
    public void processLoggings() {
        System.out.println("String or number?");
        if (scanner.nextLine().equals("String")) {
            System.out.println("Please select a string (guard/vanguard/defender):");
            str = scanner.nextLine();
            System.out.println("you selected: " + str);
        }
        System.out.println("Please select an number (from 1 to 6):");
        num = Integer.parseInt(scanner.nextLine());
        System.out.println("you selected: " + num);
    }

    //MODIFIES: this
    // EFFECTS: guard is a list of agents with the job "Guard"
    public static List<Agent> guard() {
        List<Agent> guard = new ArrayList<>();
        Agent agent1 = new Agent("Lapland", "Guard", 4);
        Agent agent2 = new Agent("Lava", "Guard", 3);
        Agent agent3 = new Agent("Exusiai", "Guard", 5);
        Agent agent4 = new Agent("Saria", "Guard", 6);

        guard.add(agent1);
        guard.add(agent2);
        guard.add(agent3);
        guard.add(agent4);

        return guard;
    }

    //MODIFIES: this
    // EFFECTS: guard is a list of agents with the job "Defender"
    public static List<Agent> defender() {
        List<Agent> defender = new ArrayList<>();
        Agent agent5 = new Agent("Lapland", "Defender", 4);
        Agent agent6 = new Agent("Lava", "Defender", 3);
        Agent agent7 = new Agent("Exusiai", "Defender", 5);
        Agent agent8 = new Agent("Saria", "Defender", 6);

        defender.add(agent5);
        defender.add(agent6);
        defender.add(agent7);
        defender.add(agent8);

        return defender;
    }
    //MODIFIES: this
    // EFFECTS: guard is a list of agents with the job "Vanguard"

    public static List<Agent> vanguard() {
        List<Agent> vanguard = new ArrayList<>();
        Agent agent9 = new Agent("Lapland", "Vanguard", 4);
        Agent agent10 = new Agent("Lava", "Vanguard", 3);
        Agent agent11 = new Agent("Exusiai", "Vanguard", 5);
        Agent agent12 = new Agent("Saria", "Vanguard", 6);

        vanguard.add(agent9);
        vanguard.add(agent10);
        vanguard.add(agent11);
        vanguard.add(agent12);

        return vanguard;
    }

    //EFFECTS: return the list of agent with certain job
    public List<Agent> renderJob() {
        if (str.equals("guard")) {
            return guard();
        } else if (str.equals("vanguard")) {
            return vanguard();
        } else if (str.equals("defender")) {
            return defender();
        }
        return null;
    }









    public static void  main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.processLoggings();
        List<Agent> job = calculator.renderJob();
        Agent agentFinal;
        for (int j = 0; j < job.size(); j++) {
            agentFinal = job.get(j);
            String okay = agentFinal.pickQualified(agentFinal, num);
            System.out.println(okay);
        }
        System.out.println("Over");
    }
}

