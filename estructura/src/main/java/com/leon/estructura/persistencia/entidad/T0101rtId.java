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
public class T0101rtId   implements Serializable {


     private int mnNroDireccion;
     private String codigoRetencionDefinidoUsuario;

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T0101rtId) ) return false;
		 T0101rtId castOther = ( T0101rtId ) other; 
         
		 return (this.getMnNroDireccion()==castOther.getMnNroDireccion())
 && ( (this.getCodigoRetencionDefinidoUsuario()==castOther.getCodigoRetencionDefinidoUsuario()) || ( this.getCodigoRetencionDefinidoUsuario()!=null && castOther.getCodigoRetencionDefinidoUsuario()!=null && this.getCodigoRetencionDefinidoUsuario().equals(castOther.getCodigoRetencionDefinidoUsuario()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnNroDireccion();
         result = 37 * result + ( getCodigoRetencionDefinidoUsuario() == null ? 0 : this.getCodigoRetencionDefinidoUsuario().hashCode() );
         return result;
   }   


}


