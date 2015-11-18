package shoshin.alex.tuturs.data;

public interface TicketsBank {
    void addTicket(Ticket ticket);
    Ticket getTicket(int ticketId);
    Ticket deleteTicket(int ticketId);
}