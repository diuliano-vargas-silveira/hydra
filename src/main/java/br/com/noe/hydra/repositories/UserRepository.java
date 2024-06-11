package br.com.noe.hydra.repositories;

import br.com.noe.hydra.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailOrCellphone(String email, String cellphone);

}
