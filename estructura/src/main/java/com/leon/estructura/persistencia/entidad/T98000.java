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
public class T98000   implements Serializable {


     private String szIdentificionFiscal;
     private String szRazonSocial;
     private String szTipoContribuyente;
     private String szNumeroResolucion;
     private Date szFechaResolucion;
     private String szDireccion;
     private String szPathImagen;
     private int szAddressNumber;
     private String szCompany;
     private String szAmbiente;
     private String szEmision;
     private String szObligadoContabilidad;
     private String leyendaMicroEmpresario;
     private String leyendaAgenteRetencion;

   }