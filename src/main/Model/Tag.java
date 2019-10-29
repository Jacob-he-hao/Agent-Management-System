package model;

import java.util.*;

public class Tag {

    String name;
    Agentlist agentlist;
    private Map<String, Set<Agent>> tags = new HashMap<>();

    public Tag(String name, Agentlist agentlist) {
        this.name = name;
        this.agentlist = agentlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;
        return name.equals(tag.name)
                && agentlist.equals(tag.agentlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,agentlist);
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
        }
    }

    public void removeAgent(Agent agent) {
        if (agentlist.contains(agent)) {
            agentlist.remove(agent);
            agent.removeTag(this);
        }
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

    public Set<Agent> agentWithTheTag(String tagName) {
        return tags.get(tagName);
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
