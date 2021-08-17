package util;

import model.address.Address;
import model.address.NetworkAddress;

/**
 * Singleton design pattern
 */
public interface NetworkAddressContainVerifier {

    boolean containsAddress(NetworkAddress networkAddress, Address ip);
}
