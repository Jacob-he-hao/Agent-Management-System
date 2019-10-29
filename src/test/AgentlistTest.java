import exception.ImpossibleAgentException;
import model.Agent;
import model.Agentlist;
import model.RhineLifeAgent;
import model.RhodeIslandAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentlistTest {
    private Agentlist set;
    private Agentlist set1;
    private Agent a;
    private static Agent i1 = new RhineLifeAgent( "Lapland", "Vanguard", 4);
    private static Agent i2 = new RhineLifeAgent("Kyle", "Guard", 2);
    private static Agent i3 = new RhodeIslandAgent("Exsial", "Defender", 5);

    @BeforeEach
     void runBefore() throws IOException {
        set = new Agentlist();
        set1 = new Agentlist();

    }

    @Test
     void testLoad() throws IOException, ImpossibleAgentException {
        File file = new File("data/testLoad.txt");
        List<String> lines = new ArrayList<>();
        lines.add("Save Guard 6");
        Files.write(file.toPath(), lines);
        set1.load(file);
        assertEquals ("Save", set1.get(0).getName());
        assertEquals ("Guard", set1.get(0).getJob());
        assertEquals (6, set1.get(0).getStar());
    }

    @Test
     void testSave() throws IOException {
        set.add(i1);
        File file = new File("data/testSave.txt");
        set.save(file);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(Paths.get("data/testSave.txt"));
        assertEquals("Lapland Vanguard 4" , lines.get(0));
    }


    @Test
    void testGet() {
        set.add(i1);
        set.add(i2);
        assertEquals(i1, set.get(0));
        assertEquals(i2, set.get(1));

    }

    @Test
     void testGetAgent() {
        set.add(i1);
        set.add(i2);
        assertEquals(i1, set.getAgent("Lapland"));
        assertEquals(i2, set.getAgent("Kyle"));
    }


    @Test
     void testSize() {
        assertEquals(0, set.size());
        set.add(i1);
        assertEquals(1, set.size());
        set.add(i2);
        assertEquals(2, set.size());
        set.add(i2);
        assertEquals(3, set.size());
    }

    @Test
     void testContains() {
        set.add(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
        set.add(i2);
        assertTrue(set.contains(i2));
        assertEquals(2, set.size());
        assertTrue(set.contains(i2));
        assertEquals(2, set.size());
    }

    @Test
    void testAdd() {
        set.add(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
        set.add(i2);
        assertTrue(set.contains(i1));
        assertTrue(set.contains(i2));
        assertEquals(2, set.size());
    }



    @Test
     void testRemove() {
        set.add(i1);
        set.remove(i1);
        assertFalse(set.contains(i1));
        assertEquals(0, set.size());
        set.add(i1);
        set.add(i2);
        set.remove(i2);
        assertTrue(set.contains(i1));
        assertFalse(set.contains(i2));
        assertEquals(1, set.size());
        set.remove(i1);
        assertFalse(set.contains(i1));
        assertFalse(set.contains(i2));
        assertEquals(0, set.size());

    }
}








