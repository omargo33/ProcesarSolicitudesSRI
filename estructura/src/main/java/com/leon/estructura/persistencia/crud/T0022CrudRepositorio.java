package com.leon.estructura.persistencia.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T0022;
import com.leon.estructura.persistencia.entidad.T0022Id;


/**
 * Interface para manejar los registros de la tabla T0022
 * 
 * @author omargo33
 * @since 2024-04-10
 */ 
@Repository
public interface T0022CrudRepositorio extends CrudRepository<T0022, T0022Id> {

}
