package br.com.noe.hydra.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "bank_transfer")
public class BankTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_transfer_id")
    private Long id;

    private String message;
    private BigDecimal transferValue;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BankAccount origin;

}