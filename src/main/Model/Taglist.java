package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Taglist implements List<Tag> {

    private ArrayList<Tag> list;

    public Taglist() {
        list = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Tag is added to the tag list
    public void add(Tag tag) {
        list.add(tag);
    }

    @Override
    public Tag get(int n) {
        return list.get(n);
    }

    public void remove(Tag tag) {
        list.remove(tag);
    }

    public boolean contains(Tag tag) {
        return list.contains(tag);
    }

    // EFFECTS: Returns the number of items in the set
    public int size() {
        return list.size();
    }


    //MODIFIES: this and file
    //EFFECTS: save the course into the file
    public void save(File file) throws IOException {
        java.util.List<String> lines = new ArrayList<>();
        for (Tag t1 : list) {
            lines.add(t1.getName());
            Files.write(file.toPath(), lines);
        }
    }


    //MODIFIES: this
    //EFFECTS: load the data
    public void load(File file) throws IOException {
        java.util.List<String> lines = Files.readAllLines(file.toPath());
        PrintWriter writer = new PrintWriter("data/outputfile.txt", "UTF-8");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            list.add(new Tag(partsOfLine.get(0)));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    private static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }



    //MODIFIES: this
    //EFFECTS: return the tag with given name in the given list
    public  Tag getTag(String name) {
        for (Tag t : list) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return new Tag(name);
    }
}
