package br.com.noe.hydra.models;

import br.com.noe.hydra.enums.Bank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    private Long id;

    private Integer account;
    @Enumerated(EnumType.ORDINAL)
    private Bank bank;
    private String agency;
    private BigDecimal balance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "originBankAccount", fetch = FetchType.LAZY)
    private List<BankTransaction> originBankTransactions;

    @OneToMany(mappedBy = "destinationBankAccount", fetch = FetchType.LAZY)
    private List<BankTransaction> bankTransactions;

    public BankAccount(String agency, Bank bank, Integer account, User user) {
        this.agency = agency;
        this.bank = bank;
        this.account = account;
        this.user = user;
        this.balance = BigDecimal.ZERO;
        this.bankTransactions = new ArrayList<>();
    }

}
