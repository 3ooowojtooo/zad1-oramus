package model.acl;

import interfaces.ACLi;
import interfaces.Datagram;

/**
 * Chain of responsibility pattern
 */
public interface EntryChainElement {

    ACLi.Result test(Datagram datagram);
}
