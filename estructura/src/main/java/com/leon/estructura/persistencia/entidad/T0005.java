package com.leon.estructura.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

/**
 * JPA
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Entity
@Table(name = "T0005")
public class T0005 implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private T0005Id id;

    @Column(name = "szDescripcion02")
    private String szDescripcion02;

    @Column(name = "szUsoEspecial")
    private String szUsoEspecial;

    @Column(name = "szHardCode")
    private String szHardCode;

}
