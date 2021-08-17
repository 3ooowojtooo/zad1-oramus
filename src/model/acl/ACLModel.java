package model.acl;

import java.util.*;

public class ACLModel {

    private final SortedMap<Integer, ACLEntry> entries = new TreeMap<>();

    public void addEntry(int lineNumber, ACLEntry entry) {
        entries.put(lineNumber, entry);
    }

    public EntryChainElement toChain() {
        List<ACLEntry> reversedOrderedEntries = buildReverseListOfEntries();
        Iterator<ACLEntry> iterator = reversedOrderedEntries.iterator();
        EntryChainElement next = new EndEntryChainElement();
        EntryChainElement helper = next;
        while (iterator.hasNext()) {
            ACLEntry entry = iterator.next();
            helper = new MiddleEntryChainElement(entry.getCondition(), entry.getResult(), next);
            next = helper;
        }
        return helper;
    }

    private List<ACLEntry> buildReverseListOfEntries() {
        List<ACLEntry> list = new ArrayList<>(entries.values());
        Collections.reverse(list);
        return list;
    }
}
