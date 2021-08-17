package model.composite;

import model.address.Address;

/**
 * Composite design pattern
 */
public interface CompositeElement {

    boolean hasAddress(Address address);
}
