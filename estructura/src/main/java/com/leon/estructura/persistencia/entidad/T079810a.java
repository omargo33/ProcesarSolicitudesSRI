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
public class T079810a   implements Serializable {


     private String szCodEmpresa;
     private String cuentaUsuario;
     private String credencialUsuario;
     private String from;
     private String host;
     private String puerto;
     private String cuentaCorreo;

 }