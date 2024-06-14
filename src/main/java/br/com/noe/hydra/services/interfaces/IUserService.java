package br.com.noe.hydra.services.interfaces;

import br.com.noe.hydra.dtos.user.CreateUserAndAccountResponseDTO;
import br.com.noe.hydra.dtos.user.CreateUserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;

public interface IUserService {

    CreateUserAndAccountResponseDTO create(CreateUserRequestDTO createUserRequestDTO) throws BussinessException;

}
