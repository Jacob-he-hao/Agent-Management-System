import exception.ImpossibleAgentException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AgentTest {
    private Agent agent;
    private Agent agent2;
    private Agent agent1;
    private Agent agent3;
    private Tag tag;
    private Tag tag1;
    private Agentlist al;
    @BeforeEach
    void runBefore() {
        agent = new RhineLifeAgent("k", "Guard", 4);
        agent1 = new RhineLifeAgent("h", "Vanguard", 5);
        agent2 = new RhodeIslandAgent("w", "Guard", 3);
        agent3 = new RhodeIslandAgent("j", "Vanguard", 6);
        al = new Agentlist();
        tag = new Tag("support");
        tag1 = new Tag("medic");
        agent1.addTag(tag);
    }


    @Test
    void equals() {
        Agent a1 = new RhodeIslandAgent("k","Guard",3);
       assertTrue(agent.equals(agent));
       assertFalse(agent.equals(null));
       assertFalse(agent.equals(agent1));
       assertFalse(agent.equals(a1));

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
    void GetTagList(){
        Taglist tl = agent.getTagList();
        tl.add(tag);
        assertEquals(1,agent.getTagList().size());
        assertTrue(agent.getTagList().contains(tag));
        assertFalse(agent.getTagList().contains(tag1));
        tl.add(tag1);
        assertEquals(2,agent.getTagList().size());
        assertTrue(agent.getTagList().contains(tag1));
        assertTrue(agent.getTagList().contains(tag));
    }

    @Test
    void testGetRhineLifeOrganization()  {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        agent1.getInfo();
        String expectedOutput="Organization: RhineLife\r\n" +
                "Agent Name: h\r\n" +
                "Agent Job: Vanguard\r\n" +
                "Star ranking: 5\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testGetRhodeIslandOrganization() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        agent3.getInfo();
        String anotherOutput="Organization: RhodeIsland\r\n" +
                "Agent Name: j\r\n" +
                "Agent Job: Vanguard\r\n" +
                "Star ranking: 6\r\n";
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
