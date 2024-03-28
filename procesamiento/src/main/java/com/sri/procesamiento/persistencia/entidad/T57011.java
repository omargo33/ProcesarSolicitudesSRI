package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA para la entidad T0711z1 con la consulta: "SELECT szComputerID,
 * mnJobNumber, szBachType, mnBachNumber, mnDocumentNumber, szDocumentType,
 * szDocumentCompany, mnInvoiceNumber, szInvoiceType, szInvoiceCompany,
 * szReferenceLegal, szReference, mnLineNumber, mnSequenceNumber,
 * mnSubSequenceNumber, szMember, mnLegalNumber, jdDateEfective, jdDateExpired,
 * szOperationType, szJobTypeDescription, szThruCaseStatusCode, mnCodCliente,
 * szNameAlpha, szTaxID, szAddressLine01, szAddressLine02, mnCodCliente_ShipTo,
 * szBodega, szCompany, szName, szTaxIdentificationNumber, szAddressLine1,
 * szAddressLine2, szAddressLine3, szAddressLine4, mnCodItemNumberShort,
 * szPrintDataYN, szDescription, szDescription2, mnItemNumber,
 * szUnitofMeasureasInput, szUnitofMeasurePricing, mnQuantityShipped,
 * mnUnitsQtyBackordered, mnUnitsQuantityCanceledScrapped, mnAmountPriceUnit,
 * mnAmountGross, mnAmountExtendedPrice, mnAmountExtendedCost, mnPercent1,
 * jdDateRequested, szCommitted, szLineType, jdDateInvoice, jdDateNetDue,
 * mnRelatedNumber, szRelatedOrderType, szCompanyRelatedOrder, szPrintMessage,
 * szSalesTaxableYN, szTaxRateArea, szTaxExplCode, szDescriptionTaxArea,
 * mnTaxAuthority, mnTaxAuthority2, mnTaxAuthority3, mnTaxAuthority4,
 * mnTaxAuthority5, mnTaxRate1, mnTaxRate2, mnTaxRate3, mnTaxRate4, mnTaxRate5,
 * szTaxCalculationMethod, mnAmountTaxable, mnAmountTax, szPaymentTermsCode,
 * mnDiscountAvailable, szUserID, szProgramID, szWorkStationID, jdDateUpdated,
 * mnTimeofDay, mnEDIDocumentNumber, szEDIDocumentType, szEDIDocumentKeyCo,
 * mnEDILineNumber, mnOrderSuffix, mnCodClienteParent, mnDiscountAmount,
 * mnAmountSalesTaxTotal1, mnAmountSalesTaxTotal2, mnAmountSalesTaxTotal3,
 * mnAmountSalesTaxTotal4, mnAmountSalesTaxTotal5, mnAmountNonTaxable,
 * mnAmountListPrice, sz2ndItemNumber, mnCarrierNumber,
 * szAgreementSupplementDistribution, szEstablecimiento, mnTripNumber,
 * mnWeightResult, szDutyStatus, szLotSerialNumber, szParameterDataItem01,
 * szParameterDataItem02, szParameterDataItem03, szParameterDataItem04,
 * szParameterDataItem05, szParameterDataItem06, szParameterDataItem07,
 * szParameterDataItem08, szParameterDataItem09, szParameterDataItem10,
 * szLegalDocumentTitle, szClaveAcceso, szClaveAccesoContingencia,
 * szAutorizacionElectronica, szRefAutorizacion1, szRefAutorizacion2,
 * szRefAutorizacion3, szRefAutorizacion4, szAmbiente, szTipoEmision,
 * szContribuyenteEspecial, szObligadoContabilidad, szMoneda, szCatSales01,
 * szCatSales02, szCatSales03, szCatSales04, szCatSales05, szPeriodoFiscal,
 * szRise FROM t57011;"
 * 
 * Y la llave primera esta compuesta por szComputerID, mnJobNumber,
 * mnDocumentNumber, szDocumentType, szDocumentCompany, mnInvoiceNumber,
 * szInvoiceType, szInvoiceCompany, mnLineNumber, mnSequenceNumber,
 * mnSubSequenceNumber y
 * szJobTypeDescription
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "t57011")
public class T57011 implements Serializable {

    @EmbeddedId
    private T57011Pk id;

    @Column(name = "szBachType", length = 2)
    private String szBachType;

    @Column(name = "mnBachNumber")
    private Integer mnBachNumber;

    @Column(name = "szReferenceLegal", length = 20)
    private String szReferenceLegal;

    @Column(name = "szReference", length = 20)
    private String szReference;

    @Column(name = "szNumber", length = 15)
    private String szNumber;

    @Column(name = "mnLegalNumber", length = 10)
    private String mnLegalNumber;

    @Column(name = "jdDateEfective")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateEfective;

