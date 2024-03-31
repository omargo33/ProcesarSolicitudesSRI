package com.leon.estructura.persistencia.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.Parametro;

/**
 * Clase para manejar los parametros crud.
 * 
 * @author omargo33
 * @since 2024-03-31
 */
@Repository
public interface ParametroCrudRepositorio extends CrudRepository<Parametro, Integer> {

    /**
     * Metodo para buscar todos los parametros cuyo estado no sea 'X'
     */
    @Query(value = "SELECT p FROM Parametro p WHERE p.estado <> 'X'")
    Optional<List<Parametro>> findAllActivos();

    /**
     * Metodo para buscar un parametro activo por su indice
     */
    @Query(value = "SELECT p FROM Parametro p WHERE p.indice = ?1 AND p.estado <> 'X'")
    Optional<Parametro> findByIndice(int indice);

    /**
     * Metodo para buscar un parametro activo una lista de indices
     */
    @Query(value = "SELECT p FROM Parametro p WHERE p.indice IN ?1 AND p.estado <> 'X'")
    Optional<List<Parametro>> findByIndices(List<Integer> indices);
     
}
