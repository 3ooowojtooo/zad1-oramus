package service;

import model.address.Address;
import model.address.NetworkAddress;
import model.composite.GroupCompositeElement;

public interface GroupService {

    Integer createNewGroup();
    void addHostToGroup(int groupId, Address address);
    void addNetworkToGroup(int groupId, NetworkAddress networkAddress);
    void addGroupToGroup(int groupId, int subGroupId);
    GroupCompositeElement findGroup(int groupId);
}
