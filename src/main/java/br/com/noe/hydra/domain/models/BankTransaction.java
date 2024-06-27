package br.com.noe.hydra.domain.models;

import br.com.noe.hydra.enums.TransactionsTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "bank_transfer")
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_transfer_id")
    private Long id;

    private String message;
    private BigDecimal value;
    @Enumerated
    private TransactionsTypes transactionsType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BankAccount originBankAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private BankAccount destinationBankAccount;

}