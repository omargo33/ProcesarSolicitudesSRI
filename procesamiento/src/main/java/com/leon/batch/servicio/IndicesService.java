package com.leon.batch.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.estructura.persistencia.crud.T00221CrudRepositorio;
import com.leon.estructura.persistencia.crud.T0022CrudRepositorio;
import com.leon.estructura.persistencia.entidad.T0022;
import com.leon.estructura.persistencia.entidad.T00221;
import com.leon.estructura.persistencia.entidad.T0022Id;

import lombok.extern.slf4j.Slf4j;

/**
 * Servicio de Indices
 * 
 * @author omargo33
 * @since 2024-04-28
 * 
 */
@Slf4j
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

        T0022 t0022 = t0022CrudRepositorio.findBySzCompanyAndSzTypeDocAndMnPeriodoFiscal(szCompany, szTypeDoc,
                mnPeriodoFiscal);

        if (t0022 == null) {
            createT0022Secuencial(szCompany, szTypeDoc, mnPeriodoFiscal);
            t0022 = t0022CrudRepositorio.findBySzCompanyAndSzTypeDocAndMnPeriodoFiscal(szCompany, szTypeDoc,
                    mnPeriodoFiscal);
        }

        mnNextNumber = t0022.getMnNextNumber();
        t0022.setMnNextNumber(mnNextNumber + 1);

        try {
            t0022CrudRepositorio.save(t0022);
        } catch (Exception e) {
            log.warn("Error al actualizar el indice T0022: {}", e.toString());
        }
        return mnNextNumber;
    }

    /**
     * Metodo para crear el indice en caso de no existir
     * 
     * @param szCompany
     * @param szTypeDoc
     * @param mnPeriodoFiscal
     */
    private void createT0022Secuencial(String szCompany, String szTypeDoc, Integer mnPeriodoFiscal) {

        T0022 t0022 = new T0022();
        t0022.setId(new T0022Id());
        t0022.getId().setSzCompany(szCompany);
        t0022.getId().setSzTypeDoc(szTypeDoc);
        t0022.getId().setMnPeriodoFiscal(mnPeriodoFiscal);
        t0022.setMnNextNumber(1);

        try {
            t0022CrudRepositorio.save(t0022);
        } catch (Exception e) {
            log.warn("Error al crear el indice T0022: {}", e.toString());
        }
    }

    /**
     * Metodo para obtener el siguiente secuencial de la tabla T00221
     * 
     * @param szObjeto
     * @return
     */
    public int getT00221Secuencial(String szObjeto) {
        int mnNextNumber = 0;

        T00221 t00221 = t00221CrudRepositorio.findBySzObjeto(szObjeto);
        if (t00221 == null) {
            createT00221Secuencial(szObjeto);
            t00221 = t00221CrudRepositorio.findBySzObjeto(szObjeto);
        }
        mnNextNumber = t00221.getMnNextNumber();
        t00221.setMnNextNumber(mnNextNumber + 1);
        try {
            t00221CrudRepositorio.save(t00221);
        } catch (Exception e) {
            log.warn("Error al actualizar el indice T00221: {}", e.toString());
        }
        return mnNextNumber;
    }

    /**
     * Metodo para crear el indice en caso de no existir
     * 
     */
    private void createT00221Secuencial(String szObjeto) {
        T00221 t00221 = new T00221();
        t00221.setSzObjeto(szObjeto);
        t00221.setMnNextNumber(1);

        try {
            t00221CrudRepositorio.save(t00221);
        } catch (Exception e) {
            log.warn("Error al crear el indice T00221: {}", e.toString());
        }
    }
}
