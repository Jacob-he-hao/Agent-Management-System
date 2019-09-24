import model.Agent;
import Model.Agentlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentlistTest {
    private static final int NUMITEMS = 5000;
    private Agentlist set;
    private Agentlist set1;
    private static Agent i1 = new Agent("Lapland", "Vanguard", 4);
    private static Agent i2 = new Agent("Kyle", "Guard", 2);
    private static Agent i3 = new Agent("Exsial", "Defender", 5);
    @BeforeEach
    public void runBefore() {
        set = new Agentlist();
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size());
        set.insert(i1);
        assertEquals(1, set.size());
        set.insert(i2);
        assertEquals(2, set.size());
    }

    @Test
    public void testContainsOne() {
        set.insert(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsert() {
        set.insert(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
    }

    @Test
    public void testDuplicate() {
        set.insert(i1);
        set.insert(i1);

        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsertLots() {
        set.insert(i1);
        set.insert(i2);
        assertTrue(set.contains(i1));
        assertTrue(set.contains(i2));
        assertEquals(2, set.size());
    }



    @Test
    public void testRemove() {
        set.insert(i1);
        set.remove(i1);
        assertFalse(set.contains(i1));
        assertEquals(0, set.size());
    }

    @Test
    public void testRemoveLots() {
        set.insert(i1);
        set.insert(i2);
        set.remove(i1);
        set.remove(i2);
        assertFalse(set.contains(i1));
        assertFalse(set.contains(i2));
        assertEquals(0, set.size());

    }
}








