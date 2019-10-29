import exception.ImpossibleAgentException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AgentTest {
    private Agent agent;
    private Agent agent2;
    private Agent agent1;
    private Agent agent3;
    private Tag tag;
    private Taglist tl;
    private Agentlist al;
    @BeforeEach
    void runBefore() {
        agent = new RhineLifeAgent("k", "Guard", 4);
        agent1 = new RhineLifeAgent("h", "Vanguard", 5);
        agent2 = new RhodeIslandAgent("w", "Guard", 3);
        agent3 = new RhodeIslandAgent("j", "Vanguard", 6);
        al = new Agentlist();
        tag = new Tag("support", al);
        tl = new Taglist();
        agent1.addTag(tag);
    }


    @Test
    void testGetName() {
        assertEquals("k", agent.getName());
        assertEquals("j", agent3.getName());
    }


    @Test
    void testGetJob() {
        assertEquals("Guard", agent.getJob());
        assertEquals("Vanguard", agent3.getJob());
    }

    @Test
    void testGetStar() {
        assertEquals( 4, agent.getStar());
        assertEquals( 5, agent1.getStar());
        assertEquals( 3, agent2.getStar());
        assertEquals(6, agent3.getStar());
    }

    @Test
    void testGetRhineLifeOrganization()  {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        agent1.getOrganization();
        String expectedOutput="This is an agent from Rhine Life.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testGetRhodeIslandOrganization() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        agent3.getOrganization();
        String anotherOutput="This is an agent from Rhode Island.\r\n";
        assertEquals(anotherOutput, outContent.toString());
    }


    @Test
    void addAndRemoveTagTest() {
        assertFalse(agent.getTagList().contains(tag));
        agent.addTag(tag);
        assertTrue(agent.getTagList().contains(tag));
        agent.addTag(tag);
        assertTrue(agent.getTagList().contains(tag));
        agent.removeTag(tag);
        assertFalse(agent.getTagList().contains(tag));
        agent.removeTag(tag);
        assertFalse(agent.getTagList().contains(tag));
    }


}
