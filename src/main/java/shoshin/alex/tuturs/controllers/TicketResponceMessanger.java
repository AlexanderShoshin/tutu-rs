package shoshin.alex.tuturs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class TicketResponceMessanger implements ResponseMessanger {
    
    public <T> String generateGetMessage(ResponseEntity<T> response, int ticketId) {
        String message = "";
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            message = response.getBody().toString();
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            message = "ticket " + ticketId + " does not exist";
        }
        return message;
    }
    
    public String generateUpdateMessage(ResponseEntity<?> response, int ticketId) {
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
    
    public String generateDeleteMessage(ResponseEntity<?> response, int ticketId) {
        String message = "";
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            message = "ticket " + ticketId + " has been returned successfully";
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            message = "ticket " + ticketId + " does not exist";
        }
        return message;
    }
}