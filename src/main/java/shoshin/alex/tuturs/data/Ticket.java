package shoshin.alex.tuturs.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ticket")
public class Ticket {
    private static int lastId = 0;
    private int id;
    private String destinationPoint;
    private String departurePoint;
    private Calendar destinationTime;
    private Calendar departureTime;
    private Price price;
    private TicketStatus status;
    private Passenger passenger;
    
    public Ticket() {
        status = TicketStatus.RESERVED;
    }
    public Ticket(int id) {
        this();
        this.id = id;
    }

//    уже лучше )) но коментарий относительно ws еще в силе
    public static int nextUniqueId() {
        return ++lastId;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDestinationPoint() {
        return destinationPoint;
    }
    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
    public String getDeparturePoint() {
        return departurePoint;
    }
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }
    public Calendar getDestinationTime() {
        return destinationTime;
    }
    public void setDestinationTime(Calendar destinationTime) {
        this.destinationTime = destinationTime;
    }
    public Calendar getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
    public TicketStatus getStatus() {
        return status;
    }
    public void setStatus(TicketStatus status) {
        this.status = status;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        return "ticket id - " + id
                + ", " + departurePoint
                + " - " + destinationPoint
                + ", departure time - " + formatter.format(departureTime.getTime())
                + ", destination time - " + formatter.format(destinationTime.getTime())
                + ", passenger - " + passenger
                + ", price - " + price
                + ", status - " + status;
    }
}