package model;

public class TopAgent extends Agent {
    public TopAgent(String name, String job, int star) {
        super(name, job, star);
    }

    //EFFECTS: Get the star ranking: 6
    @Override
    public void getInfo() {
        System.out.println("This is a top agent");
    }
}


