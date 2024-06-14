package br.com.noe.hydra.domain;

import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.models.BankAccount;
import br.com.noe.hydra.models.BankTransfer;
import br.com.noe.hydra.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<BankTransfer> bankTransfers;

    public BankAccountDomain(String agency, Bank bank, Integer account, UserDomain user) {
        this.agency = agency;
        this.bank = bank;
        this.account = account;
        this.user = user;
        this.balance = BigDecimal.ZERO;
        this.bankTransfers = new ArrayList<>();
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
}
