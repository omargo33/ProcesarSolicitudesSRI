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
public class T41019   implements Serializable {


     private T41019Id id;
     private Integer codigoCortoPadre;
     private Double cantidadProduccion;
     private String unidadMedidaProduccion;
     private Date fechaProduccion;
     private Date fechaEmision;
     private Integer nroLinea;
     private Integer codigoCortoHijo;
     private Double cantidadFormulacion;
     private String unidadMedidaFormulacion;
     private String observacion;
     private Date fechaTrans;
     private Date tiempoTrans;
     private String usuario;
     private String espacioTranbajo;
     private String estado;
     private Double cantidadConversion;
     private String unidadMedidaConversion;

  }