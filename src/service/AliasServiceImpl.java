package service;

import model.address.Address;
import model.address.NetworkAddress;

import java.util.HashMap;
import java.util.Map;

public enum AliasServiceImpl implements AliasService {
    INSTANCE;

    private final Map<String, Address> HOSTS = new HashMap<>();
    private final Map<String, NetworkAddress> NETWORKS = new HashMap<>();

    @Override
    public void addHost(String hostAddress, String hostName) {
        HOSTS.put(hostName, new Address(hostAddress));
    }

    @Override
    public Address findHost(String hostName) {
        return HOSTS.get(hostName);
    }

    @Override
    public void addNet(String netID, Integer networkPrefixLength, String netName) {
        NETWORKS.put(netName, new NetworkAddress(netID, networkPrefixLength));
    }

    @Override
    public NetworkAddress findNet(String netName) {
        return NETWORKS.get(netName);
    }
}
