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
public class T4111   implements Serializable {


     private int mnNroTransaccion;
     private String szCompanyOrden;
     private String szTipoDocOrden;
     private Integer mnNumDocOrden;
     private Integer mnNroLinea;
     private Integer mnCodigoCorto;
     private String szCodigoLargo;
     private String sz2codigoLargo;
     private String szBodega;
     private String szUbicacion;
     private String szLote;
     private String szUnidadMedPri;
     private String szUnidadMedSeg;
     private String szSucursal;
     private String szCompanyInvoice;
     private String szTipoDocInvoice;
     private Integer mnNumDocInvoice;
     private Date jdFechaLm;
     private String szCategoriaLm;
     private Integer mnAddressNumber;
     private String szExplificacionFiscal;
     private Double mnCantidadTrans;
     private Double mnCostoUnitario;
     private Double mnPrecioUnitario;
     private Double mnPrecioTotal;
     private Date jdFechaTrans;
     private Date mnTiempoTrans;
     private String szUsuario;
     private String szEstacionTrabajo;
     private Integer mnIdcuenta;
     private Double cantidadTransSeg;
     private String unidadMedidaTer;
     private Double cantidadTransTercantidadTransTer;
     private String unidadMedidaConv;
     private Double cantidadTransConv;

}