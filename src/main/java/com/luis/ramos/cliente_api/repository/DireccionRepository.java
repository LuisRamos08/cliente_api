package com.luis.ramos.cliente_api.repository;

import com.luis.ramos.cliente_api.model.Direccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion,Long> {
}
