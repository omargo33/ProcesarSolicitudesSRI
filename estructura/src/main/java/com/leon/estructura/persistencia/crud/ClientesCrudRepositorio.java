package com.leon.estructura.persistencia.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.Cliente;

/**
 * Clase para manejar los clientes crud.
 * 
 * @author omargo33
 * @since 2024-03-28
 */
@Repository
public interface ClientesCrudRepositorio extends CrudRepository<Cliente, Integer> {

    /**
     * Buscar todos los clientes cuyo estado no sea 'X'
     * 
     */
    @Query(value = "SELECT c FROM Cliente c WHERE c.estado = 'A'")
    Optional<List<Cliente>> findAllActivos();

    /**
     * Buscar un cliente activo por sri_usuario
     * 
     */
    @Query(value = "SELECT c FROM Cliente c WHERE c.sriUsuario = ?1 AND c.estado <> 'X'")
    Optional<Cliente> findBySriUsuario(String sriUsuario);
}
