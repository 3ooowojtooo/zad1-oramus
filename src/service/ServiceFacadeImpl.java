package service;

import interfaces.ACLi;
import interfaces.Datagram;
import model.address.Address;
import model.address.NetworkAddress;
import model.condition.AndCondition;
import model.condition.NormalCondition;
import model.condition.NotCondition;
import model.condition.OrCondition;
import model.composite.GroupCompositeElement;

public enum ServiceFacadeImpl implements ServiceFacade {
    INSTANCE;

    private final AliasService aliasService;
    private final GroupService groupService;
    private final ACLService aclService;

    ServiceFacadeImpl() {
        this.aliasService = AliasServiceImpl.INSTANCE;
        this.groupService = GroupServiceImpl.INSTANCE;
        this.aclService = ACLServiceImpl.INSTANCE;
    }

    @Override
    public void addHost(String hostAddress, String hostName) {
        aliasService.addHost(hostAddress, hostName);
    }

    @Override
    public void addNet(String netID, Integer networkPrefixLength, String netName) {
        aliasService.addNet(netID, networkPrefixLength, netName);
    }

    @Override
    public Integer createNewGroup() {
        return groupService.createNewGroup();
    }

    @Override
    public void addHostToGroup(Integer groupID, String hostName) {
        Address hostAddress = aliasService.findHost(hostName);
        groupService.addHostToGroup(groupID, hostAddress);
    }

    @Override
    public void addNetToGroup(Integer groupID, String netName) {
        NetworkAddress networkAddress = aliasService.findNet(netName);
        groupService.addNetworkToGroup(groupID, networkAddress);
    }

    @Override
    public void addGroupToGroup(Integer groupID, Integer subGroupID) {
        groupService.addGroupToGroup(groupID, subGroupID);
    }

    @Override
    public ACLi.Condition newCondition(Integer sourceGroupID, Integer destinationGroupID, Datagram.Protocol protocol, Datagram.Flag flag) {
        GroupCompositeElement sourceGroup = groupService.findGroup(sourceGroupID);
        GroupCompositeElement destinationGroup = groupService.findGroup(destinationGroupID);
        return new NormalCondition(sourceGroup, destinationGroup, protocol, flag);
    }

    @Override
    public ACLi.Condition and(ACLi.Condition c1, ACLi.Condition c2) {
        return new AndCondition(c1, c2);
    }

    @Override
    public ACLi.Condition or(ACLi.Condition c1, ACLi.Condition c2) {
        return new OrCondition(c1, c2);
    }

    @Override
    public ACLi.Condition not(ACLi.Condition c) {
        return new NotCondition(c);
    }

    @Override
    public Integer createACL() {
        return aclService.createACL();
    }

    @Override
    public void addConditionToACL(Integer aclID, Integer lineNumber, ACLi.Condition condition, ACLi.Result result) {
        aclService.addConditionToACL(aclID, lineNumber, condition, result);
    }

    @Override
    public ACLi.Result test(Integer aclID, Datagram datagram) {
        return aclService.test(aclID, datagram);
    }
}
