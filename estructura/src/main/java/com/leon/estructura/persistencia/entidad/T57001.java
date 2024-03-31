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
public class T57001   implements Serializable {


     private T57001Id id;
     private Integer mnDocumentNumber;
     private String szDocumentType;
     private String szDocumentCompany;
     private String szReference;
     private Integer mnCodigoCliente;
     private String szNombreXml;
     private String szIdpathXmlbase;
     private String szIdpathXmlfirmado;
     private String szIdpathXmlrespuesta;
     private String szIdpathPdf;
     private String szNroAutorizacion;
     private String szFechaAutorizacion;
     private String szClaveAcceso;
     private Integer mnBachNumber;
     private String szBachType;
     private Date jdDateInvoice;
     private String szAmbiente;
     private String szEstadoAutorizacion;
     private String mnIdentificador;
     private String szProceso;
     private String szMensajeError;
     private String szInformacionAdicional;
     private String szEtiqueta;
     private String szEnvioYn;
     private String szAutorizadoYn;
     private String szUsuarioTrans;
     private Date jdFechaTrans;

 }