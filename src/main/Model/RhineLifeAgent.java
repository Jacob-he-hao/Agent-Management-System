package model;

public class RhineLifeAgent extends Agent {


    public RhineLifeAgent(String name, String job, int star) {
        super(name, job, star);
    }

    @Override
    public void getInfo() {
        System.out.println("Organization: RhineLife");
        System.out.println("Agent Name: " + getName());
        System.out.println("Agent Job: " + getJob());
        System.out.println("Star ranking: " + getStar());
    }
}
