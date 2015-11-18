package shoshin.alex.tuturs.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class ServiceRequest {
    public static <T, E> ResponseEntity<E> doRequest(String url, HttpMethod method, T requestContent, String contentType, Map<String, Integer> params, Class<E> responseType) {
        ResponseEntity<E> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", contentType);
        HttpEntity<T> requestEntity = new HttpEntity<>(requestContent, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.exchange(url, method, requestEntity, responseType, params);
        } catch (HttpClientErrorException ex) {
            responseEntity = new ResponseEntity<>(ex.getStatusCode());
        }
        return responseEntity;
    }
    
    public static <T, E> ResponseEntity<E> doRequest(String url, HttpMethod method, Map<String, Integer> params, Class<E> responseType) {
        return doRequest(url, method, null, "*/*", params, responseType);
    }
    
    public static <T> ResponseEntity<?> doRequest(String url, HttpMethod method, T requestContent, String contentType, Map<String, Integer> params) {
        return doRequest(url, method, requestContent, contentType, params, String.class);
    }
    
    public static <T> ResponseEntity<?> doRequest(String url, HttpMethod method, Map<String, Integer> params) {
        return doRequest(url, method, null, "*/*", params, String.class);
    }
    
    public static Map<String, Integer> getTicketRequestParams(int ticketId) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", ticketId);
        return params;
    }
}