package fr.dawan.sitecritiqueprojet.controllers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.dawan.sitecritiqueprojet.response.ApiResponse;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandlerController extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleEmailAlreadyExists(EmailExistsException ex, String email) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.CONFLICT);
        apiResponse.setMessage(ex.getMessage() + ": " + email);

        return buildResponseEntity(apiResponse);
    }

    protected ResponseEntity<Object> handleUsernameNotFound(UsernameNotFoundException ex, String username) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.UNAUTHORIZED);
        apiResponse.setMessage(ex.getMessage());

        return buildResponseEntity(apiResponse);
    } 


    private ResponseEntity<Object> buildResponseEntity(ApiResponse apiResponse) {
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }
    
}
