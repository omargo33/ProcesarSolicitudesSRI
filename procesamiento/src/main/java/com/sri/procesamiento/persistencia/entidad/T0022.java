package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA para la entidad T005 con la consulta: "SELECT szCompany, szTypeDoc,
 * mnPeriodoFiscal, szDescripcion, mnNextNumber FROM dveloper_catalina.t0022;"
 * 
 * Y la llave primera szCompany, szTypeDoc, mnPeriodoFiscal.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "T0022")
public class T0022 implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private T0022Pk id;

    @Column(name = "szDescripcion", length = 70)
    private String szDescripcion;

    @Column(name = "mnNextNumber")
    private Integer mnNextNumber;

}
