package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA de PrimaryKey para la entidad T57011.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Embeddable
public class T57011Pk implements Serializable {

    @Column(name = "szComputerID", length = 200)
    private String szComputerID;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        T57011Pk that = (T57011Pk) obj;
        if (szComputerID != that.szComputerID) {
            return false;
        }
        if (mnJobNumber != that.mnJobNumber) {
            return false;
        }
        if (mnDocumentNumber != that.mnDocumentNumber) {
            return false;
        }
        if (szDocumentType != null ? !szDocumentType.equals(that.szDocumentType) : that.szDocumentType != null) {
            return false;
        }
        if (szDocumentCompany != null ? !szDocumentCompany.equals(that.szDocumentCompany)
                : that.szDocumentCompany != null) {
            return false;
        }
        if (mnInvoiceNumber != that.mnInvoiceNumber) {
            return false;
        }
        if (szInvoiceType != null ? !szInvoiceType.equals(that.szInvoiceType) : that.szInvoiceType != null) {
            return false;
        }
        if (szInvoiceCompany != null ? !szInvoiceCompany.equals(that.szInvoiceCompany)
                : that.szInvoiceCompany != null) {
            return false;
        }
        if (mnLineNumber != that.mnLineNumber) {
            return false;
        }
        if (mnSequenceNumber != that.mnSequenceNumber) {
            return false;
        }
        if (mnSubSequenceNumber != that.mnSubSequenceNumber) {
            return false;
        }
        return szJobTypeDescription != null ? szJobTypeDescription.equals(that.szJobTypeDescription)
                : that.szJobTypeDescription == null;
    }

    @Override
    public int hashCode() {
        int result = szComputerID != null ? szComputerID.hashCode() : 0;
        result = 31 * result + (mnJobNumber != null ? mnJobNumber.hashCode() : 0);
        result = 31 * result + (mnDocumentNumber != null ? mnDocumentNumber.hashCode() : 0);
        result = 31 * result + (szDocumentType != null ? szDocumentType.hashCode() : 0);
        result = 31 * result + (szDocumentCompany != null ? szDocumentCompany.hashCode() : 0);
        result = 31 * result + (mnInvoiceNumber != null ? mnInvoiceNumber.hashCode() : 0);
        result = 31 * result + (szInvoiceType != null ? szInvoiceType.hashCode() : 0);
        result = 31 * result + (szInvoiceCompany != null ? szInvoiceCompany.hashCode() : 0);
        result = 31 * result + (mnLineNumber != null ? mnLineNumber.hashCode() : 0);
        result = 31 * result + (mnSequenceNumber != null ? mnSequenceNumber.hashCode() : 0);
        result = 31 * result + (mnSubSequenceNumber != null ? mnSubSequenceNumber.hashCode() : 0);
        result = 31 * result + (szJobTypeDescription != null ? szJobTypeDescription.hashCode() : 0);
        return result;
    }
}