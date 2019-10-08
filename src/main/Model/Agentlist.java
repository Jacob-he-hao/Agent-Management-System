package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents a list of agents
public class Agentlist implements Savable,Loadable {
    private List<Agent> data;
    private List<Agent> availableagents;
    private List<Agent> recruitedAgents;

    @Override
    //MODIFIES: this
    //EFFECTS: load the data
    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            availableagents.add(new TopAgent(partsOfLine.get(0), partsOfLine.get(1),
                    Integer.parseInt(partsOfLine.get(2))));
            availableagents.add(new NormalAgent(partsOfLine.get(0), partsOfLine.get(1),
                    Integer.parseInt(partsOfLine.get(2))));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    private static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }


    public Agentlist() throws IOException {
        data = new ArrayList<>();
        availableagents = new ArrayList<>();
        recruitedAgents = new ArrayList<>();
        load();
//        availableagents.add(new Agent("Lapland", "Guard", 4));
//        availableagents.add(new Agent("Lava", "Guard", 3;));
//        availableagents.add(new Agent("Exusiai", "Guard", 5));
//        availableagents.add(new Agent("Saria", "Guard", 6));
    }

    //MODIFIES: this
    //EFFECTS: return true if the operation list have the agent with name in it
    public boolean containAgent(String name) {
        boolean b = false;
        for (Agent availableagent : availableagents) {
            if (availableagent.getName().equals(name)) {
                b = true;
                break;
            }
        }
        return b;
    }


    public void renderAddAgent(String job, Integer star) throws IOException {
        File file = new File("Recruitment list.txt");
        for (Agent availableagent : availableagents) {
            if (availableagent.getJob().equals(job)) {
                if (availableagent.getStar() >= star) {
                    recruitedAgents.add(availableagent);
                    save(file);
                    System.out.println("The agent has been added to your recruitment list!");
                } else {
                    System.out.println("Sorry this agent is not available.");
                    System.out.println("/");
                }
            }
        }
    }




    //MODIFIES: this
    //EFFECTS: add the agent into recruitment list
    public void addAgent(String name) throws IOException {
        File file = new File("Recruitment list.txt");
        if (containAgent(name)) {
            recruitedAgents.add(getAgent(name, "Available agents"));
            save(file);
            System.out.println("The agent has been added to your recruitment list!");
        } else {
            System.out.println("Sorry this agent is not available.");
            System.out.println("/");
        }

    }



    //MODIFIES: this
    //EFFECTS: return the information of the agent searched
    public void searchAgent(String name) {
        if (containAgent(name)) {
            Agent a1 = getAgent(name,"Available agents");
            System.out.println("Agent Name: " + a1.getName()
                    + "Job: " + a1.getJob()
                    + "Star: " + a1.getStar());
        } else {
            System.out.println("Sorry this agent is not available.");
        }

    }

    //MODIFIES: this
    //EFFECTS: return the agent with given name in the given list
    private Agent getAgent(String name, String listname) {
        Agent a = null;
        if (listname.equals("Recruited Agents")) {
            assert recruitedAgents != null;
            for (Agent recruitedagent : recruitedAgents) {
                if (recruitedagent.getName().equals(name)) {
                    a = recruitedagent;
                }
            }
        } else {
            assert availableagents != null;
            for (Agent availableagent : availableagents) {
                if (availableagent.getName().equals(name)) {
                    a = availableagent;
                }
            }
        }
        return a;
    }

    @Override
    //MODIFIES: this and file
    //EFFECTS: save the course into the file
    public void save(File f) throws IOException {
        File file = new File("Recruitment list.txt");
        List<String> lines = new ArrayList<>();
        for (Agent a2 : recruitedAgents) {
            lines.add(a2.getName() + " " + a2.getJob() + " " + a2.getStar() + " ");
            Files.write(f.toPath(), lines);
        }
    }


    public void add(Agent otheragent) {
        availableagents.add(otheragent);
    }

    public Agent get(int n) {
        return availableagents.get(n);
    }

    // MODIFIES: this
    // EFFECTS: Agent i is added to the Agent list if it's not
    // already in the list
    public void insert(Agent i) {
        if (!contains(i)) {
            data.add(i);
        }
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



