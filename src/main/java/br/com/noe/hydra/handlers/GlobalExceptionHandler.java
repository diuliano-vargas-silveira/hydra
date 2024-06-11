package br.com.noe.hydra.handlers;

import br.com.noe.hydra.dtos.exception.BussinessExceptionResponseDTO;
import br.com.noe.hydra.exception.BussinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BussinessException.class)
    public ResponseEntity<BussinessExceptionResponseDTO> defaultErrorHandler(HttpServletRequest req, BussinessException e) {
        return new ResponseEntity<>(
                new BussinessExceptionResponseDTO(e.getMessage(),
                        req.getRequestURI(),
                        req.getMethod(), 
                        e.getStatus().value())
                , e.getStatus());
    }

}