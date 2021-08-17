package util;

import model.address.Address;
import model.address.NetworkAddress;

public enum NetworkAddressContainVerifierImpl implements NetworkAddressContainVerifier {
    INSTANCE;

    private static final int OCTET_LENGTH = 8;

    @Override
    public boolean containsAddress(NetworkAddress networkAddress, Address ip) {
        int numberOfOctets = getNumberOfOctets(networkAddress);

        for (int i = 0; i < numberOfOctets; i++) {
            String networkOctet = networkAddress.getNetworkAddress().getOctets()[i];
            String ipOctet = ip.getOctets()[i];
            if (!networkOctet.equals(ipOctet)) {
                return false;
            }
        }

        return true;
    }

    private static int getNumberOfOctets(NetworkAddress networkAddress) {
        return networkAddress.getPrefixLength() / OCTET_LENGTH;
    }
}
