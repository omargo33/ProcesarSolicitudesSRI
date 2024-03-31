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
public class T7101   implements Serializable {


     private int nroTrabajo;
     private Integer secuencia;
     private String descripcionTurno;
     private Date horario;
     private String tipoEntrada;
     private Integer nroDireccion;
     private Integer codigoEmpleado;
     private Integer minutosMinLimite;
     private Integer minutosMaxLimite;

 }