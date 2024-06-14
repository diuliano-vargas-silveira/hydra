package br.com.noe.hydra.repositories;

import br.com.noe.hydra.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("SELECT MAX(ba.account) FROM br.com.noe.hydra.models.BankAccount ba WHERE ba.agency = :agency")
    Optional<Integer> maxNumberFromAgency(String agency);

}
