package shoshin.alex.tuturs.controllers;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shoshin.alex.tuturs.data.Passenger;
import shoshin.alex.tuturs.data.Ticket;
import shoshin.alex.tuturs.data.TicketsBank;
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
    /*
    @RequestMapping(value = "/reservation", method = RequestMethod.PUT)
    @ResponseBody
    public ReservationData reserveTicket(@RequestBody ReservationData reservationData) {
        System.out.println("server: " + reservationData.getPassengerName());
        return reservationData;
    }
    */
    @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
    @ResponseBody
    public Ticket getTicket(@PathVariable("ticketId") int ticketId) {
        return ticketsBank.getTicket(ticketId);
    }
}