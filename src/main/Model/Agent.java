package Model;

public class Agent {
    private static int star;
    private String name;
    private String job;


    public Agent(String name, String job, int star) {
        this.name = name;
        this.job = job;
        this.star = star;
    }
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static int getStar(){ return star;
    }

}
