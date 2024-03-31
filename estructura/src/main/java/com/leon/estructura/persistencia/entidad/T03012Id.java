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
public class T03012Id   implements Serializable {


     private int nroDireccion;
     private String compania;

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T03012Id) ) return false;
		 T03012Id castOther = ( T03012Id ) other; 
         
		 return (this.getNroDireccion()==castOther.getNroDireccion())
 && ( (this.getCompania()==castOther.getCompania()) || ( this.getCompania()!=null && castOther.getCompania()!=null && this.getCompania().equals(castOther.getCompania()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroDireccion();
         result = 37 * result + ( getCompania() == null ? 0 : this.getCompania().hashCode() );
         return result;
   }   


}


