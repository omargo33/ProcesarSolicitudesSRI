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
public class T710101Id   implements Serializable {


     private int nroDireccion;
     private int nroLinea;

   
     

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T710101Id) ) return false;
		 T710101Id castOther = ( T710101Id ) other; 
         
		 return (this.getNroDireccion()==castOther.getNroDireccion())
 && (this.getNroLinea()==castOther.getNroLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroDireccion();
         result = 37 * result + this.getNroLinea();
         return result;
   }   


}


