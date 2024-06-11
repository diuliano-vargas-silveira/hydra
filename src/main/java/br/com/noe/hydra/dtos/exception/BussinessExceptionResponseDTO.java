package br.com.noe.hydra.dtos.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BussinessExceptionResponseDTO {

    private String message;
    private String endpointURI;
    private String method;
    private Integer status;

}
