package br.com.noe.hydra.services.interfaces;

import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.models.BankAccount;
import br.com.noe.hydra.models.User;

public interface IBankAccountService {

    BankAccount create(Integer agency, Bank bank, User user);

}
