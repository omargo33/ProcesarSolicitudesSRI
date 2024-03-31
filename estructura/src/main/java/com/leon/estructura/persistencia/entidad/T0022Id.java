package com.leon.estructura.persistencia.entidad;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * JPA
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Embeddable
public class T0022Id implements Serializable {

      private static final long serialVersionUID = 1L;
      
      @Column(name = "szCompany", length = 5)
      private String szCompany;

      @Column(name = "szTypeDoc", length = 3)
      private String szTypeDoc;

      @Column(name = "mnPeriodoFiscal")
      private Integer mnPeriodoFiscal;

      public boolean equals(Object other) {
            if ((this == other))
                  return true;
            if ((other == null))
                  return false;
            if (!(other instanceof T0022Id))
                  return false;
            T0022Id castOther = (T0022Id) other;

            return ((this.getSzCompany() == castOther.getSzCompany()) || (this.getSzCompany() != null
                        && castOther.getSzCompany() != null && this.getSzCompany().equals(castOther.getSzCompany())))
                        && ((this.getSzTypeDoc() == castOther.getSzTypeDoc())
                                    || (this.getSzTypeDoc() != null && castOther.getSzTypeDoc() != null
                                                && this.getSzTypeDoc().equals(castOther.getSzTypeDoc())))
                        && (this.getMnPeriodoFiscal() == castOther.getMnPeriodoFiscal());
      }

      public int hashCode() {
            int result = 17;

            result = 37 * result + (getSzCompany() == null ? 0 : this.getSzCompany().hashCode());
            result = 37 * result + (getSzTypeDoc() == null ? 0 : this.getSzTypeDoc().hashCode());
            result = 37 * result + this.getMnPeriodoFiscal();
            return result;
      }

}
