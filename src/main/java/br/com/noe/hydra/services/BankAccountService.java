package br.com.noe.hydra.services;

import br.com.noe.hydra.domain.BankAccountDomain;
import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.models.BankAccount;
import br.com.noe.hydra.models.User;
import br.com.noe.hydra.repositories.BankAccountRepository;
import br.com.noe.hydra.services.interfaces.IBankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService implements IBankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccount create(Integer agency, Bank bank, User user) {
        String agencyFormatted = BankAccountDomain.formatAgency(agency);
        Integer maxAccountNumber = bankAccountRepository
                .maxNumberFromAgencyAndBank(agencyFormatted, bank).orElse(0);

        Integer account = maxAccountNumber + 1;

        return bankAccountRepository.save(new BankAccount(agencyFormatted, bank, account, user));
    }

    public BankAccount findByAgencyAndAccountAndBank(Integer agency, Integer account, Bank bank) throws BussinessException {
        return bankAccountRepository.findByAgencyAndAccountAndBank(BankAccountDomain.formatAgency(agency), account, bank.ordinal())
                .orElseThrow(() -> new BussinessException("Bank account not found", HttpStatus.NOT_FOUND));
    }

}
