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

    public abstract void getOrganization();

}



