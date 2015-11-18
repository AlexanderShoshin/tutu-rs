package shoshin.alex.tuturs.data;

import java.util.HashMap;
import java.util.Map;

public class SimpleTicketsBank implements TicketsBank {
    private Map<Integer, Ticket> tickets;
    
    public SimpleTicketsBank() {
        tickets = new HashMap<Integer, Ticket>(); 
    }
    
    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket getTicket(int ticketId) {
        return tickets.get(ticketId);
    }

    public Ticket deleteTicket(int ticketId) {
        return tickets.remove(ticketId);
    }
}