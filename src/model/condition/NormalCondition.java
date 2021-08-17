package model.condition;

import interfaces.ACLi;
import interfaces.Datagram;
import model.address.Address;
import model.composite.GroupCompositeElement;

import java.util.Set;

public class NormalCondition implements ACLi.Condition {

    private final GroupCompositeElement source;
    private final GroupCompositeElement destination;
    private final Datagram.Protocol protocol;
    private final Datagram.Flag flag;

    public NormalCondition(GroupCompositeElement source, GroupCompositeElement destination, Datagram.Protocol protocol, Datagram.Flag flag) {
        this.source = source;
        this.destination = destination;
        this.protocol = protocol;
        this.flag = flag;
    }

    @Override
    public boolean match(Datagram datagram) {
        return source.hasAddress(new Address(datagram.getSourceAddress())) &&
                destination.hasAddress(new Address(datagram.getDestinationAddress())) &&
                checkProtocol(datagram) &&
                checkFlag(datagram);
    }

    private boolean checkProtocol(Datagram datagram) {
        if (this.protocol == Datagram.Protocol.ANY) {
            return true;
        }
        return this.protocol == datagram.getProtocol();
    }

    private boolean checkFlag(Datagram datagram) {
        Set<Datagram.Flag> flags = datagram.getFlags();
        if (flag == Datagram.Flag.NON) {
            return flags.contains(Datagram.Flag.NON);
        } else if (flag == Datagram.Flag.ANY) {
            return !flags.contains(Datagram.Flag.NON);
        } else {
            return flags.contains(flag);
        }
    }
}
