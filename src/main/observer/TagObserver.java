package observer;
// Represents an observer of a zoo

import model.Employer;


public interface TagObserver {
    // EFFECTS: responds to employers getting added to tag
    void update(Employer a);
}
