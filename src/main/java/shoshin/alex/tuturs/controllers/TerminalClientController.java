package shoshin.alex.tuturs.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TerminalClientController {
    @RequestMapping(value = "/terminal", params = {"name",
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
        /*
        String uri = "http://localhost/tutu-rs/res";
        ReservationData reservationData = new ReservationData();
        reservationData.setPassengerName(name);
        reservationData.setPassengerSurname(surname);
        reservationData.setPassengerPatronymic(patronymic);
        reservationData.setPassengerBirthDate(newDate(birthYear, birthMonth, birthDay));
        reservationData.setDeparturePoint(departurePoint);
        reservationData.setDepartureTime(newDate(departureYear, departureMonth, departureDay, departureHours, departureMinutes));
        reservationData.setDestinationPoint(destinationPoint);
        reservationData.setDestinationTime(newDate(destinationYear, destinationMonth, destinationDay, destinationHours, destinationMinutes));
        
        System.out.println("before");
        restTemplate.put(uri, reservationData);
        System.out.println("after");
        
        */
        /*
        model.addAttribute("resultInfo", "ticket number " + ticketId + " reserved to " + name + " " + surname);
        model.addAttribute("ticketId", ticketId);
        */
        return getTerminalPage(model);
    }
    
    private Calendar newDate(int year, int month, int day) {
        return new GregorianCalendar(year, month, day);
    }
    
    private Calendar newDate(int year, int month, int day, int hour, int minutes) {
        return new GregorianCalendar(year, month, day, hour, minutes);
    }
    
    @RequestMapping(value = "/terminal", params = {"getTicket"})
    public String getTicket(Model model, @RequestParam(value = "getTicket") int ticketId) {
        return getTerminalPage(model);
    }
    
    @RequestMapping(value = "/terminal", params = {"payForTicket"})
    public String payForTicket(Model model, @RequestParam(value = "payForTicket") int ticketId) {
        return getTerminalPage(model);
    }
    
    @RequestMapping(value = "/terminal", params = {"returnTicket"})
    public String returnTicket(Model model, @RequestParam(value = "returnTicket") int ticketId) {
        return getTerminalPage(model);
    }
    
    @RequestMapping(value = "/terminal")
    public String getTerminalPage(Model model) {
        return "terminal";
    }
}