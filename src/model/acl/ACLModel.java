package model.acl;

import java.util.SortedMap;
import java.util.TreeMap;

public class ACLModel {

    private final SortedMap<Integer, ACLEntry> entries;

    public ACLModel() {
        this.entries = new TreeMap<>();
    }

    public void addEntry(int lineNumber, ACLEntry entry) {
        entries.put(lineNumber, entry);
    }
}
