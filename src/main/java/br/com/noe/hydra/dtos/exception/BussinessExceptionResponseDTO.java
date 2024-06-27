package br.com.noe.hydra.dtos.exception;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BussinessExceptionResponseDTO {

    private String message;
    private List<String> errors;
    private String endpointURI;
    private String method;
    private Integer status;

    public BussinessExceptionResponseDTO(String endpointURI, String message, String method, Integer status) {
        this.endpointURI = endpointURI;
        this.message = message;
        this.method = method;
        this.status = status;
    }

    public BussinessExceptionResponseDTO(List<String> errors, String endpointURI, String method, Integer status) {
        this.errors = errors;
        this.endpointURI = endpointURI;
        this.status = status;
        this.method = method;
    }
}
