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
public class T41013   implements Serializable {


     private T41013Id id;
     private Integer codigoCortoHijo;
     private Double cantidadFormulacion;
     private String unidadMedidaFormulacion;
     private String observacion;
     private Date fechaTrans;
     private Date tiempoTrans;
     private String usuario;
     private String espacioTranbajo;
     private Double cantidad;
     private String unidadMedida;
}