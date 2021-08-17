package model.condition;

import interfaces.ACLi;
import interfaces.Datagram;

public class OrCondition implements ACLi.Condition {

    private final ACLi.Condition a;
    private final ACLi.Condition b;

    public OrCondition(ACLi.Condition a, ACLi.Condition b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean match(Datagram datagram) {
        return a.match(datagram) || b.match(datagram);
    }
}
