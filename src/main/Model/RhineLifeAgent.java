package model;

public class RhineLifeAgent extends Agent {


    public RhineLifeAgent(String name, String job, int star) {
        super(name, job, star);
    }

    @Override
    public void getOrganization() {
        System.out.println("This is an agent from Rhine Life.");
    }
}
