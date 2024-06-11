package br.com.noe.hydra.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BussinessException extends Exception {

    private final String message;
    private final HttpStatus status;

    public BussinessException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
