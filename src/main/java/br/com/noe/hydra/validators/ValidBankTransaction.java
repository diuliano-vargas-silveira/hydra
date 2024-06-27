package br.com.noe.hydra.validators;

import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidBankTransactionValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface ValidBankTransaction {

    String message() default "Email or Cellphone is required";

    Class[] groups() default {};

    Class[] payload() default {};

}
