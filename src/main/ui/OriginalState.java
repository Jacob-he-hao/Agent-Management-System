package ui;

import exception.ImpossibleAgentException;
import exception.ImpossibleAgentInListException;
import exception.NoSuchOperationException;
import exception.NoSuchOrganizationException;
import model.Agentlist;
import model.Operation;


import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class OriginalState extends Observable {
    private Agentlist rhineLifeAgents;
    private Agentlist rhodeIslandAgent;
    private Agentlist recruitedAgents;

    public OriginalState(String name, String operation, Observer observer) throws IOException,
            NoSuchOperationException {
        Scanner scanner = new Scanner(System.in);
        String agentName;
        String organization;
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
                observer.update(op, null);
                System.out.print("Please "
                        + "enter the organization of the agent you want to add (RhineLife or RhodeIsland): ");
                organization = scanner.nextLine();
                System.out.print("Please enter the name of the agent you want to add: ");
                agentName = scanner.nextLine();
                try {
                    op.addAgent(organization, agentName);
                } catch (ImpossibleAgentException e) {
                    System.out.println("This agent is not available!");
                } catch (NoSuchOrganizationException e) {
                    System.out.println("This organization is not available!");
                }
                break;


            case "drop":
                observer.update(op, null);
                System.out.print("Please enter the name of the agent you want to drop: ");
                agentName = scanner.nextLine();
                try {
                    op.dropAgent(agentName);
                } catch (ImpossibleAgentException e) {
                    System.out.println("You have not added this agent!");
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

            case "Search Recruited":
                System.out.print("Please enter the name of the agent you want to search in your list: ");
                String name2 = scanner.nextLine();
                try {
                    op.searchRecruited(name2);
                } catch (ImpossibleAgentException  e) {
                    System.out.println("This agent is not available");
                } catch (ImpossibleAgentInListException  e) {
                    System.out.println("This agent is not available in your recruitment list");
                }
                break;

            case "Print Tag Map":
                System.out.println("Your name is" + " " + name);
                Operation.printTheMap();
                break;



            default:
                throw new NoSuchOperationException();


        }
        addObserver(observer);
    }
}

