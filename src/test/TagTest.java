import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TagTest {

    private Agent agent;
    private Tag tag1;
    private Tag tag2;
    private Tag tag3;
    private Taglist tl;
    private Agentlist al;


    @BeforeEach
    void runBefore() {
        tag1 = new Tag("support", al);
        tag2 = new Tag("spying", al);
        tag3 = new Tag("medicine", al);
        tl = new Taglist();
        agent = new RhineLifeAgent("k", "Guard", 4);
        al = new Agentlist();

    }


    @Test
    void testGetName() {
        assertEquals("support", tag1.getName());
        assertEquals("spying", tag2.getName());
    }

    @Test
    void addAndRemoveTagTest() {
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
