package model.address;

import java.util.Objects;

public class NetworkAddress {

    private final Address networkAddress;
    private final int prefixLength;

    public NetworkAddress(String netId, int prefixLength) {
        this.networkAddress = new Address(netId);
        this.prefixLength = prefixLength;
    }

    public Address getNetworkAddress() {
        return networkAddress;
    }

    public int getPrefixLength() {
        return prefixLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkAddress that = (NetworkAddress) o;
        return prefixLength == that.prefixLength && networkAddress.equals(that.networkAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(networkAddress, prefixLength);
    }
}
