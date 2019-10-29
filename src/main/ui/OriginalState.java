package ui;

import exception.ImpossibleAgentException;
import exception.NoSuchOperationException;
import model.Agentlist;
import model.Operation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OriginalState {
    private Agentlist rhineLifeAgents;
    private Agentlist rhodeIslandAgent;
    private Agentlist recruitedAgents;

    public OriginalState(String operation) throws IOException, NoSuchOperationException {
        Scanner scanner = new Scanner(System.in);
        String name;
        rhineLifeAgents = new Agentlist();
        rhodeIslandAgent = new Agentlist();
        recruitedAgents = new Agentlist();
        File rhineLife = new File("data/RhineLife.txt");
        File rhodeIsland = new File("data/RholesIsland.txt");
        rhineLifeAgents.load(rhineLife);
        rhodeIslandAgent.load(rhodeIsland);
        Operation op = new Operation(recruitedAgents, rhineLifeAgents, rhodeIslandAgent);

        switch (operation) {
            case "Add":
                System.out.print("Please enter the name of the agent you want to add: ");
                name = scanner.nextLine();
                try {
                    op.addAgent(name);
                } catch (ImpossibleAgentException  e) {
                    System.out.println("This agent is not available");
                }
                break;


            case "Search":
                System.out.print("Please enter the name of the agent you want to search: ");
                String name1 = scanner.nextLine();
                try {
                    op.searchAgent(name1);
                } catch (ImpossibleAgentException  e) {
                    System.out.println("This agent is not available");
                }
                break;

            default:
                throw new NoSuchOperationException();


        }
    }
}

