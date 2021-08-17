package model.composite;

import model.address.Address;

public class AddressCompositeElement implements CompositeElement {

    private final Address address;

    public AddressCompositeElement(Address address) {
        this.address = address;
    }

    @Override
    public boolean hasAddress(Address address) {
        return this.address.equals(address);
    }
}
