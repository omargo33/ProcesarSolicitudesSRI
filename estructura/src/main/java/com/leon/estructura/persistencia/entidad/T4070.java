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
public class T4070   implements Serializable {


     private int mnNroTransaccion;
     private String szRegla;
     private String szDescripcionRegla;
     private String szTipoMonto;
     private Double mnMonto;
     private Integer mnCodigoCorto;
     private String mnBodega;
     private Date jdFechaTrans;
     private Date mnTiempoTrans;
     private String szUsuario;
     private String szEstacionTrabajo;
     private String szEstado;
     private String szAutomatico;



}


