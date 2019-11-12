import model.*;
import observer.TagObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {
    private Agent agent;
    private Agent agent1;
    private Agentlist al1;
    private Agentlist al2;
    private Tag tag1;
    private Tag tag2;
    private Taglist tl;
    private ArrayList<Employer> el1;
    private ArrayList<Employer> el2;
    private Employer employer1;
    private Employer employer2;
    private List<TagObserver> tagObservers;



    @BeforeEach
    void runBefore() {
        el1 = new ArrayList<>();
        el2 = new ArrayList<>();
        tagObservers = new ArrayList<>();
        employer1 = new Employer("Karry");
        employer2 = new Employer("Dora");
        agent = new RhineLifeAgent("k", "Guard", 4);
        agent1 = new RhodeIslandAgent("d", "Vanguard", 4);
        al1= new Agentlist();
        al2= new Agentlist();
        tl = new Taglist();
        tag1 = new Tag("support");
        tag2 = new Tag("medic");
    }

    @Test
    void TestAddObserver() {
        al1 = tag1.getAgentList();
       tag1.addObserver(agent);
        assertFalse(al1.contains(agent));
    }

}
