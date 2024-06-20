package br.com.noe.hydra.services.interfaces;

import br.com.noe.hydra.dtos.bank_transaction.BankTransactionRequestDTO;
import br.com.noe.hydra.exception.BussinessException;

public interface IBankTransactionService {

    void bankTransaction(BankTransactionRequestDTO bankTransactionRequestDTO) throws BussinessException;

}
