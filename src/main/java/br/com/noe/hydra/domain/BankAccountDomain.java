package br.com.noe.hydra.domain;

import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.domain.models.BankAccount;
import br.com.noe.hydra.domain.models.BankTransaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BankAccountDomain {

    private Long id;
    private Integer account;
    private Bank bank;
    private String agency;
    private BigDecimal balance;
    private UserDomain user;
    private List<BankTransaction> bankTransactions;

    public BankAccountDomain(String agency, Bank bank, Integer account, UserDomain user) {
        this.agency = agency;
        this.bank = bank;
        this.account = account;
        this.user = user;
        this.balance = BigDecimal.ZERO;
        this.bankTransactions = new ArrayList<>();
    }

    public BankAccountDomain(BankAccount bankAccount) {
        this.id = bankAccount.getId();
        this.account = bankAccount.getAccount();
        this.bank = bankAccount.getBank();
        this.agency = bankAccount.getAgency();
        this.balance = bankAccount.getBalance();
        this.user = UserDomain.userToUserDomain(bankAccount.getUser());
        this.bankTransactions = bankAccount.getBankTransactions();
    }

    public static String formatAgency(Integer agency) {
        return String.format("%06d", agency);
    }


    public BankAccount bankAccountDomainToBankAccountByCreate() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setId(this.id);
        bankAccount.setAccount(this.account);
        bankAccount.setBank(this.bank);
        bankAccount.setAgency(this.agency);
        bankAccount.setBalance(this.balance);

        return bankAccount;
    }

    public BankTransactionDomain bankTransaction(BankAccountDomain bankAccount, BankTransactionRequestDTO bankTransactionRequestDTO) throws BussinessException {
        switch (bankTransactionRequestDTO.getTransactionType()) {
            case DEPOSIT -> deposit(bankTransactionRequestDTO.getValue());
            case WITHDRAW -> withdraw(bankTransactionRequestDTO.getValue());
            case TRANSFER -> transfer(bankAccount, bankTransactionRequestDTO.getValue());
            default -> throw new BussinessException("Invalid transaction type", HttpStatus.BAD_REQUEST);
        }

        return new BankTransactionDomain(this, bankAccount, bankTransactionRequestDTO);
    }
    
    private void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }


    private void withdraw(BigDecimal value) throws BussinessException {
        if (isNonValidTransfer(value)) {
            throw new BussinessException("Insufficient balance", HttpStatus.BAD_REQUEST);
        }

        this.balance = this.balance.subtract(value);
    }

    private void transfer(BankAccountDomain bankAccount, BigDecimal value) throws BussinessException {
        if (isNonValidTransfer(value)) {
            throw new BussinessException("Insufficient balance", HttpStatus.BAD_REQUEST);
        }

        this.balance = this.balance.subtract(value);
        bankAccount.setBalance(bankAccount.getBalance().add(value));
    }


    private boolean isNonValidTransfer(BigDecimal value) {
        return this.balance.compareTo(value) < 0;
    }

    public BankAccount bankAccountDomainToBankAccount() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setId(this.id);
        bankAccount.setAccount(this.account);
        bankAccount.setBank(this.bank);
        bankAccount.setAgency(this.agency);
        bankAccount.setBalance(this.balance);
        bankAccount.setUser(this.user.userDomainToUser());
        bankAccount.setBankTransactions(this.bankTransactions);

        return bankAccount;
    }
}
