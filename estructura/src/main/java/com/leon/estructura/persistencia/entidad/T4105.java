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
public class T4105   implements Serializable {


     private int mnNroTransaccion;
     private Integer mnCodigoCorto;
     private String szTipoCosto;
     private Double mnCosto;
     private String szBodega;
     private String szEstado;
     private String szLote;
     private Date jdFechaTrans;
     private Date mnTiempoTrans;
     private String szUsuario;
     private String szPrograma;
     private String szEstacionTrabajo;

}