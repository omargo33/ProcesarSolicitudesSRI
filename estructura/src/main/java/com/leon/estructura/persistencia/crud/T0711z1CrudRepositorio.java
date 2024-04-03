package com.leon.estructura.persistencia.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T0711z1;
import com.leon.estructura.persistencia.entidad.T0711z1Id;

/**
 * Clase para manejar los registros de la tabla T0711z1
 * 
 * @author omargo33
 * @since 2024-04-03
 */
@Repository
public interface T0711z1CrudRepositorio extends CrudRepository<T0711z1, T0711z1Id> {

    
}
