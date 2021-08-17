package service;

import model.address.Address;
import model.address.NetworkAddress;
import model.composite.AddressCompositeElement;
import model.composite.GroupCompositeElement;
import model.composite.NetworkCompositeElement;

import java.util.HashMap;
import java.util.Map;

public enum GroupServiceImpl implements GroupService {
    INSTANCE;

    private final Map<Integer, GroupCompositeElement> GROUPS = new HashMap<>();

    @Override
    public Integer createNewGroup() {
        GroupCompositeElement group = new GroupCompositeElement();
        int index = GROUPS.size();
        GROUPS.put(index, group);
        return index;
    }

    @Override
    public void addHostToGroup(int groupId, Address address) {
        GroupCompositeElement group = GROUPS.get(groupId);
        group.addElement(new AddressCompositeElement(address));
    }

    @Override
    public void addNetworkToGroup(int groupId, NetworkAddress networkAddress) {
        GroupCompositeElement group = GROUPS.get(groupId);
        group.addElement(new NetworkCompositeElement(networkAddress));
    }

    @Override
    public void addGroupToGroup(int groupId, int subGroupId) {
        GroupCompositeElement group = GROUPS.get(groupId);
        GroupCompositeElement subgroup = GROUPS.get(subGroupId);
        group.addElement(subgroup);
    }

    @Override
    public GroupCompositeElement findGroup(int groupId) {
        return GROUPS.get(groupId);
    }
}
