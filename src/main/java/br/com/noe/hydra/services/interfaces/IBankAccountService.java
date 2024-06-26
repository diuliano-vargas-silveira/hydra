package br.com.noe.hydra.services.interfaces;

import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.domain.models.BankAccount;
import br.com.noe.hydra.domain.models.User;

public interface IBankAccountService {

    BankAccount create(Integer agency, Bank bank, User user);

    BankAccount findByAgencyAndAccountAndBank(Integer agency, Integer account, Bank bank) throws BussinessException;

}