    @Column(name = "jdDateExpired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateExpired;

    @Column(name = "szOperationType", length = 100)
    private String szOperationType;


    @Column(name = "szThruCaseStatusCode", length = 3)
    private String szThruCaseStatusCode;

    @Column(name = "mnCodCliente")
    private Integer mnCodCliente;

    @Column(name = "szNameAlpha", length = 150)
    private String szNameAlpha;

    @Column(name = "szTaxID", length = 20)
    private String szTaxID;

    @Column(name = "szAddressLine01", length = 2000)
    private String szAddressLine01;

    @Column(name = "szAddressLine02", length = 2000)
    private String szAddressLine02;

    @Column(name = "mnCodCliente_ShipTo")
    private Integer mnCodCliente_ShipTo;

    @Column(name = "szBodega", length = 12)
    private String szBodega;

    @Column(name = "szCompany", length = 5)
    private String szCompany;

    @Column(name = "szName", length = 160)
    private String szName;

    @Column(name = "szTaxIdentificationNumber", length = 20)
    private String szTaxIdentificationNumber;

    @Column(name = "szAddressLine1", length = 2000)
    private String szAddressLine1;

    @Column(name = "szAddressLine2", length = 2000)
    private String szAddressLine2;

    @Column(name = "szAddressLine3", length = 2000)
    private String szAddressLine3;

    @Column(name = "szAddressLine4", length = 2000)
    private String szAddressLine4;

    @Column(name = "mnCodItemNumberShort")
    private Integer mnCodItemNumberShort;

    @Column(name = "szPrintDataYN", length = 2)
    private String szPrintDataYN;

    @Column(name = "szDescription", length = 250)
    private String szDescription;

    @Column(name = "szDescription2", length = 250)
    private String szDescription2;

    @Column(name = "mnItemNumber", length = 25)
    private String mnItemNumber;

    @Column(name = "szUnitofMeasureasInput", length = 3)
    private String szUnitofMeasureasInput;

    @Column(name = "szUnitofMeasurePricing", length = 3)
    private String szUnitofMeasurePricing;

    @Column(name = "mnQuantityShipped")
    private Double mnQuantityShipped;

    @Column(name = "mnUnitsQtyBackordered")
    private Double mnUnitsQtyBackordered;

    @Column(name = "mnUnitsQuantityCanceledScrapped")
    private Double mnUnitsQuantityCanceledScrapped;

    @Column(name = "mnAmountPriceUnit")
    private Double mnAmountPriceUnit;

    @Column(name = "mnAmountGross")
    private Double mnAmountGross;

    @Column(name = "mnAmountExtendedPrice")
    private Double mnAmountExtendedPrice;

    @Column(name = "mnAmountExtendedCost")
    private Double mnAmountExtendedCost;

    @Column(name = "mnPercent1")
    private Double mnPercent1;

    @Column(name = "jdDateRequested")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateRequested;

    @Column(name = "szCommitted", length = 2)
    private String szCommitted;

    @Column(name = "szLineType", length = 5)
    private String szLineType;

    @Column(name = "jdDateInvoice")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateInvoice;

    @Column(name = "jdDateNetDue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateNetDue;

    @Column(name = "mnRelatedNumber")
    private Integer mnRelatedNumber;

    @Column(name = "szRelatedOrderType", length = 2)
    private String szRelatedOrderType;

    @Column(name = "szCompanyRelatedOrder", length = 5)
    private String szCompanyRelatedOrder;

    @Column(name = "szPrintMessage", length = 30)
    private String szPrintMessage;

    @Column(name = "szSalesTaxableYN", length = 2)
    private String szSalesTaxableYN;

    @Column(name = "szTaxRateArea", length = 50)
    private String szTaxRateArea;

    @Column(name = "szTaxExplCode", length = 50)
    private String szTaxExplCode;

    @Column(name = "szDescriptionTaxArea", length = 50)
    private String szDescriptionTaxArea;

    @Column(name = "mnTaxAuthority")
    private Double mnTaxAuthority;

    @Column(name = "mnTaxAuthority2")
    private Double mnTaxAuthority2;

    @Column(name = "mnTaxAuthority3")
    private Double mnTaxAuthority3;

    @Column(name = "mnTaxAuthority4")
    private Double mnTaxAuthority4;

    @Column(name = "mnTaxAuthority5")
    private Double mnTaxAuthority5;

    @Column(name = "mnTaxRate1")
    private Double mnTaxRate1;

    @Column(name = "mnTaxRate2")
    private Double mnTaxRate2;

    @Column(name = "mnTaxRate3")
    private Double mnTaxRate3;

    @Column(name = "mnTaxRate4")
    private Double mnTaxRate4;

    @Column(name = "mnTaxRate5")
    private Double mnTaxRate5;

    @Column(name = "szTaxCalculationMethod", length = 20)
    private String szTaxCalculationMethod;

    @Column(name = "mnAmountTaxable")
    private Double mnAmountTaxable;

    @Column(name = "mnAmountTax")
    private Double mnAmountTax;

    @Column(name = "szPaymentTermsCode", length = 20)
    private String szPaymentTermsCode;

    @Column(name = "mnDiscountAvailable")
    private Double mnDiscountAvailable;

    @Column(name = "szUserID", length = 15)
    private String szUserID;

    @Column(name = "szProgramID", length = 300)
    private String szProgramID;

    @Column(name = "szWorkStationID", length = 300)
    private String szWorkStationID;

    @Column(name = "jdDateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jdDateUpdated;

    @Column(name = "mnTimeofDay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mnTimeofDay;

    @Column(name = "mnEDIDocumentNumber")
    private Integer mnEDIDocumentNumber;

    @Column(name = "szEDIDocumentType", length = 2)
    private String szEDIDocumentType;

    @Column(name = "szEDIDocumentKeyCo", length = 5)
    private String szEDIDocumentKeyCo;

    @Column(name = "mnEDILineNumber")
    private Integer mnEDILineNumber;

    @Column(name = "mnOrderSuffix")
    private Integer mnOrderSuffix;

    @Column(name = "mnCodClienteParent")
    private Integer mnCodClienteParent;

    @Column(name = "mnDiscountAmount")
    private Double mnDiscountAmount;

    @Column(name = "mnAmountSalesTaxTotal1")
    private Double mnAmountSalesTaxTotal1;

    @Column(name = "mnAmountSalesTaxTotal2")
    private Double mnAmountSalesTaxTotal2;

    @Column(name = "mnAmountSalesTaxTotal3")
    private Double mnAmountSalesTaxTotal3;

    @Column(name = "mnAmountSalesTaxTotal4")
    private Double mnAmountSalesTaxTotal4;

    @Column(name = "mnAmountSalesTaxTotal5")
    private Double mnAmountSalesTaxTotal5;

    @Column(name = "mnAmountNonTaxable")
    private Double mnAmountNonTaxable;

    @Column(name = "mnAmountListPrice")
    private Double mnAmountListPrice;

    @Column(name = "sz2ndItemNumber", length = 25)
    private String sz2ndItemNumber;

    @Column(name = "mnCarrierNumber")
    private Integer mnCarrierNumber;

    @Column(name = "szAgreementSupplementDistribution", length = 30)
    private String szAgreementSupplementDistribution;

    @Column(name = "szEstablecimiento", length = 12)
    private String szEstablecimiento;

    @Column(name = "mnTripNumber")
    private Integer mnTripNumber;

    @Column(name = "mnWeightResult")
    private Double mnWeightResult;

    @Column(name = "szDutyStatus", length = 15)
    private String szDutyStatus;

    @Column(name = "szLotSerialNumber", length = 30)
    private String szLotSerialNumber;

    @Column(name = "szParameterDataItem01", length = 2000)
    private String szParameterDataItem01;

    @Column(name = "szParameterDataItem02", length = 2000)
    private String szParameterDataItem02;

    @Column(name = "szParameterDataItem03", length = 2000)
    private String szParameterDataItem03;

    @Column(name = "szParameterDataItem04", length = 2000)
    private String szParameterDataItem04;

    @Column(name = "szParameterDataItem05", length = 2000)
    private String szParameterDataItem05;

    @Column(name = "szParameterDataItem06", length = 2000)
    private String szParameterDataItem06;

    @Column(name = "szParameterDataItem07", length = 2000)
    private String szParameterDataItem07;

    @Column(name = "szParameterDataItem08", length = 2000)
    private String szParameterDataItem08;

    @Column(name = "szParameterDataItem09", length = 2000)
    private String szParameterDataItem09;

    @Column(name = "szParameterDataItem10", length = 2000)
    private String szParameterDataItem10;

    @Column(name = "szLegalDocumentTitle", length = 100)
    private String szLegalDocumentTitle;

    @Column(name = "szClaveAcceso", length = 100)
    private String szClaveAcceso;

    @Column(name = "szClaveAccesoContingencia", length = 100)
    private String szClaveAccesoContingencia;

    @Column(name = "szAutorizacionElectronica", length = 100)
    private String szAutorizacionElectronica;

    @Column(name = "szRefAutorizacion1", length = 100)
    private String szRefAutorizacion1;

    @Column(name = "szRefAutorizacion2", length = 100)
    private String szRefAutorizacion2;

    @Column(name = "szRefAutorizacion3", length = 100)
    private String szRefAutorizacion3;

    @Column(name = "szRefAutorizacion4", length = 100)
    private String szRefAutorizacion4;

    @Column(name = "szAmbiente", length = 10)
    private String szAmbiente;

    @Column(name = "szTipoEmision", length = 10)
    private String szTipoEmision;

    @Column(name = "szContribuyenteEspecial", length = 15)
    private String szContribuyenteEspecial;

    @Column(name = "szObligadoContabilidad", length = 3)
    private String szObligadoContabilidad;

    @Column(name = "szMoneda", length = 15)
    private String szMoneda;

    @Column(name = "szCatSales01", length = 150)
    private String szCatSales01;

    @Column(name = "szCatSales02", length = 150)
    private String szCatSales02;

    @Column(name = "szCatSales03", length = 150)
    private String szCatSales03;

    @Column(name = "szCatSales04", length = 150)
    private String szCatSales04;

    @Column(name = "szCatSales05", length = 150)
    private String szCatSales05;

    @Column(name = "szPeriodoFiscal", length = 5)
    private String szPeriodoFiscal;

    @Column(name = "szRise", length = 20)
    private String szRise;
}
