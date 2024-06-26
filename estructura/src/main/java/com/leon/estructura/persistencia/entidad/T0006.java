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
@Table(name = "t0006")
public class T0006   implements Serializable {


     private String szUnidadNegocio;
     private String szDescripcion;
     private String szTipo;
     private String szEmpresa;
     private String szDireccion;

}