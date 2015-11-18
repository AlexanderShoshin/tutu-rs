package shoshin.alex.tuturs.controllers;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shoshin.alex.tuturs.data.Passenger;
import shoshin.alex.tuturs.data.ReservationData;
import shoshin.alex.tuturs.data.Ticket;
import shoshin.alex.tuturs.data.TicketStatus;
import shoshin.alex.tuturs.data.TicketsBank;
import shoshin.alex.tuturs.errors.ChangeStatusException;
import shoshin.alex.tuturs.utils.TicketCalculator;

@Controller
public class TerminalServiceController {
    @Autowired
    TicketsBank ticketsBank;
    
    @PostConstruct
    public void init() {
        Passenger passenger = new Passenger("Alexander", "Shoshin", "", new GregorianCalendar(1987, 05, 16));
        Ticket ticket = new Ticket();
        ticket.setDeparturePoint("Tver");
        ticket.setDestinationPoint("Oslo");
        ticket.setPassenger(passenger);
        ticket.setPrice(TicketCalculator.getDefaultPrice());
        ticketsBank.addTicket(ticket);
    }
    
    @RequestMapping(value = "/reservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> reserveTicket(@RequestBody ReservationData reservationData) {
        Passenger passenger = new Passenger(reservationData.getPassengerName(),
                                            reservationData.getPassengerSurname(),
                                            reservationData.getPassengerPatronymic(),
                                            reservationData.getPassengerBirthDate());
        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setDeparturePoint(reservationData.getDeparturePoint());
        ticket.setDestinationPoint(reservationData.getDestinationPoint());
        ticket.setDepartureTime(reservationData.getDepartureTime());
        ticket.setDestinationTime(reservationData.getDestinationTime());
        ticket.setPrice(TicketCalculator.getDefaultPrice());
        ticketsBank.addTicket(ticket);
        
        return new ResponseEntity<>(ticket.getId(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") int ticketId) {
        Ticket ticket = ticketsBank.getTicket(ticketId);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/ticket/{ticketId}/pay", method = RequestMethod.POST)
    public ResponseEntity<?> payForTicket(@PathVariable("ticketId") int ticketId) {
        try {
            changeTicketStatus(ticketId, TicketStatus.PAID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException exc) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ChangeStatusException exc) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
    
    private void changeTicketStatus(int ticketId, TicketStatus status) throws ChangeStatusException {
        Ticket ticket = ticketsBank.getTicket(ticketId);
        if (ticket.getStatus().equals(status)) {
            throw new ChangeStatusException();
        }
        ticket.setStatus(TicketStatus.PAID);
    }
    
    @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> returnTicket(@PathVariable("ticketId") int ticketId) {
        ticketsBank.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}