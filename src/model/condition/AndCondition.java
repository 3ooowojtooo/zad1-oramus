package model.condition;

import interfaces.ACLi;
import interfaces.Datagram;

public class AndCondition implements ACLi.Condition {

    private final ACLi.Condition a;
    private final ACLi.Condition b;

    public AndCondition(ACLi.Condition a, ACLi.Condition b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean match(Datagram datagram) {
        return a.match(datagram) && b.match(datagram);
    }
}
