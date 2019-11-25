package model;

public class RhodeIslandAgent extends Agent {

    public RhodeIslandAgent(String name, String job, int star) {
        super(name, job, star);
    }


    @Override
    public void getInfo() {

        System.out.println("Organization: RhodeIsland");
        System.out.println("Agent Name: " + getName());
        System.out.println("Agent Job: " + getJob());
        System.out.println("Star ranking: " + getStar());

    }
}