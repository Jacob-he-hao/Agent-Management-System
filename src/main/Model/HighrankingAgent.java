package model;


public class HighRankingAgent extends Agent {
    public HighRankingAgent(String name, String job, int star) {
        super(name, job, star);
    }


    // Determines if the agent have met the requirements of star rankings
    // EFFECTS:  Always return true as they are the top agents
    @Override
    public boolean qualified(Agent i, Integer num) {
        return true;
    }

    //EFFECTS: Get the star ranking: 6
    @Override
    public int getStar() {
        return 6;
    }
}


