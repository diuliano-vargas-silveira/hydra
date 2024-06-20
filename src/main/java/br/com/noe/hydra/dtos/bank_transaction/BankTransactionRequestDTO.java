package br.com.noe.hydra.dtos.bank_transaction;

import br.com.noe.hydra.enums.Bank;
import br.com.noe.hydra.enums.TransactionsTypes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BankTransactionRequestDTO {

    @NotNull(message = "Value is required")
    @Positive(message = "Value must be greater than 0")
    private BigDecimal value;

    @NotNull(message = "Transaction type is required")
    private TransactionsTypes transactionType;

    @Positive(message = "Account must be a valid value")
    private Integer account;

    @Positive(message = "Agency must be a valid value")
    private Integer agency;

    private Bank bank;

    @Size(min = 0, max = 50, message = "Message must be between 3 and 50 characters")
    private String message;

    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 11, max = 11, message = "Cellphone must have 11 characters")
    private String cellphone;

}
