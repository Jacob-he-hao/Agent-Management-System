import model.Agent;
import model.NormalAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class NormalAgentTest {
    private static int star;
    private static String job;
    private static String name;
    private Agent normalAgent;
    private static int num;
    private Agent i1;
    private Agent i2;

    @BeforeEach
    void runBefore() {
        normalAgent = new NormalAgent(name, job, star);
    }

    @Test
    void testQualified() {
        num = 4;
        i1 = new NormalAgent(name, job, 5);
        i2 = new NormalAgent(name, job, 3);
        assertTrue(normalAgent.qualified(i1, num));
        assertFalse(normalAgent.qualified(i2, num));
    }
}


