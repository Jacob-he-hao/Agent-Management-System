package observer;


import model.Employer;

import java.util.ArrayList;
import java.util.List;

// Represents a subject in the observer pattern
public abstract class Subject {
    private List<TagObserver> tagObservers;

    public Subject() {
        tagObservers = new ArrayList<>();
    }

    public void addObserver(TagObserver o) {
        if (!tagObservers.contains(o)) {
            tagObservers.add(o);
        }
    }


    public void removeObserver(TagObserver o) {
        tagObservers.remove(o);
    }

    public void notifyObservers(Employer a) {
        for (TagObserver o : tagObservers) {
            o.update(a);
        }
    }
}
