package br.com.noe.hydra.controllers.interfaces;

import br.com.noe.hydra.dtos.user.UserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    @PostMapping
    ResponseEntity<Void> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) throws BussinessException;

}
