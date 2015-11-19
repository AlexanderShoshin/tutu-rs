package shoshin.alex.tuturs.controllers;

import org.springframework.http.ResponseEntity;

interface ResponseMessanger {
    public <T> String generateGetMessage(ResponseEntity<T> response, int itemId);
    public String generateUpdateMessage(ResponseEntity<?> response, int itemId);
    public String generateDeleteMessage(ResponseEntity<?> response, int itemId);
}