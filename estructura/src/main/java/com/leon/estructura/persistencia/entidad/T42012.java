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
public class T42012   implements Serializable {


     private int nroTrabajo;
     private Date fechaTransaccion;
     private Date horaAsignada;
     private Date tiempoAsignado;
     private String descripcion;
     private Date fechaVigencia;
     private Date fechaCaducidad;
     private Integer nroDireccion;
     private String reglaDia;
     private String usuarioAct;
     private Date fechaAct;
     private Date horaAct;
     private String workStationAct;
     private String estadoRegla;

  
}