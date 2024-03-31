package  com.leon.estructura.persistencia.entidad;

import java.math.BigDecimal;
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
public class T0411z1   implements Serializable {


     private T0411z1Id id;
     private String szNroFactura;
     private Date jfechaEmision;
     private Date jfechaAutorizacion;
     private Integer mnNroDireccion;
     private String szIdFiscalContribuyente;
     private String szRazonSocialContribuyente;
     private String szDirMatrizContribuyente;
     private String szDirSucursalContribuyente;
     private Integer mnFiscalYear;
     private Integer mnPeriodo;
     private String szCodPost;
     private BigDecimal mnValorBruto;
     private Double mnSubTotal;
     private Double mnDescuento;
     private Double mnBase0;
     private Double mnBase12;
     private Double mnNoObjetoIva;
     private Double mnImpuesto;
     private Double mnImporteCobrado;
     private Double mnImportePendiente;
     private String szTipoEmision;
     private String szClaveAcceso;
     private String szAutElectronica;
     private String mnNumDocumentoRela;
     private String szTipoDocumentoRela;
     private String szCompanyRela;
     private Date jdateUpdate;
     private Date jdateCancel;
     private String szCodeCancel;
     private String szDescCancel;
     private String szUserCancel;
     private Integer mnCuentaContable;
     private String jfechaAutElectronica;
     private Integer mnBachNumberEdi;
     private String szUserEdi;
     private Date jdateUpdateEdi;
     private Date mnTiempoEdi;
     private String szTipoIdentificadorComp;
     private String szRazonSocialComp;
     private String szIdFiscalComp;
     private String szRise;
     private String szMoneda;
     private String szCategoria01;
     private String szCategoria02;
     private String szCategoria03;
     private String szCategoria04;
     private String szCategoria05;
     private String szPathPdf;
     private String szPathXml;
     private Integer mnCodigoCorto;
     private String szCodigoLargo;
     private String szSegundoCodigoLargo;
     private String szDescripcion01;
     private String szDescripcion02;
     private String szExplicacionFiscal;
     private String szCompensacionLm;
     private String szAreaFiscal;
     private String szCondicionPago;
     private Date jfechaLm;
     private String szObservacion01;
     private String szObservacion02;
     private Date jfechaComprobante;
     private String szEstablecimiento;
     private String szPuntoEmision;
     private Integer mnSecuencial;
     private String nroAutorizacionComprobante;
     private Date jfechaCaducidad;
     private String szDevolucionIva;
     private Double mnCantidad;
     private Double mnPrecio;
     private Double mnCostoCompra;


}


