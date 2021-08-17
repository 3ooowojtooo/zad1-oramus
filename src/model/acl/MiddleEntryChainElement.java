package model.acl;

import interfaces.ACLi;
import interfaces.Datagram;

public class MiddleEntryChainElement implements EntryChainElement {

    private final ACLi.Condition condition;
    private final ACLi.Result result;
    private final EntryChainElement next;

    public MiddleEntryChainElement(ACLi.Condition condition, ACLi.Result result, EntryChainElement next) {
        this.condition = condition;
        this.result = result;
        this.next = next;
    }

    @Override
    public ACLi.Result test(Datagram datagram) {
        if (condition.match(datagram)) {
            return result;
        } else {
            return next.test(datagram);
        }
    }
}
