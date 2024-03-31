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
public class T5701Id   implements Serializable {


     private String szIdentificadorFiscal;
     private Date jdFechaRegistro;
     private Date jdFechaCaducidad;

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T5701Id) ) return false;
		 T5701Id castOther = ( T5701Id ) other; 
         
		 return ( (this.getSzIdentificadorFiscal()==castOther.getSzIdentificadorFiscal()) || ( this.getSzIdentificadorFiscal()!=null && castOther.getSzIdentificadorFiscal()!=null && this.getSzIdentificadorFiscal().equals(castOther.getSzIdentificadorFiscal()) ) )
 && ( (this.getJdFechaRegistro()==castOther.getJdFechaRegistro()) || ( this.getJdFechaRegistro()!=null && castOther.getJdFechaRegistro()!=null && this.getJdFechaRegistro().equals(castOther.getJdFechaRegistro()) ) )
 && ( (this.getJdFechaCaducidad()==castOther.getJdFechaCaducidad()) || ( this.getJdFechaCaducidad()!=null && castOther.getJdFechaCaducidad()!=null && this.getJdFechaCaducidad().equals(castOther.getJdFechaCaducidad()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzIdentificadorFiscal() == null ? 0 : this.getSzIdentificadorFiscal().hashCode() );
         result = 37 * result + ( getJdFechaRegistro() == null ? 0 : this.getJdFechaRegistro().hashCode() );
         result = 37 * result + ( getJdFechaCaducidad() == null ? 0 : this.getJdFechaCaducidad().hashCode() );
         return result;
   }   


}


