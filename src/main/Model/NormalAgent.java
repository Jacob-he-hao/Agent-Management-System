package model;

public class NormalAgent extends Agent {
    public NormalAgent(String name, String job, int star) {
        super(name, job, star);
    }

    // Determines if the agent have met the requirements of star rankings
    // EFFECTS:  return true if for a normal agent, the star ranking is not lower than the standard;
    //false otherwise
    @Override
    public boolean qualified(Agent i, Integer num) {
        if (num == 6) {
            System.out.println("That's not a normal agent");
        } else if (i.getStar() < num) {
            return false;
        }
        return true;
    }
}