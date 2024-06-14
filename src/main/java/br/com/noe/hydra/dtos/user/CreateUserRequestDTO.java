package br.com.noe.hydra.dtos.user;

import br.com.noe.hydra.domain.UserDomain;
import br.com.noe.hydra.enums.Bank;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreateUserRequestDTO {

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Size(min = 11, max = 11, message = "Cellphone must have 11 characters")
    @NotBlank(message = "Cellphone cannot be empty")
    private String cellphone;

    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @NotNull(message = "Agency is required")
    @Positive(message = "Agency must be a valid value")
    public Integer agency;

    @NotNull(message = "Bank is required")
    public Bank bank;

    public UserDomain userRequestDTOToUserDomain() {
        UserDomain user = new UserDomain();

        user.setName(this.name);
        user.setEmail(this.email);
        user.setCellphone(this.cellphone);
        user.setPassword(this.password);

        return user;
    }

}


