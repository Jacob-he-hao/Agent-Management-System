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

    public Operation(Agentlist recruitedAgents, Agentlist rhineLifeAgents, Agentlist rhodeIslandAgent) throws IOException {
        this.recruitedAgents = recruitedAgents;
        this.rhineLifeAgents = rhineLifeAgents;
        this.rhodeIslandAgent = rhodeIslandAgent;
        agentTag = new Tag("");
        file = new File("data/allAgentList.txt");

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
    public void searchRecruited(String name) throws ImpossibleAgentInListException, ImpossibleAgentException {
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


}


