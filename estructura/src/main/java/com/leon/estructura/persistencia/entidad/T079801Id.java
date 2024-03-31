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
public class T079801Id   implements Serializable {


     private String szCodEmpresa;
     private Date jdFechaVigencia;
     private Date jdFechaCaducidad;

  


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T079801Id) ) return false;
		 T079801Id castOther = ( T079801Id ) other; 
         
		 return ( (this.getSzCodEmpresa()==castOther.getSzCodEmpresa()) || ( this.getSzCodEmpresa()!=null && castOther.getSzCodEmpresa()!=null && this.getSzCodEmpresa().equals(castOther.getSzCodEmpresa()) ) )
 && ( (this.getJdFechaVigencia()==castOther.getJdFechaVigencia()) || ( this.getJdFechaVigencia()!=null && castOther.getJdFechaVigencia()!=null && this.getJdFechaVigencia().equals(castOther.getJdFechaVigencia()) ) )
 && ( (this.getJdFechaCaducidad()==castOther.getJdFechaCaducidad()) || ( this.getJdFechaCaducidad()!=null && castOther.getJdFechaCaducidad()!=null && this.getJdFechaCaducidad().equals(castOther.getJdFechaCaducidad()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzCodEmpresa() == null ? 0 : this.getSzCodEmpresa().hashCode() );
         result = 37 * result + ( getJdFechaVigencia() == null ? 0 : this.getJdFechaVigencia().hashCode() );
         result = 37 * result + ( getJdFechaCaducidad() == null ? 0 : this.getJdFechaCaducidad().hashCode() );
         return result;
   }   


}


