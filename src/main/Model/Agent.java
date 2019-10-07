package model;

//Represents an agent
public abstract class Agent {
    private int star;
    private String name;
    private String job;

    //Construct an agent
    //EFFECTS: agent with name, string and star
    public Agent(String name, String job, int star) {
        this.name = name;
        this.job = job;
        this.star = star;
    }


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getStar() {
        return star;
    }

    // Determines if the agent have met the requirements of star rankings
    // EFFECTS:  Return true if the agent has higher or the same star ranking than the criteria,
    //           false otherwise

    public boolean qualified(Agent i, Integer num) {
        if (i.getStar() < num) {
            return false;
        }
        return true;
    }

    //Get the qualified agent's name
    //EFFECTS: Return the name of the qualified agent, "None" for unqualified agent
    public String pickQualified(Agent i, Integer num) {
        if (qualified(i, num)) {
            return i.getName();
        }
        return null;
    }
}



