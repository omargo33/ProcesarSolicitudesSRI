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
public class T03b13   implements Serializable {


     private T03b13Id id;
     private String instrumentoPago;
     private Double montoPago;
     private Integer accountId;
     private String cuentaContable;
     private String explicacionPago;
     private Integer nroDireccion;
     private Date fechaEmision;
     private Integer nroDoc;
     private String tipoDoc;
     private String companiaDoc;
     private Integer nroDocInv;
     private String tipoDocInv;
     private String companiaDocInv;
     private Integer nroLinea;
     private String referenciaPago;
     private String usuarioOriginado;
     private String usuarioTrans;
     private Date fechaTrans;
     private String estacionTrans;
     private Date fechaAnulacion;
     private String razonAnulacion;
     private String estadoAnulacion;
}