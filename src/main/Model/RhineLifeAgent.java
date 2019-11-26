package model;

import javax.swing.*;

public class RhineLifeAgent extends Agent {


    public RhineLifeAgent(String name, String job, int star) {
        super(name, job, star);
    }


    //EFFECTS: get the information of RhineLife Agent
    @Override
    public void getInfo() {
        InfoBox.infoBox("Organization: RhineLife\n "
                + "Agent Name: " + getName() + "\n"
                + "Agent Job: " + getJob()+ "\n"
                + "Star ranking: " + getStar());
    }
}

