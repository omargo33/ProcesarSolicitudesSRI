package com.leon.estructura.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * JPA para manejar los parametros con la sentencia SQL: "SELECT id_parametro, indice, nombre, descripcion, texto_a, texto_b, numero_a, numero_b, estado, usuario, usuario_fecha, usuario_programa FROM procesamiento_sri.parametros;"
 * 
 * Con el indice autoincremental en id_parametro.
 * 
 * @author omargo33
 * @since 2024-03-31
 * 
 */
@Data
@Entity
@Table(name = "parametros")

public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_parametro")
    private int idParametro;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "indice")
    private int indice;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "nombre", length = 128)
    private String nombre;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "descripcion", length = 256)
    private String descripcion;

    @Column(name = "texto_a", length = 1024)
    private String textoA;

    @Column(name = "texto_b", length = 1024)
    private String textoB;

    @Column(name = "numero_a")
    private double numeroA;

    @Column(name = "numero_b")
    private double numeroB;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "estado", length = 8)
    private String estado;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario", length = 128)
    private String usuario;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario_fecha")
    @Temporal(javax.persistence.TemporalType.DATE)   
    private Date usuarioFecha;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario_programa", length = 128)
    private String usuarioPrograma;
}