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
public class T079805Id   implements Serializable {


     private String szRol;
     private String szTipoEmision;

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T079805Id) ) return false;
		 T079805Id castOther = ( T079805Id ) other; 
         
		 return ( (this.getSzRol()==castOther.getSzRol()) || ( this.getSzRol()!=null && castOther.getSzRol()!=null && this.getSzRol().equals(castOther.getSzRol()) ) )
 && ( (this.getSzTipoEmision()==castOther.getSzTipoEmision()) || ( this.getSzTipoEmision()!=null && castOther.getSzTipoEmision()!=null && this.getSzTipoEmision().equals(castOther.getSzTipoEmision()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzRol() == null ? 0 : this.getSzRol().hashCode() );
         result = 37 * result + ( getSzTipoEmision() == null ? 0 : this.getSzTipoEmision().hashCode() );
         return result;
   }   


}


