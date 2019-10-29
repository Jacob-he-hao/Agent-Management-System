package model;

public class RhodeIslandAgent extends Agent {

    public RhodeIslandAgent(String name, String job, int star) {
        super(name, job, star);
    }


    @Override
    public void getOrganization() {
        System.out.println("This is an agent from Rhode Island.");
    }
}