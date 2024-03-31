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
public class T519800   implements Serializable {


     private int id;
     private String servidor;
     private String usuario;
     private String credencial;
     private String protocolo;
     private String puerto;
     private Date fechaTrans;
     private Date tiempoTrans;
     private String clavePublica;
     private String clavePrivada;
     private String estado;
}