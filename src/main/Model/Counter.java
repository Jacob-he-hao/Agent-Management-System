package model;

import observer.TagObserver;

public class Counter implements TagObserver {
    private int numEmployers;

        //EFFECTS: constructs organization with animal counter set to zero
    public Counter() {
        numEmployers = 0;
    }

    @Override
    // EFFECTS: adds one to number of animals at zoo and prints total number of animals at zoo
    public void update(Employer e) {
        numEmployers++;
        System.out.println("There are now " + numEmployers + " employers queueing at the tag.");
    }

}

