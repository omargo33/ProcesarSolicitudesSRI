package  com.leon.estructura.persistencia.entidad;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * JPA
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Entity
@Embeddable
public class T0711z1Id implements Serializable {

      private static final long serialVersionUID = 1L;

      @Column(name = "szTransaccionID")
      private Integer szTransaccionId;

      @Column(name = "iComputerID", length = 45)
      private String iComputerId;

      @Column(name = "szDocEmpresa", length = 45)
      private String szDocEmpresa;

      @Column(name = "szDocType", length = 45)
      private String szDocType;

      @Column(name = "mnDocDocument")
      private Integer mnDocDocument;

      @Column(name = "mnSequence")
      private Integer mnSequence;

      @Column(name = "mnSubSequence")
      private Integer mnSubSequence;

      @Column(name = "szTypeOperation", length = 3)
      private String szTypeOperation;

      public boolean equals(Object other) {
            if ((this == other))
                  return true;
            if ((other == null))
                  return false;
            if (!(other instanceof T0711z1Id))
                  return false;
            T0711z1Id castOther = (T0711z1Id) other;

            return (this.getSzTransaccionId() == castOther.getSzTransaccionId())
                        && ((this.getIComputerId() == castOther.getIComputerId())
                                    || (this.getIComputerId() != null && castOther.getIComputerId() != null
                                                && this.getIComputerId().equals(castOther.getIComputerId())))
                        && ((this.getSzDocEmpresa() == castOther.getSzDocEmpresa())
                                    || (this.getSzDocEmpresa() != null && castOther.getSzDocEmpresa() != null
                                                && this.getSzDocEmpresa().equals(castOther.getSzDocEmpresa())))
                        && ((this.getSzDocType() == castOther.getSzDocType())
                                    || (this.getSzDocType() != null && castOther.getSzDocType() != null
                                                && this.getSzDocType().equals(castOther.getSzDocType())))
                        && (this.getMnDocDocument() == castOther.getMnDocDocument())
                        && (this.getMnSequence() == castOther.getMnSequence())
                        && (this.getMnSubSequence() == castOther.getMnSubSequence())
                        && ((this.getSzTypeOperation() == castOther.getSzTypeOperation())
                                    || (this.getSzTypeOperation() != null && castOther.getSzTypeOperation() != null
                                                && this.getSzTypeOperation().equals(castOther.getSzTypeOperation())));
      }

      public int hashCode() {
            int result = 17;

            result = 37 * result + this.getSzTransaccionId();
            result = 37 * result + (getIComputerId() == null ? 0 : this.getIComputerId().hashCode());
            result = 37 * result + (getSzDocEmpresa() == null ? 0 : this.getSzDocEmpresa().hashCode());
            result = 37 * result + (getSzDocType() == null ? 0 : this.getSzDocType().hashCode());
            result = 37 * result + this.getMnDocDocument();
            result = 37 * result + this.getMnSequence();
            result = 37 * result + this.getMnSubSequence();
            result = 37 * result + (getSzTypeOperation() == null ? 0 : this.getSzTypeOperation().hashCode());
            return result;
      }

}
