package br.com.noe.hydra.services;

import br.com.noe.hydra.domain.BankAccountDomain;
import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.enums.TransactionsTypes;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.repositories.BankTransactionRepository;
import br.com.noe.hydra.services.interfaces.IBankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BankTransactionService implements IBankTransactionService {

    private final BankTransactionRepository bankTransactionRepository;
    private final BankAccountService bankAccountService;
    private final UserService userService;

    public void bankTransaction(BankTransactionRequestDTO bankTransactionRequestDTO) throws BussinessException {
        var user = userService.findByEmailOrCellphone(bankTransactionRequestDTO.getEmail(), bankTransactionRequestDTO.getCellphone());

        BankAccountDomain bankAccountToTransfer = null;
        if (bankTransactionRequestDTO.getTransactionType().equals(TransactionsTypes.TRANSFER)) {
            var bankAccount = bankAccountService.findByAgencyAndAccountAndBank(bankTransactionRequestDTO.getAgency(),
                    bankTransactionRequestDTO.getAccount(),
                    bankTransactionRequestDTO.getBank());

            bankAccountToTransfer = new BankAccountDomain(bankAccount);
        }

        var bankAccountDomain = new BankAccountDomain(user.getBankAccount());

        var bankTransactionDomain = bankAccountDomain.bankTransaction(bankAccountToTransfer, bankTransactionRequestDTO);

        bankTransactionRepository.save(bankTransactionDomain.bankTransactionDomainToBankTransaction());
    }

}
