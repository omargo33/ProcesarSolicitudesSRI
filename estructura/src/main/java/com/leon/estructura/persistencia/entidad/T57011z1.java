package  com.leon.estructura.persistencia.entidad;

import java.math.BigDecimal;
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
public class T57011z1   implements Serializable {


     private T57011z1Id id;
     private String szBachType;
     private int mnBachNumber;
     private String szReferenceLegal;
     private String szReference;
     private String szMember;
     private String mnLegalNumber;
     private Date jdDateEfective;
     private Date jdDateExpired;
     private String szOperationType;
     private String szThruCaseStatusCode;
     private Integer mnCodCliente;
     private String szNameAlpha;
     private String szTaxId;
     private String szAddressLine01;
     private String szAddressLine02;
     private Integer mnCodClienteShipTo;
     private String szBodega;
     private String szCompany;
     private String szName;
     private String szTaxIdentificationNumber;
     private String szAddressLine1;
     private String szAddressLine2;
     private String szAddressLine3;
     private String szAddressLine4;
     private Integer mnCodItemNumberShort;
     private String szPrintDataYn;
     private String szDescription;
     private String szDescription2;
     private String mnItemNumber;
     private String szUnitofMeasureasInput;
     private String szUnitofMeasurePricing;
     private BigDecimal mnQuantityShipped;
     private BigDecimal mnUnitsQtyBackordered;
     private BigDecimal mnUnitsQuantityCanceledScrapped;
     private BigDecimal mnAmountPriceUnit;
     private BigDecimal mnAmountGross;
     private BigDecimal mnAmountExtendedPrice;
     private BigDecimal mnAmountExtendedCost;
     private BigDecimal mnPercent1;
     private Date jdDateRequested;
     private String szCommitted;
     private String szLineType;
     private Date jdDateInvoice;
     private Date jdDateNetDue;
     private Integer mnRelatedNumber;
     private String szRelatedOrderType;
     private String szCompanyRelatedOrder;
     private String szPrintMessage;
     private String szSalesTaxableYn;
     private String szTaxRateArea;
     private String szTaxExplCode;
     private String szDescriptionTaxArea;
     private BigDecimal mnTaxAuthority;
     private BigDecimal mnTaxAuthority2;
     private BigDecimal mnTaxAuthority3;
     private BigDecimal mnTaxAuthority4;
     private BigDecimal mnTaxAuthority5;
     private BigDecimal mnTaxRate1;
     private BigDecimal mnTaxRate2;
     private BigDecimal mnTaxRate3;
     private BigDecimal mnTaxRate4;
     private BigDecimal mnTaxRate5;
     private String szTaxCalculationMethod;
     private BigDecimal mnAmountTaxable;
     private BigDecimal mnAmountTax;
     private String szPaymentTermsCode;
     private BigDecimal mnDiscountAvailable;
     private String szUserId;
     private String szProgramId;
     private String szWorkStationId;
     private Date jdDateUpdated;
     private Date mnTimeofDay;
     private Integer mnEdidocumentNumber;
     private String szEdidocumentType;
     private String szEdidocumentKeyCo;
     private Integer mnEdilineNumber;
     private Integer mnOrderSuffix;
     private Integer mnCodClienteParent;
     private BigDecimal mnDiscountAmount;
     private BigDecimal mnAmountSalesTaxTotal1;
     private BigDecimal mnAmountSalesTaxTotal2;
     private BigDecimal mnAmountSalesTaxTotal3;
     private BigDecimal mnAmountSalesTaxTotal4;
     private BigDecimal mnAmountSalesTaxTotal5;
     private BigDecimal mnAmountNonTaxable;
     private BigDecimal mnAmountListPrice;
     private String sz2ndItemNumber;
     private Integer mnCarrierNumber;
     private String szAgreementSupplementDistribution;
     private String szEstablecimiento;
     private Integer mnTripNumber;
     private BigDecimal mnWeightResult;
     private String szDutyStatus;
     private String szLotSerialNumber;
     private String szParameterDataItem01;
     private String szParameterDataItem02;
     private String szParameterDataItem03;
     private String szParameterDataItem04;
     private String szParameterDataItem05;
     private String szParameterDataItem06;
     private String szParameterDataItem07;
     private String szParameterDataItem08;
     private String szParameterDataItem09;
     private String szParameterDataItem10;
     private String szLegalDocumentTitle;
     private String szClaveAcceso;
     private String szClaveAccesoContingencia;
     private String szAutorizacionElectronica;
     private String szRefAutorizacion1;
     private String szRefAutorizacion2;
     private String szRefAutorizacion3;
     private String szRefAutorizacion4;
     private String szAmbiente;
     private String szTipoEmision;
     private String szContribuyenteEspecial;
     private String szObligadoContabilidad;
     private String szMoneda;
     private String szCatSales01;
     private String szCatSales02;
     private String szCatSales03;
     private String szCatSales04;
     private String szCatSales05;
     private String szPeriodoFiscal;
     private String szRise;

  }