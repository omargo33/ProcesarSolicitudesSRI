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
public class T57001d   implements Serializable {


     private int mnNroTrabajo;
     private String szTipoPlantilla;
     private Integer mnInvoiceNumber;
     private String szInvoiceType;
     private String szInvoiceCompany;
     private String szReferenceLegal;
     private String szIdFiscalCliente;
     private String szClaveAcceso;
     private String szNroAutorizacion;
     private String szFechaAutorizacion;
     private String szAmbiente;
     private Date jdFechaTrans;
     private String szCorreo;
     private String szCc;
     private String szContexto01;
     private String szContexto02;
     private String szContexto03;
     private String szContexto04;
     private String szContexto05;
     private String szContexto06;
     private String szContexto07;
     private String szContexto08;
     private String szContexto09;
     private String szContexto10;
     private String szPathReferencia1;
     private String szPathReferencia2;
     private String szPathReferencia3;
     private String szMsgError;
     private String szProceso;
     private Integer mnCountError;
}