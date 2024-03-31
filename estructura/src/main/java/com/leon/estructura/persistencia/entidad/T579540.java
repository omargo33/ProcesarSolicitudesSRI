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
public class T579540   implements Serializable {


     private T579540Id id;
     private String szDescripcion;
     private String szWsdl;
     private String szCredencial;
     private String szPws;
     private Integer itimeOut;
     private String szSoapaction;
     private String szRequestMethod;

}