package io.github.Ital023.CrudClientes.repositories;

import io.github.Ital023.CrudClientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
