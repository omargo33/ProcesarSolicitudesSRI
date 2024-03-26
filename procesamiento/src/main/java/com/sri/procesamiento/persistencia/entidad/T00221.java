package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA para la entidad T00224 con la consulta: "SELECT szObjeto, mnNextNumber FROM dveloper_catalina.t00221;"
 * 
 * Y la llave primera szObjeto.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "T00221")
public class T00221 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "szObjeto", length = 10)
    private String szObString;

    @Column(name = "mnNextNumber")
    private Integer mnNextNumber;
}
