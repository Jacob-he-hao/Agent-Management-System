import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TagTest {

    private Agent agent;
    private Agent agent1;
    private Agentlist al1;
    private Agentlist al2;
    private Tag tag1;
    private Tag tag2;
    private Taglist tl;



    @BeforeEach
    void runBefore() {
        agent = new RhineLifeAgent("k", "Guard", 4);
        agent1 = new RhodeIslandAgent("d", "Vanguard", 4);
        al1= new Agentlist();
        al1.add(agent);
        al2= new Agentlist();
        al2.add(agent1);
        tl = new Taglist();
        tag1 = new Tag("support", al1);
        tag2 = new Tag("medic", al2);



    }


    @Test
    void testGetName() {
        assertEquals("support", tag1.getName());
    }


    @Test
    void GetAgentList(){
        Agentlist al = tag1.getAgentList();
        assertEquals(1,tag1.getAgentList().size());
        assertTrue(tag1.getAgentList().contains(agent));
        assertFalse(tag1.getAgentList().contains(agent1));
        al.add(agent1);
        assertEquals(2,tag1.getAgentList().size());
        assertTrue(tag1.getAgentList().contains(agent));
        assertTrue(tag1.getAgentList().contains(agent1));
    }

    @Test
    void addAndRemoveTagTest() {
        assertTrue(tag1.getAgentList().contains(agent));
        tag1.addAgent(agent);
        assertTrue(tag1.getAgentList().contains(agent));
        tag1.addAgent(agent);
        assertTrue(tag1.getAgentList().contains(agent));
        tag1.removeAgent(agent);
        assertFalse(tag1.getAgentList().contains(agent));
        tag1.removeAgent(agent);
        assertFalse(tag1.getAgentList().contains(agent));
    }


}
