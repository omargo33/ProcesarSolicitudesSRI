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
public class T41021Id   implements Serializable {


     private int mnCodigoCorto;
     private String szUnidadNegocio;
     private String szUbicacion;
     private String szLote;
     private String szCategoriaGl;

    


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T41021Id) ) return false;
		 T41021Id castOther = ( T41021Id ) other; 
         
		 return (this.getMnCodigoCorto()==castOther.getMnCodigoCorto())
 && ( (this.getSzUnidadNegocio()==castOther.getSzUnidadNegocio()) || ( this.getSzUnidadNegocio()!=null && castOther.getSzUnidadNegocio()!=null && this.getSzUnidadNegocio().equals(castOther.getSzUnidadNegocio()) ) )
 && ( (this.getSzUbicacion()==castOther.getSzUbicacion()) || ( this.getSzUbicacion()!=null && castOther.getSzUbicacion()!=null && this.getSzUbicacion().equals(castOther.getSzUbicacion()) ) )
 && ( (this.getSzLote()==castOther.getSzLote()) || ( this.getSzLote()!=null && castOther.getSzLote()!=null && this.getSzLote().equals(castOther.getSzLote()) ) )
 && ( (this.getSzCategoriaGl()==castOther.getSzCategoriaGl()) || ( this.getSzCategoriaGl()!=null && castOther.getSzCategoriaGl()!=null && this.getSzCategoriaGl().equals(castOther.getSzCategoriaGl()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnCodigoCorto();
         result = 37 * result + ( getSzUnidadNegocio() == null ? 0 : this.getSzUnidadNegocio().hashCode() );
         result = 37 * result + ( getSzUbicacion() == null ? 0 : this.getSzUbicacion().hashCode() );
         result = 37 * result + ( getSzLote() == null ? 0 : this.getSzLote().hashCode() );
         result = 37 * result + ( getSzCategoriaGl() == null ? 0 : this.getSzCategoriaGl().hashCode() );
         return result;
   }   


}


