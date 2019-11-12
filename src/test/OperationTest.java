import exception.ImpossibleAgentException;
import model.Agentlist;
import model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class OperationTest {
    private Operation op1;
    private Agentlist list1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void runBefore() throws IOException {
        File rhineLife = new File("data/RhineLife.txt");
        File rhodeIsland = new File("data/RholesIsland.txt");
        Agentlist rhineLifeAgents = new Agentlist();
        Agentlist rhodeIslandAgent = new Agentlist();
        list1 = new Agentlist();
        rhineLifeAgents.load(rhineLife);
        rhodeIslandAgent.load(rhodeIsland);
        op1 = new Operation(list1, rhineLifeAgents, rhodeIslandAgent);
        System.setOut(new PrintStream(outContent));
    }


    @Test
    void addAgentTest() throws IOException {
        assertFalse(list1.contains(list1.getAgent("ha")));
        try {
            op1.addAgent("ha");
            fail("not thrown yet");
        } catch (ImpossibleAgentException i) {
        }
        assertFalse(list1.contains(list1.getAgent("ha")));
        assertFalse(list1.contains(list1.getAgent("Texas")));
        try {
            op1.addAgent("Texas");
        } catch (ImpossibleAgentException i) {
            fail("the exception has been thrown");
        }
        assertTrue(list1.contains(list1.getAgent("Texas")));
        assertEquals("The agent has been added to your recruitment list!\r\n", outContent.toString());

    }



    @Test
    void SearchAgentTest() {
        try {
            op1.searchAgent("Texas");
        } catch (ImpossibleAgentException e) {
            fail("the exception has been thrown");
        }
        try {
            op1.searchAgent("ha");
            fail("not thrown yet");
        } catch (ImpossibleAgentException e) {
        }
        assertEquals("This is an agent from Rhine Life.\r\n", outContent.toString());
    }



}


