package br.com.noe.hydra.dtos.user;

import br.com.noe.hydra.domain.UserDomain;
import br.com.noe.hydra.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class UserRequestDTO {

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

    public static User userRequestDTOToUser(UserRequestDTO userRequestDTO) {
        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setCellphone(userRequestDTO.getCellphone());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }

}
