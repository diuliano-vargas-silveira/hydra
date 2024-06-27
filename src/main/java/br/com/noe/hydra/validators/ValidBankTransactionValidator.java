package br.com.noe.hydra.validators;

import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class ValidBankTransactionValidator implements ConstraintValidator<ValidBankTransaction, BankTransactionRequestDTO> {
    @Override
    public void initialize(ValidBankTransaction constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BankTransactionRequestDTO value, ConstraintValidatorContext context) {
        return (Objects.isNull(value.getEmail()) || value.getEmail().isEmpty()) &&
                (Objects.isNull(value.getCellphone()) || value.getCellphone().isEmpty());
    }

}
