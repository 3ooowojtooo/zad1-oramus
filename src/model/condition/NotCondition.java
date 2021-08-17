package model.condition;

import interfaces.ACLi;
import interfaces.Datagram;

public class NotCondition implements ACLi.Condition {

    private final ACLi.Condition condition;

    public NotCondition(ACLi.Condition condition) {
        this.condition = condition;
    }

    @Override
    public boolean match(Datagram datagram) {
        return !condition.match(datagram);
    }
}
