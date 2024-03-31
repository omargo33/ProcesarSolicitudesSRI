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
public class T03b11  implements Serializable {

   private T03b11Id id;
   private Date fechaFactura;
   private Date fechaVencimiento;
   private Integer nroDireccion;
   private Integer fiscalYear;
   private Integer periodo;
   private Integer siglo;
   private Integer accountId;
   private String cuentaContable;
   private String moneda;
   private Double importeCobrado;
   private Double importePagado;
   private Double importePendiente;
   private String estado;
   private Date fechaTrans;
   private Date horaTrans;
   private String usuarioTrans;
   private String estacionTrans;
   private String referencia;
   private String referenciaLegal;
   private String comprobanteControladoYn;
   private Date fechaAnulacion;
   private String razonAnulacion;
   private Integer nroDocRelacionado;
   private String tipoDocRelacionado;
   private String companiaDocRelacionado;
   private Integer nroLineaRelacionado;
   private String nroLegalRelacionado;
   private String nroAutorizacion;
   private String explicacionAdicional;
   private Date fechaSustentoRelacionado;
   private String tipoOperacionRelacionado;

}