package shoshin.alex.tuturs.controllers;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import shoshin.alex.tuturs.data.ReservationData;
import shoshin.alex.tuturs.data.Ticket;
import shoshin.alex.tuturs.data.TicketStatus;
import shoshin.alex.tuturs.utils.ServiceRequest;

@Controller
public class TerminalClientController {
    private static final String ticketServiceUrl = "http://localhost:8081/tutu-rs/ticket/";
    private static final String ticketUrl = ticketServiceUrl + "{id}";
    
    @RequestMapping(value = "/terminal",
                    params = {"name",
                              "surname",
                              "patronymic",
                              "birthDay", "birthMonth", "birthYear",
                              "departurePoint",
                              "departureDay", "departureMonth", "departureYear", "departureHours", "departureMinutes",
                              "destinationPoint",
                              "destinationDay", "destinationMonth", "destinationYear", "destinationHours", "destinationMinutes"})
    public String reserveTicket(Model model,
                  @RequestParam String name,
                  @RequestParam String surname,
                  @RequestParam String patronymic,
                  @RequestParam int birthDay,
                  @RequestParam int birthMonth,
                  @RequestParam int birthYear,
                  @RequestParam String departurePoint,
                  @RequestParam int departureDay,
                  @RequestParam int departureMonth,
                  @RequestParam int departureYear,
                  @RequestParam int departureHours,
                  @RequestParam int departureMinutes,
                  @RequestParam String destinationPoint,
                  @RequestParam int destinationDay,
                  @RequestParam int destinationMonth,
                  @RequestParam int destinationYear,
                  @RequestParam int destinationHours,
                  @RequestParam int destinationMinutes) throws DatatypeConfigurationException {
        RestTemplate restTemplate = new RestTemplate();
        ReservationData reservationData = new ReservationData();
        String ticketId;
        
        reservationData.setPassengerName(name);
        reservationData.setPassengerSurname(surname);
        reservationData.setPassengerPatronymic(patronymic);
        reservationData.setPassengerBirthDate(new GregorianCalendar(birthYear, birthMonth, birthDay));
        reservationData.setDeparturePoint(departurePoint);
        reservationData.setDepartureTime(new GregorianCalendar(departureYear, departureMonth, departureDay, departureHours, departureMinutes));
        reservationData.setDestinationPoint(destinationPoint);
        reservationData.setDestinationTime(new GregorianCalendar(destinationYear, destinationMonth, destinationDay, destinationHours, destinationMinutes));
        
        ticketId = restTemplate.postForObject(ticketServiceUrl, reservationData, String.class);
        
        model.addAttribute("resultInfo", "ticket number " + ticketId + " reserved to " + name + " " + surname);
        model.addAttribute("ticketId", ticketId);
        
        return getTerminalPage(model);
    }
    
    @RequestMapping(value = "/terminal", params = {"getTicket"})
    public String getTicket(Model model, @RequestParam(value = "getTicket") int ticketId) {
        ResponseEntity<Ticket> response = ServiceRequest.doRequest(ticketUrl,
                                                                   HttpMethod.GET,
                                                                   ServiceRequest.getTicketRequestParams(ticketId),
                                                                   Ticket.class);
        String message = generateGetResponseMessage(response, ticketId);
        
        model.addAttribute("resultInfo", message);
        model.addAttribute("ticketId", ticketId);
        
        return getTerminalPage(model);
    }
    
    private String generateGetResponseMessage(ResponseEntity<Ticket> response, int ticketId) {
        String message = "";
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            message = response.getBody().toString();
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            message = "ticket " + ticketId + " does not exist";
        }
        return message;
    }
    
    @RequestMapping(value = "/terminal", params = {"payForTicket"})
    public String payForTicket(Model model, @RequestParam(value = "payForTicket") int ticketId) {
        ResponseEntity<?> response = ServiceRequest.doRequest(ticketUrl,
                                                              HttpMethod.PUT,
                                                              TicketStatus.PAID,
                                                              "application/xml",
                                                              ServiceRequest.getTicketRequestParams(ticketId));
        
        String message = generatePayResponseMessage(response, ticketId);
        
        model.addAttribute("resultInfo", message);
        model.addAttribute("ticketId", ticketId);
        
        return getTerminalPage(model);
    }
    
    private String generatePayResponseMessage(ResponseEntity<?> response, int ticketId) {
        String message = "";
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            message = "ticket " + ticketId + " has been paid successfully";
        } else if (response.getStatusCode().equals(HttpStatus.NOT_MODIFIED)) {
            message = "ticket " + ticketId + " is already paid";
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            message = "ticket " + ticketId + " does not exist";
        }
        return message;
    }
    
    @RequestMapping(value = "/terminal", params = {"returnTicket"})
    public String returnTicket(Model model, @RequestParam(value = "returnTicket") int ticketId) {
        ResponseEntity<?> response = ServiceRequest.doRequest(ticketUrl,
                                                              HttpMethod.DELETE,
                                                              ServiceRequest.getTicketRequestParams(ticketId));
        String message = generateDeleteResponseMessage(response, ticketId);
        
        model.addAttribute("resultInfo", message);
        model.addAttribute("ticketId", ticketId);
        
        return getTerminalPage(model);
    }
    
    private String generateDeleteResponseMessage(ResponseEntity<?> response, int ticketId) {
        String message = "";
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            message = "ticket " + ticketId + " has been returned successfully";
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            message = "ticket " + ticketId + " does not exist";
        }
        return message;
    }
    
    @RequestMapping(value = "/terminal")
    public String getTerminalPage(Model model) {
        return "terminal";
    }
}