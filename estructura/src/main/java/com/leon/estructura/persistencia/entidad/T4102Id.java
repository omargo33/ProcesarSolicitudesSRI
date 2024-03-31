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
public class T4102Id   implements Serializable {


     private int mnCodigoCorto;
     private String szUnidadNegocio;

 
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T4102Id) ) return false;
		 T4102Id castOther = ( T4102Id ) other; 
         
		 return (this.getMnCodigoCorto()==castOther.getMnCodigoCorto())
 && ( (this.getSzUnidadNegocio()==castOther.getSzUnidadNegocio()) || ( this.getSzUnidadNegocio()!=null && castOther.getSzUnidadNegocio()!=null && this.getSzUnidadNegocio().equals(castOther.getSzUnidadNegocio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnCodigoCorto();
         result = 37 * result + ( getSzUnidadNegocio() == null ? 0 : this.getSzUnidadNegocio().hashCode() );
         return result;
   }   


}


