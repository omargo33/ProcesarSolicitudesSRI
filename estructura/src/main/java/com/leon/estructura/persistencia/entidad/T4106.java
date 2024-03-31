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
public class T4106   implements Serializable {


     private T4106Id id;
     private String szCodigoLargo;
     private String sz2codigoLargo;
     private Double mnPrecioVentaPublico;
     private String szUser;
     private String szWorkStation;
     private Date jdDateTransaction;

   }