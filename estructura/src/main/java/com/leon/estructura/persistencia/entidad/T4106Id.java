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
public class T4106Id   implements Serializable {


     private int mnCodigoCorto;
     private String szUnidadNegocio;
     private Date jdFechaInicialVigencia;
     private Date jdFechaCaducidadVigencia;
     private String szEstado;
     private Date mnTime;




   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T4106Id) ) return false;
		 T4106Id castOther = ( T4106Id ) other; 
         
		 return (this.getMnCodigoCorto()==castOther.getMnCodigoCorto())
 && ( (this.getSzUnidadNegocio()==castOther.getSzUnidadNegocio()) || ( this.getSzUnidadNegocio()!=null && castOther.getSzUnidadNegocio()!=null && this.getSzUnidadNegocio().equals(castOther.getSzUnidadNegocio()) ) )
 && ( (this.getJdFechaInicialVigencia()==castOther.getJdFechaInicialVigencia()) || ( this.getJdFechaInicialVigencia()!=null && castOther.getJdFechaInicialVigencia()!=null && this.getJdFechaInicialVigencia().equals(castOther.getJdFechaInicialVigencia()) ) )
 && ( (this.getJdFechaCaducidadVigencia()==castOther.getJdFechaCaducidadVigencia()) || ( this.getJdFechaCaducidadVigencia()!=null && castOther.getJdFechaCaducidadVigencia()!=null && this.getJdFechaCaducidadVigencia().equals(castOther.getJdFechaCaducidadVigencia()) ) )
 && ( (this.getSzEstado()==castOther.getSzEstado()) || ( this.getSzEstado()!=null && castOther.getSzEstado()!=null && this.getSzEstado().equals(castOther.getSzEstado()) ) )
 && ( (this.getMnTime()==castOther.getMnTime()) || ( this.getMnTime()!=null && castOther.getMnTime()!=null && this.getMnTime().equals(castOther.getMnTime()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMnCodigoCorto();
         result = 37 * result + ( getSzUnidadNegocio() == null ? 0 : this.getSzUnidadNegocio().hashCode() );
         result = 37 * result + ( getJdFechaInicialVigencia() == null ? 0 : this.getJdFechaInicialVigencia().hashCode() );
         result = 37 * result + ( getJdFechaCaducidadVigencia() == null ? 0 : this.getJdFechaCaducidadVigencia().hashCode() );
         result = 37 * result + ( getSzEstado() == null ? 0 : this.getSzEstado().hashCode() );
         result = 37 * result + ( getMnTime() == null ? 0 : this.getMnTime().hashCode() );
         return result;
   }   


}


