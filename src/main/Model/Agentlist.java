package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

// Represents a list of agents
public class Agentlist implements List {
    private Agent agent;
    private ArrayList<Agent> list;

    public Agentlist() {
        list = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Agent i is added to the Agent list
    public void add(Agent agent) {
        list.add(agent);
    }

    public Agent get(int n) {
        return list.get(n);
    }


    // REQUIRES: Agent i is an element of the Agentlist
    // MODIFIES: this
    // EFFECTS: Agent i is removed from the Agentlist
    public void remove(Agent i) {
        list.remove(i);
    }

    // EFFECTS: Returns true if Integer i is in the IntegerSet
    // and false otherwise
    public boolean contains(Agent i) {
        return list.contains(i);
    }

    // EFFECTS: Returns the number of items in the set
    public int size() {
        return list.size();
    }


    //MODIFIES: this and file
    //EFFECTS: save the course into the file
    public void save(File file) throws IOException {
        java.util.List<String> lines = new ArrayList<>();
        for (Agent a2 : list) {
            lines.add(a2.getName() + " " + a2.getJob() + " " + a2.getStar());
            Files.write(file.toPath(), lines);
        }
    }


    //MODIFIES: this
    //EFFECTS: load the data
    public void load(File file) throws IOException {
        java.util.List<String> lines = Files.readAllLines(file.toPath());
        PrintWriter writer = new PrintWriter("data/outputfile.txt", "UTF-8");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            list.add(new RhineLifeAgent(partsOfLine.get(0), partsOfLine.get(1),
                    Integer.parseInt(partsOfLine.get(2))));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    private static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }



    //MODIFIES: this
    //EFFECTS: return the agent with given name in the given list
    public  Agent getAgent(String name) {
        for (Agent a : list) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }


}



