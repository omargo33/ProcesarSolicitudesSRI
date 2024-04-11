package com.leon.estructura.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

import javax.persistence.Column;

/**
 * JPA
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario", length = 128)
    private String usuario;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "sri_usuario", length = 16)
    private String sriUsuario;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "sri_credencial", length = 256)
    private String sriCredencial;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "estado", length = 8)
    private String estado;

    @Column(name = "usuario_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioFecha;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario_programa", length = 128)
    private String usuarioPrograma;
}