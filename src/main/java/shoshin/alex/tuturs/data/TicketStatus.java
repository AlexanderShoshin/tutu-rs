package shoshin.alex.tuturs.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "status")
public enum TicketStatus {
    RESERVED, PAID
}