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
public class T7102Id   implements Serializable {


     private int nroTrabajo;
     private String empresaDocumento;
     private int nroDocumento;
     private String tipoDocumento;
     private int nroLinea;

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T7102Id) ) return false;
		 T7102Id castOther = ( T7102Id ) other; 
         
		 return (this.getNroTrabajo()==castOther.getNroTrabajo())
 && ( (this.getEmpresaDocumento()==castOther.getEmpresaDocumento()) || ( this.getEmpresaDocumento()!=null && castOther.getEmpresaDocumento()!=null && this.getEmpresaDocumento().equals(castOther.getEmpresaDocumento()) ) )
 && (this.getNroDocumento()==castOther.getNroDocumento())
 && ( (this.getTipoDocumento()==castOther.getTipoDocumento()) || ( this.getTipoDocumento()!=null && castOther.getTipoDocumento()!=null && this.getTipoDocumento().equals(castOther.getTipoDocumento()) ) )
 && (this.getNroLinea()==castOther.getNroLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroTrabajo();
         result = 37 * result + ( getEmpresaDocumento() == null ? 0 : this.getEmpresaDocumento().hashCode() );
         result = 37 * result + this.getNroDocumento();
         result = 37 * result + ( getTipoDocumento() == null ? 0 : this.getTipoDocumento().hashCode() );
         result = 37 * result + this.getNroLinea();
         return result;
   }   


}


