package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * JPA para la entidad clientes con la consulta: "SELECT id_cliente, usuario,
 * base_datos, sri_usuario, sri_credencial, estado, usuario_fecha,
 * usuario_programa FROM clientes;"
 * 
 * Y la llave primera es autonumerica id_cliente.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    @Id
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "usuario", length = 128)
    private String usuario;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "base_datos", length = 256)
    private String baseDatos;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "base_datos_user", length = 256)
    private String baseDatosUser;

    @NotNull(message = "{NotNull.message}")
    @Column(name = "base_datos_credencial", length = 256)
    private String baseDatosCredencial;

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