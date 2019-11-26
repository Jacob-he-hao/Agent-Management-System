package model;

import java.util.Objects;

//Represents an agent
public abstract class Agent  {
    private int star;
    private int numEmployers;
    private String name;
    private String job;
    private Taglist tagList;


    //Construct an agent
    //EFFECTS: agent with name, string and star
    public Agent(String name, String job, int star) {
        this.name = name;
        this.job = job;
        this.star = star;
        this.tagList = new Taglist();
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

    public Taglist getTagList() {
        return tagList;
    }

    public abstract void getInfo();

    public abstract void getInfoOne();


    //MODIFIES: this
    //EFFECTS: add a tag to this agent
    public void addTag(Tag tag) {
        if (!tagList.contains(tag)) {
            tagList.add(tag);
            tag.addAgent(this);
        }
    }

    //MODIFIES: this
    //EFFECTS: remove a tag from this agent
    public void removeTag(Tag tag) {
        if (tagList.contains(tag)) {
            tagList.remove(tag);
            tag.removeAgent(this);
        }
    }

    public String toString() {
        return name + "-" + job + "-" + star;
    }

}





