package model.composite;

import model.address.Address;
import model.address.NetworkAddress;
import util.NetworkAddressContainVerifier;
import util.NetworkAddressContainVerifierImpl;

public class NetworkCompositeElement implements CompositeElement {

    private final NetworkAddress networkAddress;
    private final NetworkAddressContainVerifier networkAddressContainVerifier;

    public NetworkCompositeElement(NetworkAddress networkAddress) {
        this.networkAddress = networkAddress;
        this.networkAddressContainVerifier = NetworkAddressContainVerifierImpl.INSTANCE;
    }

    @Override
    public boolean hasAddress(Address address) {
        return networkAddressContainVerifier.containsAddress(networkAddress, address);
    }
}
