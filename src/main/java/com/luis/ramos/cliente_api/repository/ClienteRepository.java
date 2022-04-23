package com.luis.ramos.cliente_api.repository;

import com.luis.ramos.cliente_api.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
