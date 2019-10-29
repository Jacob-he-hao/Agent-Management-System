package model;

public interface List {
    void add(Agent agent);

    void remove(Agent agent);

    boolean contains(Agent agent);

    int size();

    Agent get(int n);
}
