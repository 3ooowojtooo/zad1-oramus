package interfaces;

import java.util.Set;

public interface Datagram {
    /**
     * Metoda zwraca źródłowy adres IPv4.
     *
     * @return adres źródłowy datagramu
     */
    public String getSourceAddress();

    /**
     * Metoda zwraca docelowy adres IPv4.
     *
     * @return adres calu datagramu
     */
    public String getDestinationAddress();

    /**
     * Metoda zwraca informację o przenoszonym przez datagram protokole.
     *
     * @return przenoszony protokół
     */
    public Protocol getProtocol();

    /**
     * Ustawione flagi
     *
     * @return flagi
     */
    public Set<Flag> getFlags();

    /**
     * Typ wyliczeniowy określający przenoszony przez datagram protokół. <br>
     * ANY oznacza dowolny protokołu - istotne wyłącznie dla warunków.
     */
    public enum Protocol {
        ANY, TCP, UDP, ICMP,
        ;
    }

    /**
     * Typ wyliczeniowy określający ustawione w datagramie flagi. <br>
     * ANY oznacza dowolną flagę - istotne wyłącznie dla warunków. <br>
     * NON oznacza brak ustawionych flag.
     */
    public enum Flag {
        NON, ANY, SYN, ACL, RST, FIN,
        ;
    }
}