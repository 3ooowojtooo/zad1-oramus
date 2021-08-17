package service;

import interfaces.ACLi;
import interfaces.Datagram;

/**
 * Singleton design pattern
 */
public interface ACLService {
    Integer createACL();
    void addConditionToACL(Integer aclID, Integer lineNumber, ACLi.Condition condition, ACLi.Result result);
    ACLi.Result test(Integer aclId, Datagram datagram);
}
