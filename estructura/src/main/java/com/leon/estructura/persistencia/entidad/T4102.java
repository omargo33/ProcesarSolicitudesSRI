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
public class T4102   implements Serializable {


     private T4102Id id;
     private String szCodigoLargo;
     private String sz2codigoLargo;
     private String szDescripcion;
     private String szDescripcion02;
     private String szTextoBusqueda;
     private String szCatInv01;
     private String szCatInv02;
     private String szCatInv03;
     private String szCatInv04;
     private String szCatInv05;
     private String szCatInv06;
     private String szCatInv07;
     private String szCatInv08;
     private String szUnidadMedida;
     private String sz2unidadMedida;
     private String sz3unidadMedida;
     private String szUnidadPeso;
     private String szUnidadVolumen;
     private String szCodigoGlpt;
     private String szTipoStock;
     private String szUser;
     private String szWorkStation;
     private Date jdDateTransaction;
     private Date mnTime;
     private String szImpuestos;
}