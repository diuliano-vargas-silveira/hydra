package br.com.noe.hydra.dtos.user;

import br.com.noe.hydra.models.BankAccount;
import lombok.Getter;

@Getter
public class CreateUserAndAccountResponseDTO {

    private final String agency;
    private final Integer account;

    public CreateUserAndAccountResponseDTO(BankAccount bankAccount) {
        this.agency = bankAccount.getAgency();
        this.account = bankAccount.getAccount();
    }

}
