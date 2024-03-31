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
public class T079803Id   implements Serializable {


     private String szCodEmpresa;
     private String szCodOficina;
     private String szCodCaja;
     private String szUnidadNegocio;

    
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T079803Id) ) return false;
		 T079803Id castOther = ( T079803Id ) other; 
         
		 return ( (this.getSzCodEmpresa()==castOther.getSzCodEmpresa()) || ( this.getSzCodEmpresa()!=null && castOther.getSzCodEmpresa()!=null && this.getSzCodEmpresa().equals(castOther.getSzCodEmpresa()) ) )
 && ( (this.getSzCodOficina()==castOther.getSzCodOficina()) || ( this.getSzCodOficina()!=null && castOther.getSzCodOficina()!=null && this.getSzCodOficina().equals(castOther.getSzCodOficina()) ) )
 && ( (this.getSzCodCaja()==castOther.getSzCodCaja()) || ( this.getSzCodCaja()!=null && castOther.getSzCodCaja()!=null && this.getSzCodCaja().equals(castOther.getSzCodCaja()) ) )
 && ( (this.getSzUnidadNegocio()==castOther.getSzUnidadNegocio()) || ( this.getSzUnidadNegocio()!=null && castOther.getSzUnidadNegocio()!=null && this.getSzUnidadNegocio().equals(castOther.getSzUnidadNegocio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSzCodEmpresa() == null ? 0 : this.getSzCodEmpresa().hashCode() );
         result = 37 * result + ( getSzCodOficina() == null ? 0 : this.getSzCodOficina().hashCode() );
         result = 37 * result + ( getSzCodCaja() == null ? 0 : this.getSzCodCaja().hashCode() );
         result = 37 * result + ( getSzUnidadNegocio() == null ? 0 : this.getSzUnidadNegocio().hashCode() );
         return result;
   }   


}


