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
public class T57001Id   implements Serializable {


     private int mnInvoiceNumber;
     private String szInvoiceType;
     private String szInvoiceCompany;
     private String szReferenceLegal;

   


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T57001Id) ) return false;
		 T57001Id castOther = ( T57001Id ) other; 
         
		 return (this.getMnInvoiceNumber()==castOther.getMnInvoiceNumber())
 && ( (this.getSzInvoiceType()==castOther.getSzInvoiceType()) || ( this.getSzInvoiceType()!=null && castOther.getSzInvoiceType()!=null && this.getSzInvoiceType().equals(castOther.getSzInvoiceType()) ) )
 && ( (this.getSzInvoiceCompany()==castOther.getSzInvoiceCompany()) || ( this.getSzInvoiceCompany()!=null && castOther.getSzInvoiceCompany()!=null && this.getSzInvoiceCompany().equals(castOther.getSzInvoiceCompany()) ) )
 && ( (this.getSzReferenceLegal()==castOther.getSzReferenceLegal()) || ( this.getSzReferenceLegal()!=null && castOther.getSzReferenceLegal()!=null && this.getSzReferenceLegal().equals(castOther.getSzReferenceLegal()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnInvoiceNumber();
         result = 37 * result + ( getSzInvoiceType() == null ? 0 : this.getSzInvoiceType().hashCode() );
         result = 37 * result + ( getSzInvoiceCompany() == null ? 0 : this.getSzInvoiceCompany().hashCode() );
         result = 37 * result + ( getSzReferenceLegal() == null ? 0 : this.getSzReferenceLegal().hashCode() );
         return result;
   }   


}


