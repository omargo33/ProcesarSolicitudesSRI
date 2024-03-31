package  com.leon.estructura.persistencia.entidad;


import java.util.Date;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

/**
 * JPA 
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Entity 
@Table(name = "xx")
public class T7111   implements Serializable {


     private Integer idComprobante;
     private String razonComercialEmpresa;
     private String razonSocialEmpresa;
     private String direccionEmpresa;
     private String rucEmpresa;
     private String calificacionArtesanal;
     private String telefono;
     private String correo;
     private String periodo;
     private String ciEmpleado;
     private String nombreEmpleado;
     private String cargoEmpleado;
     private String departamentoEmpleado;
     private Double sueldo;
     private Integer diasTrabajado;
     private Double sueldoGanado;
     private Double horasExtras50;
     private Double horasExtras100;
     private Double incentivoProduccion;
     private Double fondosReserva;
     private Double sueldoMensualizado13;
     private Double sueldoMensualizado14;
     private Double alimentacion;
     private Double aportePersonalIess;
     private Double impuestoRenta;
     private Double subsidioIess;
     private Double multas;
     private Double anticipos;
     private Double prestamosIess;
     private String estado;
     private Date fechaEmision;
     private Date tiempoEmision;
     private String usuario;

   }