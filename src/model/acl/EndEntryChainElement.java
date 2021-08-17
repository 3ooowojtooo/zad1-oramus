package model.acl;

import interfaces.ACLi;
import interfaces.Datagram;

public class EndEntryChainElement implements EntryChainElement {

    @Override
    public ACLi.Result test(Datagram datagram) {
        return ACLi.Result.DENY;
    }
}
