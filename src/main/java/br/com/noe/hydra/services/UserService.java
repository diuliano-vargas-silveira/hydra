package br.com.noe.hydra.services;

import br.com.noe.hydra.dtos.user.UserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.models.User;
import br.com.noe.hydra.repositories.UserRepository;
import br.com.noe.hydra.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserRequestDTO userRequestDTO) throws BussinessException {
        Optional<User> user = userRepository.findByEmailOrCellphone(userRequestDTO.getEmail(), userRequestDTO.getCellphone());

        if (user.isPresent()) {
            throw new BussinessException("User already exists", HttpStatus.BAD_REQUEST);
        }

        User newUser = UserRequestDTO.userRequestDTOToUser(userRequestDTO);

        userRepository.save(newUser);
    }

}
