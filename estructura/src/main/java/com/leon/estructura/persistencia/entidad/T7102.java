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
public class T7102   implements Serializable {


     private T7102Id id;
     private String maquina;
     private Integer idEmpleado;
     private String nombreEmpleado;
     private String departamento;
     private String tipoVerificacion;
     private String dia;
     private String fechaHoraMarcacion;
     private String usuario;
     private String estacionTrabajo;
     private Date fechaTrans;
     private Date tiempoTrans;

 }