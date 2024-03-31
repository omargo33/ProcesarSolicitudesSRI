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
public class T0411z1Id   implements Serializable {


     private int mnNumDocumentoEdi;
     private String szTipoDocumentoEdi;
     private String szCompanyEdi;
     private int mnItemPayEdi;


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T0411z1Id) ) return false;
		 T0411z1Id castOther = ( T0411z1Id ) other; 
         
		 return (this.getMnNumDocumentoEdi()==castOther.getMnNumDocumentoEdi())
 && ( (this.getSzTipoDocumentoEdi()==castOther.getSzTipoDocumentoEdi()) || ( this.getSzTipoDocumentoEdi()!=null && castOther.getSzTipoDocumentoEdi()!=null && this.getSzTipoDocumentoEdi().equals(castOther.getSzTipoDocumentoEdi()) ) )
 && ( (this.getSzCompanyEdi()==castOther.getSzCompanyEdi()) || ( this.getSzCompanyEdi()!=null && castOther.getSzCompanyEdi()!=null && this.getSzCompanyEdi().equals(castOther.getSzCompanyEdi()) ) )
 && (this.getMnItemPayEdi()==castOther.getMnItemPayEdi());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnNumDocumentoEdi();
         result = 37 * result + ( getSzTipoDocumentoEdi() == null ? 0 : this.getSzTipoDocumentoEdi().hashCode() );
         result = 37 * result + ( getSzCompanyEdi() == null ? 0 : this.getSzCompanyEdi().hashCode() );
         result = 37 * result + this.getMnItemPayEdi();
         return result;
   }   


}


