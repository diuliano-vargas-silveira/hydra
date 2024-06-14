package br.com.noe.hydra.repositories;

import br.com.noe.hydra.models.BankTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankTransferRepository extends JpaRepository<BankTransfer, Long> {
}
