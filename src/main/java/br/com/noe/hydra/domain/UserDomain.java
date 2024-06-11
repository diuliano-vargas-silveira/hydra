package br.com.noe.hydra.domain;

import br.com.noe.hydra.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDomain {

    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String password;

    public static User userDomainToUser(UserDomain userDomain) {
        User user = new User();

        user.setId(userDomain.getId());
        user.setName(userDomain.getName());
        user.setEmail(userDomain.getEmail());
        user.setCellphone(userDomain.getCellphone());
        user.setPassword(userDomain.getPassword());

        return user;
    }

    public static UserDomain userToUserDomain(User user) {
        UserDomain userDomain = new UserDomain();

        userDomain.setId(user.getId());
        userDomain.setName(user.getName());
        userDomain.setEmail(user.getEmail());
        userDomain.setCellphone(user.getCellphone());
        userDomain.setPassword(user.getPassword());

        return userDomain;
    }

}
