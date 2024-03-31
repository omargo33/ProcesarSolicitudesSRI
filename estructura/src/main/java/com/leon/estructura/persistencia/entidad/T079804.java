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
public class T079804   implements Serializable {


     private T079804Id id;
     private Integer iseqInicial;
     private Integer iseqFinal;
     private String szCierreCaja;
     private Integer idocNumber;
     private String szTypeDoc;
     private String szCompanyDoc;
}