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
public class T57011Id implements Serializable {

      @Column(name = "szComputerID", length = 200)
      private String szComputerId;

      @Column(name = "mnJobNumber")
      private Integer mnJobNumber;

      @Column(name = "mnDocumentNumber")
      private Integer mnDocumentNumber;

      @Column(name = "szDocumentType", length = 2)
      private String szDocumentType;

      @Column(name = "szDocumentCompany", length = 5)
      private String szDocumentCompany;

      @Column(name = "mnInvoiceNumber")
      private Integer mnInvoiceNumber;

      @Column(name = "szInvoiceType", length = 2)
      private String szInvoiceType;

      @Column(name = "szInvoiceCompany", length = 5)
      private String szInvoiceCompany;

      @Column(name = "mnLineNumber")
      private Integer mnLineNumber;

      @Column(name = "mnSequenceNumber")
      private Integer mnSequenceNumber;

      @Column(name = "mnSubSequenceNumber")
      private Integer mnSubSequenceNumber;

      @Column(name = "szJobTypeDescription", length = 30)
      private String szJobTypeDescription;

      public boolean equals(Object other) {
            if ((this == other))
                  return true;
            if ((other == null))
                  return false;
            if (!(other instanceof T57011Id))
                  return false;
            T57011Id castOther = (T57011Id) other;

            return ((this.getSzComputerId() == castOther.getSzComputerId())
                        || (this.getSzComputerId() != null && castOther.getSzComputerId() != null
                                    && this.getSzComputerId().equals(castOther.getSzComputerId())))
                        && (this.getMnJobNumber() == castOther.getMnJobNumber())
                        && (this.getMnDocumentNumber() == castOther.getMnDocumentNumber())
                        && ((this.getSzDocumentType() == castOther.getSzDocumentType())
                                    || (this.getSzDocumentType() != null && castOther.getSzDocumentType() != null
                                                && this.getSzDocumentType().equals(castOther.getSzDocumentType())))
                        && ((this.getSzDocumentCompany() == castOther.getSzDocumentCompany())
                                    || (this.getSzDocumentCompany() != null && castOther.getSzDocumentCompany() != null
                                                && this.getSzDocumentCompany()
                                                            .equals(castOther.getSzDocumentCompany())))
                        && (this.getMnInvoiceNumber() == castOther.getMnInvoiceNumber())
                        && ((this.getSzInvoiceType() == castOther.getSzInvoiceType())
                                    || (this.getSzInvoiceType() != null && castOther.getSzInvoiceType() != null
                                                && this.getSzInvoiceType().equals(castOther.getSzInvoiceType())))
                        && ((this.getSzInvoiceCompany() == castOther.getSzInvoiceCompany())
                                    || (this.getSzInvoiceCompany() != null && castOther.getSzInvoiceCompany() != null
                                                && this.getSzInvoiceCompany().equals(castOther.getSzInvoiceCompany())))
                        && (this.getMnLineNumber() == castOther.getMnLineNumber())
                        && (this.getMnSequenceNumber() == castOther.getMnSequenceNumber())
                        && (this.getMnSubSequenceNumber() == castOther.getMnSubSequenceNumber())
                        && ((this.getSzJobTypeDescription() == castOther.getSzJobTypeDescription())
                                    || (this.getSzJobTypeDescription() != null
                                                && castOther.getSzJobTypeDescription() != null
                                                && this.getSzJobTypeDescription()
                                                            .equals(castOther.getSzJobTypeDescription())));
      }

      public int hashCode() {
            int result = 17;

            result = 37 * result + (getSzComputerId() == null ? 0 : this.getSzComputerId().hashCode());
            result = 37 * result + this.getMnJobNumber();
            result = 37 * result + this.getMnDocumentNumber();
            result = 37 * result + (getSzDocumentType() == null ? 0 : this.getSzDocumentType().hashCode());
            result = 37 * result + (getSzDocumentCompany() == null ? 0 : this.getSzDocumentCompany().hashCode());
            result = 37 * result + this.getMnInvoiceNumber();
            result = 37 * result + (getSzInvoiceType() == null ? 0 : this.getSzInvoiceType().hashCode());
            result = 37 * result + (getSzInvoiceCompany() == null ? 0 : this.getSzInvoiceCompany().hashCode());
            result = 37 * result + this.getMnLineNumber();
            result = 37 * result + this.getMnSequenceNumber();
            result = 37 * result + this.getMnSubSequenceNumber();
            result = 37 * result + (getSzJobTypeDescription() == null ? 0 : this.getSzJobTypeDescription().hashCode());
            return result;
      }

}
