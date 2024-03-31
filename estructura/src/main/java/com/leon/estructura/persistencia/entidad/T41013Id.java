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
public class T41013Id   implements Serializable {


     private int codigoCortoPadre;
     private int nroLinea;

   

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T41013Id) ) return false;
		 T41013Id castOther = ( T41013Id ) other; 
         
		 return (this.getCodigoCortoPadre()==castOther.getCodigoCortoPadre())
 && (this.getNroLinea()==castOther.getNroLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodigoCortoPadre();
         result = 37 * result + this.getNroLinea();
         return result;
   }   


}


