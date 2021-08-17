package service;

import interfaces.ACLi;
import interfaces.Datagram;
import model.acl.ACLEntry;
import model.acl.ACLModel;

import java.util.HashMap;
import java.util.Map;

public enum ACLServiceImpl implements ACLService {
    INSTANCE;

    private final Map<Integer, ACLModel> accessControlLists = new HashMap<>();

    @Override
    public Integer createACL() {
        int index = accessControlLists.size();
        accessControlLists.put(index, new ACLModel());
        return index;
    }

    @Override
    public void addConditionToACL(Integer aclID, Integer lineNumber, ACLi.Condition condition, ACLi.Result result) {
        ACLModel acl = accessControlLists.get(aclID);
        acl.addEntry(lineNumber, new ACLEntry(condition, result));
    }

    @Override
    public ACLi.Result test(Integer aclId, Datagram datagram) {
        ACLModel acl = accessControlLists.get(aclId);

    }


}
