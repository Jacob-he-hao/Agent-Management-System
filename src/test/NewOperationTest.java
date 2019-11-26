import exception.ImpossibleAgentException;
import exception.ImpossibleAgentInListException;
import exception.NoSuchOrganizationException;
import model.Agentlist;
import model.NewOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class NewOperationTest {

    private NewOperation op1;
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
        op1 = new NewOperation(list1, rhineLifeAgents, rhodeIslandAgent);
        System.setOut(new PrintStream(outContent));
    }


    @Test
    void addAgentTest() throws IOException {
        assertFalse(list1.contains(list1.getAgent("ha")));
        try {
            op1.addAgent("RhineLife", "ha");
            fail("not thrown yet");
        } catch (ImpossibleAgentException i) {
        }
        assertFalse(list1.contains(list1.getAgent("ha")));
        assertFalse(list1.contains(list1.getAgent("Texas")));
        try {
            op1.addAgent("RhodeIsland", "Texas");
            fail("not thrown yet");
        } catch (ImpossibleAgentException i) {
        }
        assertFalse(list1.contains(list1.getAgent("Texas")));
        try {
            op1.addAgent("RhineLife", "Texas");
        } catch (ImpossibleAgentException i) {
            fail("have been thrown");
        }
        assertTrue(list1.contains(list1.getAgent("Texas")));

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
    }

    @Test
    void SearchAgentInListTest() throws IOException, ImpossibleAgentException {
        File file2 = new File("data/recruitedAgent.txt");
        list1.load(file2);
        try {
            op1.searchRecruited("Lapland");
            fail();
        } catch (ImpossibleAgentInListException | ImpossibleAgentException ignored) {
        }
        op1.addAgent("RhineLife", "Texas");
        try {
            op1.searchRecruited("Texas");
        } catch (ImpossibleAgentException | ImpossibleAgentInListException e) {
            fail("not thrown yet");
        }
    }

}


