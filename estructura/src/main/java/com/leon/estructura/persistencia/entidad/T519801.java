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
public class T519801   implements Serializable {


     private int id;
     private String idNumeroMsg;
     private String asunto;
     private Integer nroLinea;
     private String remitente;
     private String fechaEnvio;
     private Date tiempoEnvio;
     private String tamano;
     private Date fechaLectura;
     private Date tiempoLectura;
     private String estado;
     private String fileText;
     private String referenciaProceso;
     private String tipoComprobante;
     private String claveAcceso;
     private String autorizacionElectronica;
     private String nroLegalComprobante;
     private String identificacionFiscalCliente;
     private String cliente;
     private String identificacionFiscalProveedor;
     private String proveedor;
     private String clavePublica;
     private Date fechaEmision;
}