import model.Agent;
import model.TopAgent;
import model.NormalAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.font.TextLayout;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AgentTest {
    private Agent agent;
    private Agent agent2;
    private Agent agent1;
    private Agent hiagent;
    private static int num;
    @BeforeEach
    void runBefore() {
        agent = new NormalAgent("k", "Guard", 4);
        agent1 = new NormalAgent("h", "Vanguard", 5);
        agent2 = new NormalAgent("w", "Guard", 3);
        hiagent = new TopAgent("j", "Vanguard", 6);
    }


    @Test
    void testGetName() {
        assertEquals("k", agent.getName());
    }


    @Test
    void testGetJob() {
        assertEquals("Guard", agent.getJob());
    }

    @Test
    void testGetStar() {
        assertEquals( 4, agent.getStar());
        assertEquals( 5, agent1.getStar());
        assertEquals( 3, agent2.getStar());
        assertEquals(6, hiagent.getStar());
    }

    @Test
    void testGetNormalInfo() throws Exception{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        agent1.getInfo();
        String expectedOutput="This is a normal agent\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testGetTopInfo() throws Exception{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        hiagent.getInfo();
        String anotherOutput="This is a top agent\r\n";
        assertEquals(anotherOutput, outContent.toString());
    }



}
