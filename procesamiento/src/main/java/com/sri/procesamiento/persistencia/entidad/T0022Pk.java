package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA de PrimaryKey para la entidad T0022.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Embeddable
public class T0022Pk implements Serializable {

    @Column(name = "szCompany", length = 5)
    private String szCompany;

    @Column(name = "szTypeDoc", length = 3)
    private String szTypeDoc;

    @Column(name = "mnPeriodoFiscal")
    private Integer mnPeriodoFiscal;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        T0022Pk that = (T0022Pk) o;

        if (szCompany != null ? !szCompany.equals(that.szCompany) : that.szCompany != null)
            return false;
        if (szTypeDoc != null ? !szTypeDoc.equals(that.szTypeDoc) : that.szTypeDoc != null)
            return false;
        return mnPeriodoFiscal != null ? mnPeriodoFiscal.equals(that.mnPeriodoFiscal) : that.mnPeriodoFiscal == null;
    }

    @Override
    public int hashCode() {
        int result = szCompany != null ? szCompany.hashCode() : 0;
        result = 31 * result + (szTypeDoc != null ? szTypeDoc.hashCode() : 0);
        result = 31 * result + (mnPeriodoFiscal != null ? mnPeriodoFiscal.hashCode() : 0);
        return result;
    }
}
