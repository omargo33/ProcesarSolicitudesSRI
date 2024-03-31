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
public class T9801   implements Serializable {


     private String szUser;
     private String szPasw;
     private String szEmail;
     private String szCountFailedPasw;
     private String szLockoutUser;
     private String szReceiveEmail;
     private String szGeneratePasw;
     private String szStatusUser;
     private String szResetCredencia;
     private Integer mnAddressNumber;
     private Date jdDateUpdate;
     private Date jdDateCreate;
     private String bodega;
     private String idMenu;

  

}


