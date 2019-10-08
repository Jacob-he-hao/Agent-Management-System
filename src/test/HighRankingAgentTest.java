import model.Agent;
import model.HighRankingAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighRankingAgentTest {
    private static int star;
    private static String job;
    private static String name;
    private Agent hiagent;
    private static int num;
    private Agent i1;
    private Agent i2;



    @BeforeEach
    void runBefore() {
        hiagent = new HighRankingAgent(name, job, star);
    }

    @Test
    void testQualified() {
        num = 4;
        i1 = new HighRankingAgent(name, job, 6);
        i2 = new HighRankingAgent(name, job, 6);
        assertTrue(hiagent.qualified(i1, num));
        assertTrue(hiagent.qualified(i2, num));
    }

    @Test
    void getStar() {
        assertEquals(6, hiagent.getStar());
    }
}


