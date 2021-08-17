package model.acl;

import interfaces.ACLi;
import interfaces.Datagram;

public class EntryChainElementImpl implements EntryChainElement {

    private final ACLi.Condition condition;
    private final ACLi.Result result;
    private EntryChainElement next;

    public EntryChainElementImpl(ACLi.Condition condition, ACLi.Result result) {
        this.condition = condition;
        this.result = result;
    }

    @Override
    public ACLi.Result test(Datagram datagram) {
        if (condition.match(datagram)) {
            return result;
        } else if (next != null) {
            return next.test(datagram);
        } else {
            return ACLi.Result.DENY;
        }
    }

    @Override
    public void setNext(EntryChainElement nextElement) {
        this.next = nextElement;
    }
}
