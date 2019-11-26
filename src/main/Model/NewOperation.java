package model;

import exception.ImpossibleAgentException;
import exception.ImpossibleAgentInListException;


import java.io.*;

public class NewOperation {
    private Agentlist recruitedAgents;
    private Agentlist rhineLifeAgents;
    private Agentlist rhodeIslandAgent;
    private File file;

    public NewOperation(Agentlist recruitedAgents, Agentlist rhineLifeAgents, Agentlist rhodeIslandAgent) {
        this.recruitedAgents = recruitedAgents;
        this.rhineLifeAgents = rhineLifeAgents;
        this.rhodeIslandAgent = rhodeIslandAgent;
        file = new File("data/recruitedAgent.txt");



    }

    //MODIFIES: this
    //EFFECTS: add the agent into recruitment list
    public void addAgent(String organization, String name) throws IOException, ImpossibleAgentException {
        if (organization.equals("RhineLife") && rhineLifeAgents.contains(rhineLifeAgents.getAgent(name))) {
            recruitedAgents.add(rhineLifeAgents.getAgent(name));
            recruitedAgents.save(file);
        } else if (organization.equals("RhodeIsland") && rhodeIslandAgent.contains(rhodeIslandAgent.getAgent(name))) {
            recruitedAgents.add(rhodeIslandAgent.getAgent(name));
            recruitedAgents.save(file);
        } else {
            throw new ImpossibleAgentException();
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

    //MODIFIES: this
    //EFFECTS: return the information of the agent searched
    public void searchRecruited(String name)
            throws ImpossibleAgentInListException, ImpossibleAgentException, IOException {
        recruitedAgents.load(file);
        if (recruitedAgents.contains(recruitedAgents.getAgent(name))) {
            searchAgent(name);
        } else {
            throw new ImpossibleAgentInListException();
        }

    }


}
