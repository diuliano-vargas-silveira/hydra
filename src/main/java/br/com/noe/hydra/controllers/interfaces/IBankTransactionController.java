package br.com.noe.hydra.controllers.interfaces;

import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBankTransactionController {

    @PostMapping
    ResponseEntity<Void> bankTransaction(@RequestBody @Valid BankTransactionRequestDTO bankTransactionRequestDTO) throws BussinessException;

}
