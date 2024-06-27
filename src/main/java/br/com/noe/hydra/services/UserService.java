package br.com.noe.hydra.services;

import br.com.noe.hydra.dtos.user.CreateUserAndAccountResponseDTO;
import br.com.noe.hydra.dtos.user.CreateUserRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.domain.models.User;
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
    private final BankAccountService bankAccountService;

    @Override
    public CreateUserAndAccountResponseDTO create(CreateUserRequestDTO createUserRequestDTO) throws BussinessException {
        var user = findOptionalByEmailOrCellphone(createUserRequestDTO.getEmail(), createUserRequestDTO.getCellphone());

        if (user.isPresent()) {
            throw new BussinessException("User already exists", HttpStatus.BAD_REQUEST);
        }

        var newUser = createUserRequestDTO.userRequestDTOToUserDomain();
        var createdUser = userRepository.save(newUser.userDomainToUser());

        return new CreateUserAndAccountResponseDTO(bankAccountService.create(createUserRequestDTO.getAgency(), createUserRequestDTO.getBank(), createdUser));
    }

    @Override
    public User findByEmailOrCellphone(String email, String cellphone) throws BussinessException {
        return findOptionalByEmailOrCellphone(email, cellphone).orElseThrow(
                () -> new BussinessException("User not found", HttpStatus.NOT_FOUND)
        );
    }

    private Optional<User> findOptionalByEmailOrCellphone(String email, String cellphone) {
        return userRepository.findByEmailOrCellphone(email, cellphone);
    }


}
