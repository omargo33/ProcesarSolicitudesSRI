package com.leon.clientes.persistencia.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.leon.clientes.persistencia.entidad.Clientes;

/**
 * Clase para manejar los clientes crud.
 * 
 * @author omargo33
 * @since 2024-03-28
 */
public interface ClientesCrudRepositorio extends CrudRepository<Clientes, Integer>{

    /**
     * Buscar todos los clientes cuyo estado no sea 'X'
     * 
     */
    @Query(value = "SELECT c FROM Clientes c WHERE c.estado <> 'X'")
    Optional<List<Clientes>> findAllActivos();
}
