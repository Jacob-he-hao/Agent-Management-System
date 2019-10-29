package model;

import exception.ImpossibleAgentException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents a list of agents
public class Operation  {
    private Agentlist recruitedAgents;
    private Agentlist rhineLifeAgents;
    private Agentlist rhodeIslandAgent;
    private File file;

    public Operation(Agentlist recruitedAgents, Agentlist rhineLifeAgents, Agentlist rhodeIslandAgent) {
        this.recruitedAgents = recruitedAgents;
        this.rhineLifeAgents = rhineLifeAgents;
        this.rhodeIslandAgent = rhodeIslandAgent;
        file = new File("data/allAgentList.txt");
    }

    //MODIFIES: this
    //EFFECTS: add the agent into recruitment list
    public void addAgent(String name) throws IOException, ImpossibleAgentException {
        if (rhineLifeAgents.contains(rhineLifeAgents.getAgent(name))) {
            recruitedAgents.add(rhineLifeAgents.getAgent(name));
            recruitedAgents.save(file);
            System.out.println("The agent has been added to your recruitment list!");
        } else if (rhodeIslandAgent.contains(rhodeIslandAgent.getAgent(name))) {
            recruitedAgents.add(rhineLifeAgents.getAgent(name));
            recruitedAgents.save(file);
            System.out.println("The agent has been added to your recruitment list!");
        } else {
            throw new ImpossibleAgentException();
        }

    }



    //MODIFIES: this
    //EFFECTS: return the information of the agent searched
    public void searchAgent(String name) throws ImpossibleAgentException {
        if (rhineLifeAgents.contains(rhineLifeAgents.getAgent(name))) {
            Agent a = rhineLifeAgents.getAgent(name);
            a.getOrganization();
        } else if (rhodeIslandAgent.contains(rhodeIslandAgent.getAgent(name))) {
            Agent a1 = rhodeIslandAgent.getAgent(name);
            a1.getOrganization();
        } else {
            throw new ImpossibleAgentException();
        }

    }







}

