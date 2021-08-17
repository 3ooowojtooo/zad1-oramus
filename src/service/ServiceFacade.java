package service;

import interfaces.ACLi;
import interfaces.Datagram;

/**
 * Facade design pattern
 */
public interface ServiceFacade {
    
    void addHost(String hostAddress, String hostName);
    void addNet(String netID, Integer networkPrefixLength, String netName);
    Integer createNewGroup();
    void addHostToGroup(Integer groupID, String hostName);
    void addNetToGroup(Integer groupID, String netName);
    void addGroupToGroup(Integer groupID, Integer subGroupID);
    ACLi.Condition newCondition(Integer sourceGroupID, Integer destinationGroupID, Datagram.Protocol protocol, Datagram.Flag flag);
    ACLi.Condition and(ACLi.Condition c1, ACLi.Condition c2);
    ACLi.Condition or(ACLi.Condition c1, ACLi.Condition c2);
    ACLi.Condition not(ACLi.Condition c);
    Integer createACL();
    void addConditionToACL(Integer aclID, Integer lineNumber, ACLi.Condition condition, ACLi.Result result);
    ACLi.Result test(Integer aclID, Datagram datagram);
}
