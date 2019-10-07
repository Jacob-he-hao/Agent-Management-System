package model;

public class NormalAgent extends Agent {
    public NormalAgent(String name, String job, int star) {
        super(name, job, star);
    }

    @Override
    public boolean qualified(Agent i, Integer num) {
        return true;
    }
}