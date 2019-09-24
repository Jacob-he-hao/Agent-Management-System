import Model.Agent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AgentTest {
    private static int star;
    private static String job ;
    private static String name ;
    private Agent agent;
    private static int num;
    private Agent i1;
    private Agent i2;
    private Agent i3;
    @BeforeEach
    void runBefore() {
        agent = new Agent(name, job, star);
    }

    @Test
    void testGetName() {
        assertEquals(name, agent.getName());
    }


    @Test
    void testGetStar() {

        assertEquals(star, agent.getStar());
    }

    @Test
    void testGetJob() {
        assertEquals(job, agent.getJob());
    }
    @Test
    void testQualified(){
        num = 4;
        i1= new Agent(name, job, 3);
        i2= new Agent(name, job, 4);
        i3= new Agent(name, job, 5);
        assertFalse(agent.qualified(i1 ,num));
        assertTrue(agent.qualified(i2 ,num));
        assertTrue(agent.qualified(i3 ,num));
    }
    @Test
    void testPickqualified(){
        num =4;
        i1= new Agent("Lapland", "Vanguard", 4);
        i2= new Agent("Chen", "Guard", 3);
        i3= new Agent("Exsail", "Defender", 6);
        assertEquals("Lapland", agent.pickQualified(i1, num));
        assertEquals("None",  agent.pickQualified(i2, num));
        assertEquals("Exsail", agent.pickQualified(i3, num));

    }






}
