import model.Agent;
import model.Agentlist;
import model.NormalAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentlistTest {
    private Agentlist set;
    private Agentlist set1;
    private static Agent i1 = new NormalAgent("Lapland", "Vanguard", 4);
    private static Agent i2 = new NormalAgent("Kyle", "Guard", 2);
    private static Agent i3 = new NormalAgent("Exsial", "Defender", 5);

    @BeforeEach
    public void runBefore() throws IOException {
        set = new Agentlist();
        set1 = new Agentlist();

    }

    @Test
    public void testLoad() throws IOException {
        File file = new File("inputfile.txt");
        List<String> lines = new ArrayList<>();
        lines.add("Save Guard 6");
        lines.add("Kype Vanguard 4");
        Files.write(file.toPath(), lines);
        set1.load();
        assertEquals ("Save", set1.get(0).getName());
        assertEquals ("Guard", set1.get(0).getJob());
        assertEquals (6, set1.get(0).getStar());
    }

    @Test
    public void testSave() throws IOException{
        Agent agent1 = new NormalAgent("Kype", "Vanguard" , 4);
        set.add(agent1);
        //set.addtoload(agent1);
        set.save();
        File file = new File("Recruitment list.txt");
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(file.toPath());
        assertEquals("Save" , set.get(0).getName() );
    }

    @Test
    public void testContainAgent() {
        set.add(i1);
        set.add(i2);
        set.add(i3);
        assertTrue(set.containAgent("Lapland"));
        assertTrue(set.containAgent("Kyle"));
        assertFalse(set.containAgent("Texas"));
    }

    @Test
    public void testRenderAddAgent() throws IOException {
        File file = new File("inputfile.txt");
        List<String> lines = new ArrayList<>();
        lines.add("Save Guard 6");
        lines.add("Kype Vanguard 4");
        Files.write(file.toPath(), lines);
        set.load();
        set.renderAddAgent("Guard", 5);
        assertEquals ("Save", set1.get(0).getName());
        assertEquals ("Guard", set1.get(0).getJob());
        assertEquals (6, set1.get(0).getStar());
        assertEquals(lines.get(0),"Exsial Defender 5" );
    }

    @Test
    public void testSearchAgent() throws IOException {
        set.add(i1);
        set.add(i2);
        set.add(i3);
        set.searchAgent("Lapland");
        File file = new File("Recruitment list.txt");
        List<String> lines = Files.readAllLines(file.toPath());
        assertEquals(lines.get(0),"Exsial Defender 5" );
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
    public void testContains() {
        set.insert(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsert() {
        set.insert(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
        set.insert(i1);
        assertTrue(set.contains(i1));
        assertEquals(1, set.size());
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
        set.insert(i1);
        set.insert(i2);
        set.remove(i1);
        set.remove(i2);
        assertFalse(set.contains(i1));
        assertFalse(set.contains(i2));
        assertEquals(0, set.size());

    }
}








