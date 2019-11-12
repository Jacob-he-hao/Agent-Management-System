import exception.ImpossibleAgentException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaglistTest {

        private Agentlist set;
        private Agentlist set1;
        private Tag tag1;
        private Tag tag2;
        private Taglist list1;
        private Taglist list2;
        private static Agent i1 = new RhineLifeAgent( "Lapland", "Vanguard", 4);
        private static Agent i2 = new RhineLifeAgent("Kyle", "Guard", 2);


        @BeforeEach
        void runBefore() throws IOException {
            set = new Agentlist();
            set1 = new Agentlist();
            set.add(i1);
            set1.add(i2);
            list1 = new Taglist();
            list2 = new Taglist();
            tag1 = new Tag("Support");
            tag2 = new Tag("medic");


        }


        @Test
        void testSave() throws IOException {
            list2.add(tag2);
            File file = new File("data/testTagSave.txt");
            list2.save(file);
            assertTrue(file.exists());
            List<String> lines = Files.readAllLines(Paths.get("data/testTagSave.txt"));
            assertEquals("medic" , lines.get(0));
        }

        @Test
        void testLoad() throws IOException, ImpossibleAgentException {
        File file = new File("data/testLoad.txt");
        List<String> lines = new ArrayList<>();
        lines.add("output -> Lapland-Guard-6");
        Files.write(file.toPath(), lines);
        list1.load(file);
        assertEquals ("output", list1.get(0).getName());
    }


        @Test
        void testGet() {
            list1.add(tag1);
            list1.add(tag2);
            assertEquals(tag1, list1.get(0));
            assertEquals(tag2, list1.get(1));

        }




        @Test
        void testSize() {
            assertEquals(0, list1.size());
            list1.add(tag1);
            assertEquals(1, list1.size());
            list1.add(tag2);
            assertEquals(2, list1.size());
        }

        @Test
        void testContains() {
            list2.add(tag1);
            assertTrue(list2.contains(tag1));
            assertEquals(1, list2.size());
            list2.add(tag2);
            assertTrue(list2.contains(tag2));
            assertEquals(2, list2.size());

        }

        @Test
        void testAdd() {
            list1.add(tag1);
            assertTrue(list1.contains(tag1));
            assertEquals(1, list1.size());
            list1.add(tag2);
            assertTrue(list1.contains(tag2));
            assertTrue(list1.contains(tag1));
            assertEquals(2, list1.size());
        }



        @Test
        void testRemove() {
            list1.add(tag1);
            list1.remove(tag1);
            assertFalse(list1.contains(tag1));
            assertEquals(0, list1.size());
            list1.add(tag1);
            list1.add(tag2);
            list1.remove(tag1);
            assertTrue(list1.contains(tag2));
            assertFalse(list1.contains(tag1));
            assertEquals(1, list1.size());
            list1.remove(tag2);
            assertFalse(list1.contains(tag1));
            assertFalse(list1.contains(tag2));
            assertEquals(0, list1.size());
        }

        @Test
        void testGetTag() {
            list1.add(tag1);
            list1.add(tag2);
            assertEquals("Support", list1.getTag("Support").getName());
            assertEquals(tag2, list1.getTag("medic"));
        }



    }

