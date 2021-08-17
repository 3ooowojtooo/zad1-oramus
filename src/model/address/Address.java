package model.address;

import java.util.Arrays;

public class Address {

    private final String[] octets;

    public Address(final String address) {
        octets = address.split("\\.");
    }

    public String[] getOctets() {
        return octets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Arrays.equals(octets, address.octets);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(octets);
    }
}
