package model.composite;

import model.address.Address;

import java.util.LinkedList;
import java.util.List;

public class GroupCompositeElement implements CompositeElement {

    private final List<CompositeElement> elements = new LinkedList<>();

    public void addElement(CompositeElement element) {
        elements.add(element);
    }

    @Override
    public boolean hasAddress(Address address) {
        for (CompositeElement element : elements) {
            if (element.hasAddress(address)) {
                return true;
            }
        }
        return false;
    }
}
