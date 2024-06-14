package br.com.noe.hydra.controllers.interfaces;

import br.com.noe.hydra.dtos.user.CreateUserAndAccountResponseDTO;
import br.com.noe.hydra.dtos.user.CreateUserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    @PostMapping
    ResponseEntity<CreateUserAndAccountResponseDTO> createUser(@RequestBody @Valid CreateUserRequestDTO createUserRequestDTO) throws BussinessException;

}
