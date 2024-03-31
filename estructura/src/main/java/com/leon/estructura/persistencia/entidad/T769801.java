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
public class T769801   implements Serializable {


     private Integer nroTrabajo;
     private String tipoIdinformante;
     private String idInformante;
     private String razonSocial;
     private String anio;
     private String mes;
     private String numEstabRuc;
     private Double totalVentas;
     private String codigoOperativo;

  }