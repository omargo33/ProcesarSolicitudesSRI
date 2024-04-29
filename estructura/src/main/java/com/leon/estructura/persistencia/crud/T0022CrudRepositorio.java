package com.leon.estructura.persistencia.crud;

import org.springframework.data.jpa.repository.Query;
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

    /**
     * Metodo para buscar un registro por szCompany, szTypeDoc y mnPeriodoFiscal
     * 
     */
    @Query("SELECT t FROM T0022 t WHERE t.id.szCompany = ?1 AND t.id.szTypeDoc = ?2 AND t.id.mnPeriodoFiscal = ?3")
    public T0022 findBySzCompanyAndSzTypeDocAndMnPeriodoFiscal(String szCompany, String szTypeDoc, Integer mnPeriodoFiscal);
}
