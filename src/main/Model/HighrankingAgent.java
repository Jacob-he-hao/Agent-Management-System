package model;


public class HighRankingAgent extends Agent {
    public HighRankingAgent(String name, String job, int star) {
        super(name, job, star);
    }

    @Override
    public boolean qualified(Agent i, Integer num) {
        return true;
    }

    @Override
    public int getStar() {
        return 6;
    }
}


