package model;

import java.io.File;
import java.io.IOException;

public interface List<A> {
    void add(A a);

    void remove(A a);

    boolean contains(A a);

    int size();

    A get(int i);

    void save(File file) throws IOException;

    void load(File file) throws IOException;


}
