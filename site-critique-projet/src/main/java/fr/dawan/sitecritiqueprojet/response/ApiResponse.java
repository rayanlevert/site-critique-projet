package fr.dawan.sitecritiqueprojet.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import fr.dawan.sitecritiqueprojet.beans.User;


public class ApiResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private Object subObject;

    private ApiResponse() {
        timestamp = LocalDateTime.now();
    }
 
    public ApiResponse(HttpStatus status) {
        this();
        this.status = status;
    }
 
    public ApiResponse(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiResponse(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public ApiResponse(HttpStatus status, String message, Object subObject) {
        this();
        this.status = status;
        this.message = message;
        this.subObject = subObject;
    }
 
    public ApiResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public Object getSubObject() {
        return subObject;
    }

    public void setSubObject(Object subObject) {
        this.subObject = subObject;
    }
}
