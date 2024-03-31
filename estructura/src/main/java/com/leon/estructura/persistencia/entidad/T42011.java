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
public class T42011   implements Serializable {


     private T42011Id id;
     private Date fechaEmision;
     private Date fechaAsignada;
     private Integer idCodPersonaAsignada;
     private String cliente;
     private Date horaAsignadoTurno;
     private Date tiempoAsignadoTurno;
     private String estado;
     private String usuario;
     private String estacionTrabajo;
     private Date fechaTrans;
     private Date horaTrans;
     private Integer nroDocRela;
     private String tipoDocRela;
     private String companiaRela;
     private Integer prioridad;
     private String observaciones;
     private String correo;
     private String telefono;
     private Integer idCodPersona;
     private String usuarioAnular;
     private String estacionTrabajoAnular;
     private Date fechaTransAnular;
     private Date horaTransAnular;
     private String medioComunicacion;
     private String ubicacion;
     private String detProblema;
     private String detSolucion;
     private String medioSoporte;

  }