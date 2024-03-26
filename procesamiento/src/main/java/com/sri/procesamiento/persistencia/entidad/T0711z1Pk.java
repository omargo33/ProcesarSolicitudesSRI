package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA de PrimaryKey para la entidad T0711z1.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Embeddable
public class T0711z1Pk implements Serializable {

    @Column(name = "szTransaccionID")
    private Integer szTransaccionID;

    @Column(name = "iComputerID", length = 45)
    private String iComputerID;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        T0711z1Pk that = (T0711z1Pk) o;

        if (szTransaccionID != that.szTransaccionID)
            return false;
        if (iComputerID != that.iComputerID)
            return false;
        if (szDocEmpresa != null ? !szDocEmpresa.equals(that.szDocEmpresa) : that.szDocEmpresa != null)
            return false;
        if (szDocType != null ? !szDocType.equals(that.szDocType) : that.szDocType != null)
            return false;
        if (mnDocDocument != that.mnDocDocument)
            return false;
        if (mnSequence != that.mnSequence)
            return false;
        if (mnSubSequence != that.mnSubSequence)
            return false;
        return szTypeOperation != null ? szTypeOperation.equals(that.szTypeOperation) : that.szTypeOperation == null;
    }

    @Override
    public int hashCode() {
        int result = szTransaccionID != null ? szTransaccionID.hashCode() : 0;
        result = 31 * result + (iComputerID != null ? iComputerID.hashCode() : 0);
        result = 31 * result + (szDocEmpresa != null ? szDocEmpresa.hashCode() : 0);
        result = 31 * result + (szDocType != null ? szDocType.hashCode() : 0);
        result = 31 * result + (mnDocDocument != null ? mnDocDocument.hashCode() : 0);
        result = 31 * result + (mnSequence != null ? mnSequence.hashCode() : 0);
        result = 31 * result + (mnSubSequence != null ? mnSubSequence.hashCode() : 0);
        result = 31 * result + (szTypeOperation != null ? szTypeOperation.hashCode() : 0);
        return result;
    }
        


}

