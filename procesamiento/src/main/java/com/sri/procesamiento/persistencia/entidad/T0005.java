package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA para la entidad T005 con la consulta: "SELECT szModulo, szConstante,
 * szCodigoDefinidoUsuario, szDescripcion, szDescripcion02, szUsoEspecial,
 * szHardCode FROM t0005;"
 * 
 * Y la llave primera szModulo, szConstante, szCodigoDefinidoUsuario,
 * szDescripcion
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "T0005")
public class T0005 implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private T0005Pk id;

    @Column(name = "szDescripcion02")
    private String szDescripcion02;

    @Column(name = "szUsoEspecial")
    private String szUsoEspecial;

    @Column(name = "szHardCode")
    private String szHardCode;

}
