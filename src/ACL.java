import interfaces.ACLi;
import interfaces.Datagram;
import service.*;

public class ACL implements ACLi {

    private final ServiceFacade serviceFacade;

    public ACL() {
        this.serviceFacade = ServiceFacadeImpl.INSTANCE;
    }

    @Override
    public void addHost(String hostAddress, String hostName) {
        serviceFacade.addHost(hostAddress, hostName);
    }

    @Override
    public void addNet(String netID, Integer networkPrefixLength, String netName) {
        serviceFacade.addNet(netID, networkPrefixLength, netName);
    }

    @Override
    public Integer createNewGroup() {
        return serviceFacade.createNewGroup();
    }

    @Override
    public void addHostToGroup(Integer groupID, String hostName) {
        serviceFacade.addHostToGroup(groupID, hostName);
    }

    @Override
    public void addNetToGroup(Integer groupID, String netName) {
        serviceFacade.addNetToGroup(groupID, netName);
    }

    @Override
    public void addGroupToGroup(Integer groupID, Integer subGroupID) {
        serviceFacade.addGroupToGroup(groupID, subGroupID);
    }

    @Override
    public Condition newCondition(Integer sourceGroupID, Integer destinationGroupID, Datagram.Protocol protocol, Datagram.Flag flag) {
        return serviceFacade.newCondition(sourceGroupID, destinationGroupID, protocol, flag);
    }

    @Override
    public Condition and(Condition c1, Condition c2) {
        return serviceFacade.and(c1, c2);
    }

    @Override
    public Condition or(Condition c1, Condition c2) {
        return serviceFacade.or(c1, c2);
    }

    @Override
    public Condition not(Condition c) {
        return serviceFacade.not(c);
    }

    @Override
    public Integer createACL() {
        return serviceFacade.createACL();
    }

    @Override
    public void addConditionToACL(Integer aclID, Integer lineNumber, Condition condition, Result result) {
        serviceFacade.addConditionToACL(aclID, lineNumber, condition, result);
    }

    @Override
    public Result test(Integer aclID, Datagram datagram) {
        return serviceFacade.test(aclID, datagram);
    }
}
