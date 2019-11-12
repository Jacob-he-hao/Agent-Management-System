package model;

import java.util.*;
import observer.Subject;

public class Tag extends Subject {
    private String name;
    private ArrayList<Employer> employerList;
    private Agentlist agentlist;
    private Map<String, Set<Agent>> tags = new HashMap<>();

    public Tag(String name) {
        this.name = name;
        this.agentlist = new Agentlist();
        this.employerList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Agentlist getAgentList() {
        return agentlist;
    }

    public void addAgent(Agent agent) {
        if (!agentlist.contains(agent)) {
            agentlist.add(agent);
            agent.addTag(this);
            addObserver(agent);
        }
    }

    public void removeAgent(Agent agent) {
        if (agentlist.contains(agent)) {
            agentlist.remove(agent);
            agent.removeTag(this);
            removeObserver(agent);
        }
    }

    public ArrayList<Employer> getEmployerList() {
        return employerList;
    }

    public void addEmployer(Employer e) {
        employerList.add(e);
        notifyObservers(e);
    }

    public void addNewItems(String tagName, Agent toAdd) {
        Set<Agent> agentHashSet = new HashSet<Agent>();
        if (!tags.containsKey(tagName)) {
            // Need to create a set of agents for the value
            // of the key in the map
            agentHashSet.add(toAdd);
            tags.put(tagName, agentHashSet);
        } else {
            // The course has recommendations for it,
            // add to the set.
            agentHashSet = tags.get(tagName);
            agentHashSet.add(toAdd);
        }
    }


    public void print() {
        for (Map.Entry<String, Set<Agent>> e : tags.entrySet()) {
            Set<Agent> agentHaveTheTag = e.getValue();
            for (Agent a : agentHaveTheTag) {
                System.out.println(e.getKey() + " -> " + a);
            }
        }
    }


}
