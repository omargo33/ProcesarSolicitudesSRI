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
public class T710101   implements Serializable {


     private T710101Id id;
     private String estado;
     private String nroAfiliacionIess;
     private String unidadNegocio;
     private String claseAfiliacion;
     private String tipoRelacion;
     private String banco;
     private String tipoCuentaBanco;
     private String notificacion;
     private String cuentaPago;
     private Date fechaIngreso;
     private String codigoRelog;
     private Double sueldo;
     private Double horaBase;
     private String usuarioTrans;
     private Date fechaTrans;
     private Date tiempoTrans;
     private String estacionTrabajo;

}