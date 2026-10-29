package sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Override
    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByLogin(String login);
}
