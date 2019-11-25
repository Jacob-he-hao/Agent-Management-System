package model;

import exception.ImpossibleAgentException;
import exception.ImpossibleAgentInListException;
import exception.NoSuchOrganizationException;
import java.io.File;
import java.io.IOException;
import java.util.*;


// Represents a list of agents
public class Operation extends Observable {
    private Agentlist agents;
    private Agentlist recruitedAgents;
    private Agentlist rhineLifeAgents;
    private Agentlist rhodeIslandAgent;
    private File file;
    private static Tag agentTag;

    public Operation(Agentlist recruitedAgents, Agentlist rhineLifeAgents, Agentlist rhodeIslandAgent) {
        this.recruitedAgents = recruitedAgents;
        this.rhineLifeAgents = rhineLifeAgents;
        this.rhodeIslandAgent = rhodeIslandAgent;
        agentTag = new Tag("");
        file = new File("data/allAgentList.txt");
    }


    //MODIFIES: this
    //EFFECTS: drop the agent which user asked from registeredCourses list
    public void dropAgent(String name) throws ImpossibleAgentException, IOException {
        recruitedAgents.load(file);
        if (recruitedAgents.contains(recruitedAgents.getAgent(name))) {
            recruitedAgents.remove(recruitedAgents.getAgent(name));
            recruitedAgents.save(file);
            System.out.println("The agent has been removed from your recruitment list!");
            notifyObservers();
        } else {
            throw new ImpossibleAgentException();
        }
    }

    //MODIFIES: this
    //EFFECTS: add the agent into recruitment list
    public void addAgent(String organization, String name) throws IOException, ImpossibleAgentException,
            NoSuchOrganizationException {
        agents = getOrganization(organization);
        if (rhineLifeAgents.contains(rhineLifeAgents.getAgent(name))) {
            recruitedAgents.add(rhineLifeAgents.getAgent(name));
            recruitedAgents.save(file);
            System.out.println("The agent has been added to your recruitment list!");
            notifyObservers();
        } else if (rhodeIslandAgent.contains(rhodeIslandAgent.getAgent(name))) {
            recruitedAgents.add(rhineLifeAgents.getAgent(name));
            recruitedAgents.save(file);
            System.out.println("The agent has been added to your recruitment list!");
            notifyObservers();
        } else {
            throw new ImpossibleAgentException();
        }

    }



    //MODIFIES: this
    //EFFECTS: return the information of the agent searched
    public void searchRecruited(String name) throws ImpossibleAgentInListException,
            IOException, ImpossibleAgentException {
        recruitedAgents.load(file);
        if (recruitedAgents.contains(recruitedAgents.getAgent(name))) {
            searchAgent(name);
        } else {
            throw new ImpossibleAgentInListException();
        }

    }


    //MODIFIES: this
    //EFFECTS: return the information of the agent searched
    public void searchAgent(String name) throws ImpossibleAgentException {
        if (rhineLifeAgents.contains(rhineLifeAgents.getAgent(name))) {
            Agent a = rhineLifeAgents.getAgent(name);
            a.getInfo();
        } else if (rhodeIslandAgent.contains(rhodeIslandAgent.getAgent(name))) {
            Agent a1 = rhodeIslandAgent.getAgent(name);
            a1.getInfo();
        } else {
            throw new ImpossibleAgentException();
        }

    }

    //EFFECTS: return the organization that is asked
    public Agentlist getOrganization(String faculty) throws NoSuchOrganizationException {
        switch (faculty) {
            default:
                throw new NoSuchOrganizationException();
            case "RhineLife" :
                return rhineLifeAgents;
            case "RhodeIsland" :
                return rhodeIslandAgent;
        }
    }

    //EFFECTS: return the overall tag-map to the audience
    public static void printTheMap() {

        Agent agent1 = new RhineLifeAgent("Texas", "Vanguard", 5);
        Agent agent2 = new RhineLifeAgent("Lapland", "Guard", 6);
        Agent agent3 = new RhineLifeAgent("BluePoison", "Shooter", 5);
        Agent agent4 = new RhineLifeAgent("Silence", "Medic", 5);
        Agent agent5 = new RhineLifeAgent("Bandit", "Vanguard", 3);
        Agent agent6 = new RhodeIslandAgent("Save", "Guard", 6);
        Agent agent7 = new RhodeIslandAgent("Pulse", "Vanguard", 4);
        Agent agent8 = new RhodeIslandAgent("Emiya", "Lava", 5);
        agentTag.addNewItems("support", agent1);
        agentTag.addNewItems("output", agent2);
        agentTag.addNewItems("output", agent3);
        agentTag.addNewItems("medicine", agent4);
        agentTag.addNewItems("support", agent5);
        agentTag.addNewItems("output", agent6);
        agentTag.addNewItems("support", agent7);
        agentTag.addNewItems("weaken", agent8);
        agentTag.print();
    }
}

