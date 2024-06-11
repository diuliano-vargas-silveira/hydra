package br.com.noe.hydra.services.interfaces;

import br.com.noe.hydra.dtos.user.UserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;

public interface IUserService {

    void create(UserRequestDTO userRequestDTO) throws BussinessException;

}
