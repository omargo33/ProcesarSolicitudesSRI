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
public class T579540Id   implements Serializable {


     private String szNameSoftKey;
     private String szAmbiente;
     private String szUsuarioRol;

   

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T579540Id) ) return false;
		 T579540Id castOther = ( T579540Id ) other; 
         
		 return ( (this.getSzNameSoftKey()==castOther.getSzNameSoftKey()) || ( this.getSzNameSoftKey()!=null && castOther.getSzNameSoftKey()!=null && this.getSzNameSoftKey().equals(castOther.getSzNameSoftKey()) ) )
 && ( (this.getSzAmbiente()==castOther.getSzAmbiente()) || ( this.getSzAmbiente()!=null && castOther.getSzAmbiente()!=null && this.getSzAmbiente().equals(castOther.getSzAmbiente()) ) )
 && ( (this.getSzUsuarioRol()==castOther.getSzUsuarioRol()) || ( this.getSzUsuarioRol()!=null && castOther.getSzUsuarioRol()!=null && this.getSzUsuarioRol().equals(castOther.getSzUsuarioRol()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzNameSoftKey() == null ? 0 : this.getSzNameSoftKey().hashCode() );
         result = 37 * result + ( getSzAmbiente() == null ? 0 : this.getSzAmbiente().hashCode() );
         result = 37 * result + ( getSzUsuarioRol() == null ? 0 : this.getSzUsuarioRol().hashCode() );
         return result;
   }   


}


