package service;

import model.address.Address;
import model.address.NetworkAddress;

public interface AliasService {

    void addHost(String hostAddress, String hostName);
    Address findHost(String hostName);
    void addNet(String netID, Integer networkPrefixLength, String netName);
    NetworkAddress findNet(String netName);
}
