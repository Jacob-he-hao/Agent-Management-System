package model;

public class NormalAgent extends Agent {
    int star;

    public NormalAgent(String name, String job, int star) {
        super(name, job, star);
        this.star = star;
    }

    @Override
    public void getInfo() {
        System.out.println("This is a normal agent");
    }
}

