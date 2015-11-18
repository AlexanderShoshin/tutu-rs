package shoshin.alex.tuturs.data;

import java.util.Calendar;

public class ReservationData {
    private String destinationPoint;
    private String departurePoint;
    private Calendar destinationTime;
    private Calendar departureTime;
    private String passengerName;
    private String passengerSurname;
    private String passengerPatronymic;
    private Calendar passengerBirthDate;
    
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
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getPassengerSurname() {
        return passengerSurname;
    }
    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }
    public String getPassengerPatronymic() {
        return passengerPatronymic;
    }
    public void setPassengerPatronymic(String passengerPatronymic) {
        this.passengerPatronymic = passengerPatronymic;
    }
    public Calendar getPassengerBirthDate() {
        return passengerBirthDate;
    }
    public void setPassengerBirthDate(Calendar passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }
}