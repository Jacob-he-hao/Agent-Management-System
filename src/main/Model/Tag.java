package model;

import java.util.*;


public class Tag  {
    private String name;
    private Agentlist agentlist;
    private Map<String, Set<Agent>> tags = new HashMap<>();

    public Tag(String name) {
        this.name = name;
        this.agentlist = new Agentlist();
    }


    public String getName() {
        return name;
    }

    public Agentlist getAgentList() {
        return agentlist;
    }

    //MODIFIES: this
    //EFFECTS: add an agent to this tag's agent list
    public void addAgent(Agent agent) {
        if (!agentlist.contains(agent)) {
            agentlist.add(agent);
            agent.addTag(this);
        }
    }


    //MODIFIES: this
    //EFFECTS: remove an agent from this tag's agent list
    public void removeAgent(Agent agent) {
        if (agentlist.contains(agent)) {
            agentlist.remove(agent);
            agent.removeTag(this);
        }
    }

}
