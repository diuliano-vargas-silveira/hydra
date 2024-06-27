package br.com.noe.hydra.domain;

import br.com.noe.hydra.domain.models.User;
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
    private BankAccountDomain bankAccountDomain;

    public User userDomainToUser() {
        User user = new User();

        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setCellphone(this.cellphone);
        user.setPassword(this.password);
        if (this.bankAccountDomain != null) {
            user.setBankAccount(this.bankAccountDomain.bankAccountDomainToBankAccountByCreate());
        }

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
