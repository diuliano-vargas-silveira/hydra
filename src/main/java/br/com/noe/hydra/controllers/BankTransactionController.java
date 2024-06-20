package br.com.noe.hydra.controllers;

import br.com.noe.hydra.controllers.interfaces.IBankTransactionController;
import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.exception.BussinessException;
import br.com.noe.hydra.services.BankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bank-transaction")
public class BankTransactionController implements IBankTransactionController {

    private final BankTransactionService bankTransactionService;

    @Override
    public ResponseEntity<Void> bankTransaction(BankTransactionRequestDTO bankTransactionRequestDTO) throws BussinessException {
        bankTransactionService.bankTransaction(bankTransactionRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
