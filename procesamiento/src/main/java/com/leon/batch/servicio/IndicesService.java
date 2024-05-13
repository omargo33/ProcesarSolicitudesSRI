package com.leon.batch.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.estructura.persistencia.crud.T00221CrudRepositorio;
import com.leon.estructura.persistencia.crud.T0022CrudRepositorio;
import com.leon.estructura.persistencia.entidad.T0022;
import com.leon.estructura.persistencia.entidad.T00221;


/**
 * Servicio de Indices
 * 
 * @author omargo33
 * @since 2024-04-28
 *  
 */
@Service
@Transactional
public class IndicesService {
    
    @Autowired
    private T0022CrudRepositorio t0022CrudRepositorio;
    
    @Autowired
    private T00221CrudRepositorio t00221CrudRepositorio;

    /**
     * Metodo para obtener el siguiente secuencial
     * 
     * @param szCoompany
     * @param szTypeDoc
     * @param mnPeriodoFiscal
     * @return
     */
    public int getT0022Secuencial(String szCompany, String szTypeDoc, Integer mnPeriodoFiscal) {
        int mnNextNumber = 0; 

        T0022 t0022 =  t0022CrudRepositorio.findBySzCompanyAndSzTypeDocAndMnPeriodoFiscal(szCompany, szTypeDoc, mnPeriodoFiscal);
        mnNextNumber = t0022.getMnNextNumber();
        t0022.setMnNextNumber(mnNextNumber + 1);
        t0022CrudRepositorio.save(t0022);

        return mnNextNumber;
    }

    /**
     * Metodo para obtener el siguiente secuencial de la tabla T00221
     * 
     * @param szObjeto
     * @return
     */
    public int getT00221Secuencial(String szObjeto){
        int mnNextNumber = 0;

        T00221 t00221 = t00221CrudRepositorio.findBySzObjeto(szObjeto);
        mnNextNumber = t00221.getMnNextNumber();
        t00221.setMnNextNumber(mnNextNumber + 1);
        t00221CrudRepositorio.save(t00221);

        return mnNextNumber;
    }
}
