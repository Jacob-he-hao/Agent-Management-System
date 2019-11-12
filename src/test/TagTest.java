import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
    private ArrayList<Employer> el1;
    private ArrayList<Employer> el2;
    private Employer employer1;
    private Employer employer2;


    @BeforeEach
    void runBefore() {
        el1 = new ArrayList<>();
        el2 = new ArrayList<>();
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
    void testGetName() {
        assertEquals("support", tag1.getName());
    }


    @Test
    void GetEmployerListTest(){
        el1 = tag1.getEmployerList();
        assertEquals(0,tag1.getEmployerList().size());
        assertFalse(tag1.getEmployerList().contains(employer1));
        assertFalse(tag1.getEmployerList().contains(employer2));
        el1.add(employer1);
        assertEquals(1,tag1.getEmployerList().size());
        assertTrue(tag1.getEmployerList().contains(employer1));
        assertFalse(tag1.getEmployerList().contains(employer2));
    }

    @Test
    void AddEmployerTest() {
        el2 = tag2.getEmployerList();
        assertFalse(tag2.getEmployerList().contains(employer2));
        tag2.addEmployer(employer2);
        assertTrue(tag2.getEmployerList().contains(employer2));
        assertFalse(tag2.getEmployerList().contains(employer1));
        tag2.addEmployer(employer1);
        assertTrue(tag2.getEmployerList().contains(employer1));
    }

    @Test
    void GetAgentList(){
        Agentlist al = tag1.getAgentList();
        assertEquals(0,tag1.getAgentList().size());
        assertFalse(tag1.getAgentList().contains(agent));
        assertFalse(tag1.getAgentList().contains(agent1));
        al.add(agent1);
        assertEquals(1,tag1.getAgentList().size());
        assertFalse(tag1.getAgentList().contains(agent));
        assertTrue(tag1.getAgentList().contains(agent1));
    }

    @Test
    void addAndRemoveTagTest() {
        Agentlist al = tag1.getAgentList();
        assertFalse(tag1.getAgentList().contains(agent));
        tag1.addAgent(agent);
        assertTrue(tag1.getAgentList().contains(agent));
        tag1.addAgent(agent1);
        assertTrue(tag1.getAgentList().contains(agent1));
        tag1.removeAgent(agent1);
        assertFalse(tag1.getAgentList().contains(agent1));
        tag1.removeAgent(agent);
        assertFalse(tag1.getAgentList().contains(agent));
    }


}
