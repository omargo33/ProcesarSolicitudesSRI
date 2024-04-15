package com.leon.estructura.persistencia.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T57011;
import com.leon.estructura.persistencia.entidad.T57011Id;


/**
 * Interfaz que extiende de CrudRepository para realizar operaciones CRUD sobre la entidad T57011.
 * 
 * @author omargo33
 * @since 2024-04-10
 */
@Repository
public interface T57011CrudRepositorio extends CrudRepository<T57011, T57011Id> {

    /**
     * Metodo para buscar max( mnJobNumber ) en la tabla T57011, con un query personalizado
     */
    @Query(value = "SELECT MAX(mnJobNumber) FROM T57011", nativeQuery = true)
    Integer findMaxMnJobNumber();

}
