package model.acl;

import interfaces.ACLi;

public class ACLEntry {

    private final ACLi.Condition condition;
    private final ACLi.Result result;

    public ACLEntry(ACLi.Condition condition, ACLi.Result result) {
        this.condition = condition;
        this.result = result;
    }

    public ACLi.Condition getCondition() {
        return condition;
    }

    public ACLi.Result getResult() {
        return result;
    }
}