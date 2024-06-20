package br.com.noe.hydra.domain;

import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.enums.TransactionsTypes;
import br.com.noe.hydra.models.BankAccount;
import br.com.noe.hydra.models.BankTransaction;

import java.math.BigDecimal;

public class BankTransactionDomain {

    private Long id;

    private final String message;
    private final BigDecimal value;
    private final TransactionsTypes transactionsType;
    private final BankAccount originBankAccount;
    private final BankAccount destinationBankAccount;

    public BankTransactionDomain(BankAccountDomain originBankAccount, BankAccountDomain destinationBankAccount,
                                 BankTransactionRequestDTO bankTransactionRequestDTO) {
        this.message = bankTransactionRequestDTO.getMessage();
        this.value = bankTransactionRequestDTO.getValue();
        this.transactionsType = bankTransactionRequestDTO.getTransactionType();
        this.originBankAccount = originBankAccount.bankAccountDomainToBankAccount();
        this.destinationBankAccount = destinationBankAccount.bankAccountDomainToBankAccount();
    }

    public BankTransaction bankTransactionDomainToBankTransaction() {
        var bankTransaction = new BankTransaction();
        bankTransaction.setId(this.id);
        bankTransaction.setMessage(this.message);
        bankTransaction.setValue(this.value);
        bankTransaction.setTransactionsType(this.transactionsType);
        bankTransaction.setOriginBankAccount(this.originBankAccount);
        bankTransaction.setDestinationBankAccount(this.destinationBankAccount);

        return bankTransaction;
    }
}
