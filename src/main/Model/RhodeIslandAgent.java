package model;

public class RhodeIslandAgent extends Agent {

    public RhodeIslandAgent(String name, String job, int star) {
        super(name, job, star);
    }

    //EFFECTS: get the information of RhineLife Agent
    @Override
    public void getInfo() {
        InfoBox.infoBox("Organization: RhodeIsland\n "
                + "Agent Name: " + getName() + "\n"
                + "Agent Job: " + getJob()+ "\n"
                + "Star ranking: " + getStar());

    }
}