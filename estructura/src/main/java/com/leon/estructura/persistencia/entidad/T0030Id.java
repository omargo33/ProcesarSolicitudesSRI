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
public class T0030Id   implements Serializable {


     private String szMandante;
     private String szPaisBanco;
     private String szClaveBanco;

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T0030Id) ) return false;
		 T0030Id castOther = ( T0030Id ) other; 
         
		 return ( (this.getSzMandante()==castOther.getSzMandante()) || ( this.getSzMandante()!=null && castOther.getSzMandante()!=null && this.getSzMandante().equals(castOther.getSzMandante()) ) )
 && ( (this.getSzPaisBanco()==castOther.getSzPaisBanco()) || ( this.getSzPaisBanco()!=null && castOther.getSzPaisBanco()!=null && this.getSzPaisBanco().equals(castOther.getSzPaisBanco()) ) )
 && ( (this.getSzClaveBanco()==castOther.getSzClaveBanco()) || ( this.getSzClaveBanco()!=null && castOther.getSzClaveBanco()!=null && this.getSzClaveBanco().equals(castOther.getSzClaveBanco()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzMandante() == null ? 0 : this.getSzMandante().hashCode() );
         result = 37 * result + ( getSzPaisBanco() == null ? 0 : this.getSzPaisBanco().hashCode() );
         result = 37 * result + ( getSzClaveBanco() == null ? 0 : this.getSzClaveBanco().hashCode() );
         return result;
   }   


}


