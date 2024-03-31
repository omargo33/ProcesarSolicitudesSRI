package  com.leon.estructura.persistencia.entidad;

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
public class T769800   implements Serializable {


     private String empresa;
     private String rucInformante;
     private String razonSocial;
     private String rucRepresentanteLegal;
     private String rucContador;
     private Integer periodoFiscal;
     private Integer periodo;
     private String direccion;
     private String telefono;
     private String fax;
     private String correo;
     private String tipoRepresentanteLegal;

 }