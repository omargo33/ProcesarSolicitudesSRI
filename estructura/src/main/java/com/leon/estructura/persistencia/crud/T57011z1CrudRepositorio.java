package com.leon.estructura.persistencia.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T57011z1;
import com.leon.estructura.persistencia.entidad.T57011z1Id;

/**
 * Interfaz que extiende de CrudRepository para realizar operaciones CRUD sobre la entidad T57011.
 * 
 * @author omargo33
 * @since 2024-04-10
 */
@Repository
public interface T57011z1CrudRepositorio extends CrudRepository<T57011z1, T57011z1Id> {
}

