package br.com.noe.hydra.controllers;

import br.com.noe.hydra.controllers.interfaces.IUserController;
import br.com.noe.hydra.dtos.user.CreateUserAndAccountResponseDTO;
import br.com.noe.hydra.dtos.user.CreateUserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    private final UserService userService;

    @Override
    public ResponseEntity<CreateUserAndAccountResponseDTO> createUser(CreateUserRequestDTO createUserRequestDTO) throws BussinessException {
        return new ResponseEntity<>(userService.create(createUserRequestDTO), HttpStatus.CREATED);
    }

}
