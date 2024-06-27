package br.com.noe.hydra.handlers;

import br.com.noe.hydra.dtos.exception.BussinessExceptionResponseDTO;
import br.com.noe.hydra.exception.BussinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BussinessExceptionResponseDTO> defaultErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(
                new BussinessExceptionResponseDTO(errors,
                        req.getRequestURI(),
                        req.getMethod(),
                        HttpStatus.BAD_REQUEST.value())
                , HttpStatus.BAD_REQUEST);
    }

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