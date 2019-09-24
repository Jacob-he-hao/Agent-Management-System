package Model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of agents
public class Agentlist{

    private List<Agent> data;

    // EFFECTS: set is empty
    public Agentlist() {
        data = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Agent i is added to the Agent list if it's not
    // already in the list
    public void insert(Agent i) {
        if (!contains(i))
            data.add(i);
    }

    // REQUIRES: Agent i is an element of the Agentlist
    // MODIFIES: this
    // EFFECTS: Agent i is removed from the Agentlist
    public void remove(Agent i) {
        data.remove(i);
    }

    // EFFECTS: Returns true if Integer i is in the IntegerSet
    // and false otherwise
    public boolean contains(Agent i) {
        return data.contains(i);
    }

    // EFFECTS: Returns the number of items in the set
    public int size() {
        return data.size();
    }
}



