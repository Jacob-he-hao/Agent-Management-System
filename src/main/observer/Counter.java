package observer;

import model.Agentlist;
import model.Operation;
import ui.OriginalState;

import java.util.Observable;
import java.util.Observer;

public class Counter implements Observer {

    private int numAgents;

    //EFFECTS: constructs counter
    public Counter() {
        numAgents = 0;
    }


    @Override
    // EFFECTS: send out inform message every time observer is notified
    public  void update(Observable o, Object arg) {
        System.out.println("one more player added to/removed from the team");
    }

}


