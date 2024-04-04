package com.d3v.proceso;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class EditLineSalesZ1 {
  DsF57011Z1 dsf57011Z1 = new DsF57011Z1();
  
  List<DsF57011Z1> listdsf57011Z1;
  
  private String esquema;
  
  
  public EditLineSalesZ1() {
    setDsf57011Z1(new DsF57011Z1());
    setListdsf57011Z1(new ArrayList<>());
    setEsquema("");
  }
  
  public void editLine(String typeMode) {
    if (typeMode.equalsIgnoreCase("1"))
      fechAllSales(); 
    if (typeMode.equalsIgnoreCase("2"))
      saveSales(); 
  }
  
  public void fechAllSales() {
    String query = "";
    try {
      query = "SELECT * FROM " + this.esquema + ".t57011 WHERE szInvoiceCompany =  '" + this.dsf57011Z1.getSzInvoiceCompany() + "'  AND szJobTypeDescription =  '" + this.dsf57011Z1.getSzJobTypeDescription() + "'  AND szReferenceLegal = '" + this.dsf57011Z1.getSzReferenceLegal() + "'  AND szOperationType = '" + this.dsf57011Z1.getSzOperationType() + "'  AND mnLegalNumber = '" + this.dsf57011Z1.getMnLegalNumber() + "'  ";
      ResultSet data = this.BD.sqlResultSet(query);
      while (data.next()) {
        DsF57011Z1 comprobante = new DsF57011Z1();
        comprobante.setSzComputerID(data.getString("szComputerID"));
        comprobante.setMnJobNumber(data.getString("mnJobNumber"));
        comprobante.setSzBachType(data.getString("szBachType"));
        comprobante.setMnBachNumber(data.getString("mnBachNumber"));
        comprobante.setMnDocumentNumber(data.getString("mnDocumentNumber"));
        comprobante.setSzDocumentType(data.getString("szDocumentType"));
        comprobante.setSzDocumentCompany(data.getString("szDocumentCompany"));
        comprobante.setMnInvoiceNumber(data.getString("mnInvoiceNumber"));
        comprobante.setSzInvoiceType(data.getString("szInvoiceType"));
        comprobante.setSzInvoiceCompany(data.getString("szInvoiceCompany"));
        comprobante.setSzReferenceLegal(data.getString("szReferenceLegal"));
        comprobante.setSzReference(data.getString("szReference"));
        comprobante.setMnLineNumber(data.getString("mnLineNumber"));
        comprobante.setMnSequenceNumber(data.getString("mnSequenceNumber"));
        comprobante.setMnSubSequenceNumber(data.getString("mnSubSequenceNumber"));
        comprobante.setSzMember(data.getString("szMember"));
        comprobante.setMnLegalNumber(data.getString("mnLegalNumber"));
        comprobante.setJdDateEfective(data.getString("jdDateEfective"));
        comprobante.setJdDateExpired(data.getString("jdDateExpired"));
        comprobante.setSzOperationType(data.getString("szOperationType"));
        comprobante.setSzJobTypeDescription(data.getString("szJobTypeDescription"));
        comprobante.setSzThruCaseStatusCode(data.getString("szThruCaseStatusCode"));
        comprobante.setMnCodCliente(data.getString("mnCodCliente"));
        comprobante.setSzNameAlpha(data.getString("szNameAlpha"));
        comprobante.setSzTaxID(data.getString("szTaxID"));
        comprobante.setSzAddressLine01(data.getString("szAddressLine01"));
        comprobante.setSzAddressLine02(data.getString("szAddressLine02"));
        comprobante.setMnCodCliente_ShipTo(data.getString("mnCodCliente_ShipTo"));
        comprobante.setSzBodega(data.getString("szBodega"));
        comprobante.setSzCompany(data.getString("szCompany"));
        comprobante.setSzName(data.getString("szName"));
        comprobante.setSzTaxIdentificationNumber(data.getString("szTaxIdentificationNumber"));
        comprobante.setSzAddressLine1(data.getString("szAddressLine1"));
        comprobante.setSzAddressLine2(data.getString("szAddressLine2"));
        comprobante.setSzAddressLine3(data.getString("szAddressLine3"));
        comprobante.setSzAddressLine4(data.getString("szAddressLine4"));
        comprobante.setMnCodItemNumberShort(data.getString("mnCodItemNumberShort"));
        comprobante.setSzPrintDataYN(data.getString("szPrintDataYN"));
        comprobante.setSzDescription(data.getString("szDescription"));
        comprobante.setSzDescription2(data.getString("szDescription2"));
        comprobante.setMnItemNumber(data.getString("mnItemNumber"));
        comprobante.setSzUnitofMeasureasInput(data.getString("szUnitofMeasureasInput"));
        comprobante.setSzUnitofMeasurePricing(data.getString("szUnitofMeasurePricing"));
        comprobante.setMnQuantityShipped(data.getString("mnQuantityShipped"));
        comprobante.setMnUnitsQtyBackordered(data.getString("mnUnitsQtyBackordered"));
        comprobante.setMnUnitsQuantityCanceledScrapped(data.getString("mnUnitsQuantityCanceledScrapped"));
        comprobante.setMnAmountPriceUnit(data.getString("mnAmountPriceUnit"));
        comprobante.setMnAmountGross(data.getString("mnAmountGross"));
        comprobante.setMnAmountExtendedPrice(data.getString("mnAmountExtendedPrice"));
        comprobante.setMnAmountExtendedCost(data.getString("mnAmountExtendedCost"));
        comprobante.setMnPercent1(data.getString("mnPercent1"));
        comprobante.setJdDateRequested(data.getString("jdDateRequested"));
        comprobante.setSzCommitted(data.getString("szCommitted"));
        comprobante.setSzLineType(data.getString("szLineType"));
        comprobante.setJdDateInvoice(data.getString("jdDateInvoice"));
        comprobante.setJdDateNetDue(data.getString("jdDateNetDue"));
        comprobante.setMnRelatedNumber(data.getString("mnRelatedNumber"));
        comprobante.setSzRelatedOrderType(data.getString("szRelatedOrderType"));
        comprobante.setSzCompanyRelatedOrder(data.getString("szCompanyRelatedOrder"));
        comprobante.setSzPrintMessage(data.getString("szPrintMessage"));
        comprobante.setSzSalesTaxableYN(data.getString("szSalesTaxableYN"));
        comprobante.setSzTaxRateArea(data.getString("szTaxRateArea"));
        comprobante.setSzTaxExplCode(data.getString("szTaxExplCode"));
        comprobante.setSzDescriptionTaxArea(data.getString("szDescriptionTaxArea"));
        comprobante.setMnTaxAuthority(data.getString("mnTaxAuthority"));
        comprobante.setMnTaxAuthority2(data.getString("mnTaxAuthority2"));
        comprobante.setMnTaxAuthority3(data.getString("mnTaxAuthority3"));
        comprobante.setMnTaxAuthority4(data.getString("mnTaxAuthority4"));
        comprobante.setMnTaxAuthority5(data.getString("mnTaxAuthority5"));
        comprobante.setMnTaxRate1(data.getString("mnTaxRate1"));
        comprobante.setMnTaxRate2(data.getString("mnTaxRate2"));
        comprobante.setMnTaxRate3(data.getString("mnTaxRate3"));
        comprobante.setMnTaxRate4(data.getString("mnTaxRate4"));
        comprobante.setMnTaxRate5(data.getString("mnTaxRate5"));
        comprobante.setSzTaxCalculationMethod(data.getString("szTaxCalculationMethod"));
        comprobante.setMnAmountTaxable(data.getString("mnAmountTaxable"));
        comprobante.setMnAmountTax(data.getString("mnAmountTax"));
        comprobante.setSzPaymentTermsCode(data.getString("szPaymentTermsCode"));
        comprobante.setMnDiscountAvailable(data.getString("mnDiscountAvailable"));
        comprobante.setSzUserID(data.getString("szUserID"));
        comprobante.setSzProgramID(data.getString("szProgramID"));
        comprobante.setSzWorkStationID(data.getString("szWorkStationID"));
        comprobante.setJdDateUpdated(data.getString("jdDateUpdated"));
        comprobante.setMnTimeofDay(data.getString("mnTimeofDay"));
        comprobante.setMnEDIDocumentNumber(data.getString("mnEDIDocumentNumber"));
        comprobante.setSzEDIDocumentType(data.getString("szEDIDocumentType"));
        comprobante.setSzEDIDocumentKeyCo(data.getString("szEDIDocumentKeyCo"));
        comprobante.setMnEDILineNumber(data.getString("mnEDILineNumber"));
        comprobante.setMnOrderSuffix(data.getString("mnOrderSuffix"));
        comprobante.setMnCodClienteParent(data.getString("mnCodClienteParent"));
        comprobante.setMnDiscountAmount(data.getString("mnDiscountAmount"));
        comprobante.setMnAmountSalesTaxTotal1(data.getString("mnAmountSalesTaxTotal1"));
        comprobante.setMnAmountSalesTaxTotal2(data.getString("mnAmountSalesTaxTotal2"));
        comprobante.setMnAmountSalesTaxTotal3(data.getString("mnAmountSalesTaxTotal3"));
        comprobante.setMnAmountSalesTaxTotal4(data.getString("mnAmountSalesTaxTotal4"));
        comprobante.setMnAmountSalesTaxTotal5(data.getString("mnAmountSalesTaxTotal5"));
        comprobante.setMnAmountNonTaxable(data.getString("mnAmountNonTaxable"));
        comprobante.setMnAmountListPrice(data.getString("mnAmountListPrice"));
        comprobante.setSz2ndItemNumber(data.getString("sz2ndItemNumber"));
        comprobante.setMnCarrierNumber(data.getString("mnCarrierNumber"));
        comprobante.setSzAgreementSupplementDistribution(data.getString("szAgreementSupplementDistribution"));
        comprobante.setSzEstablecimiento(data.getString("szEstablecimiento"));
        comprobante.setMnTripNumber(data.getString("mnTripNumber"));
        comprobante.setMnWeightResult(data.getString("mnWeightResult"));
        comprobante.setSzDutyStatus(data.getString("szDutyStatus"));
        comprobante.setSzLotSerialNumber(data.getString("szLotSerialNumber"));
        comprobante.setSzParameterDataItem01(data.getString("szParameterDataItem01"));
        comprobante.setSzParameterDataItem02(data.getString("szParameterDataItem02"));
        comprobante.setSzParameterDataItem03(data.getString("szParameterDataItem03"));
        comprobante.setSzParameterDataItem04(data.getString("szParameterDataItem04"));
        comprobante.setSzParameterDataItem05(data.getString("szParameterDataItem05"));
        comprobante.setSzParameterDataItem06(data.getString("szParameterDataItem06"));
        comprobante.setSzParameterDataItem07(data.getString("szParameterDataItem07"));
        comprobante.setSzParameterDataItem08(data.getString("szParameterDataItem08"));
        comprobante.setSzParameterDataItem09(data.getString("szParameterDataItem09"));
        comprobante.setSzParameterDataItem10(data.getString("szParameterDataItem10"));
        comprobante.setSzLegalDocumentTitle(data.getString("szLegalDocumentTitle"));
        comprobante.setSzClaveAcceso(data.getString("szClaveAcceso"));
        comprobante.setSzClaveAccesoContingencia(data.getString("szClaveAccesoContingencia"));
        comprobante.setSzAutorizacionElectronica(data.getString("szAutorizacionElectronica"));
        comprobante.setSzRefAutorizacion1(data.getString("szRefAutorizacion1"));
        comprobante.setSzRefAutorizacion2(data.getString("szRefAutorizacion2"));
        comprobante.setSzRefAutorizacion3(data.getString("szRefAutorizacion3"));
        comprobante.setSzRefAutorizacion4(data.getString("szRefAutorizacion4"));
        comprobante.setSzAmbiente(data.getString("szAmbiente"));
        comprobante.setSzTipoEmision(data.getString("szTipoEmision"));
        comprobante.setSzContribuyenteEspecial(data.getString("szContribuyenteEspecial"));
        comprobante.setSzObligadoContabilidad(data.getString("szObligadoContabilidad"));
        comprobante.setSzMoneda(data.getString("szMoneda"));
        comprobante.setSzCatSales01(data.getString("szCatSales01"));
        comprobante.setSzCatSales02(data.getString("szCatSales02"));
        comprobante.setSzCatSales03(data.getString("szCatSales03"));
        comprobante.setSzCatSales04(data.getString("szCatSales04"));
        comprobante.setSzCatSales05(data.getString("szCatSales05"));
        comprobante.setSzPeriodoFiscal(data.getString("szPeriodoFiscal"));
        comprobante.setSzRise(data.getString("szRise"));
        this.listdsf57011Z1.add(comprobante);
        setDsf57011Z1(comprobante);
      } 
    } catch (Exception e) {
      log.error("Problemas al consultar la transaccion: {} {}", query, e);
    } 
  }
  
  public void saveSales() {
    String query = "";
    try {
      query = "INSERT INTO " + this.esquema + ".t57011 (szComputerID, mnJobNumber, szBachType, mnBachNumber, mnDocumentNumber, szDocumentType, szDocumentCompany, mnInvoiceNumber, szInvoiceType, szInvoiceCompany, szReferenceLegal, szReference, mnLineNumber, mnSequenceNumber, mnSubSequenceNumber, szMember, mnLegalNumber, jdDateEfective, jdDateExpired, szOperationType, szJobTypeDescription, szThruCaseStatusCode, mnCodCliente, szNameAlpha, szTaxID, szAddressLine01, szAddressLine02, mnCodCliente_ShipTo, szBodega, szCompany, szName, szTaxIdentificationNumber, szAddressLine1, szAddressLine2, szAddressLine3, szAddressLine4, mnCodItemNumberShort, szPrintDataYN, szDescription, szDescription2, mnItemNumber, szUnitofMeasureasInput, szUnitofMeasurePricing, mnQuantityShipped, mnUnitsQtyBackordered, mnUnitsQuantityCanceledScrapped, mnAmountPriceUnit, mnAmountGross, mnAmountExtendedPrice, mnAmountExtendedCost, mnPercent1, jdDateRequested, szCommitted, szLineType, jdDateInvoice, jdDateNetDue, mnRelatedNumber, szRelatedOrderType, szCompanyRelatedOrder, szPrintMessage, szSalesTaxableYN, szTaxRateArea, szTaxExplCode, szDescriptionTaxArea, mnTaxAuthority, mnTaxAuthority2, mnTaxAuthority3, mnTaxAuthority4, mnTaxAuthority5, mnTaxRate1, mnTaxRate2, mnTaxRate3, mnTaxRate4, mnTaxRate5, szTaxCalculationMethod, mnAmountTaxable, mnAmountTax, szPaymentTermsCode, mnDiscountAvailable, szUserID, szProgramID, szWorkStationID, jdDateUpdated, mnTimeofDay, mnEDIDocumentNumber, szEDIDocumentType, szEDIDocumentKeyCo, mnEDILineNumber, mnOrderSuffix, mnCodClienteParent, mnDiscountAmount, mnAmountSalesTaxTotal1, mnAmountSalesTaxTotal2, mnAmountSalesTaxTotal3, mnAmountSalesTaxTotal4, mnAmountSalesTaxTotal5, mnAmountNonTaxable, mnAmountListPrice, sz2ndItemNumber, mnCarrierNumber, szAgreementSupplementDistribution, szEstablecimiento, mnTripNumber, mnWeightResult, szDutyStatus, szLotSerialNumber, szParameterDataItem01, szParameterDataItem02, szParameterDataItem03, szParameterDataItem04, szParameterDataItem05, szParameterDataItem06, szParameterDataItem07, szParameterDataItem08, szParameterDataItem09, szParameterDataItem10, szLegalDocumentTitle, szClaveAcceso, szClaveAccesoContingencia, szAutorizacionElectronica, szRefAutorizacion1, szRefAutorizacion2, szRefAutorizacion3, szRefAutorizacion4, szAmbiente, szTipoEmision, szContribuyenteEspecial, szObligadoContabilidad, szMoneda, szCatSales01, szCatSales02, szCatSales03, szCatSales04, szCatSales05, szPeriodoFiscal, szRise)VALUES('" + this.dsf57011Z1.getSzComputerID() + "', '" + this.dsf57011Z1.getMnJobNumber() + "', '" + this.dsf57011Z1.getSzBachType() + "', '" + this.dsf57011Z1.getMnBachNumber() + "', '" + this.dsf57011Z1.getMnDocumentNumber() + "', '" + this.dsf57011Z1.getSzDocumentType() + "', '" + this.dsf57011Z1.getSzDocumentCompany() + "', '" + this.dsf57011Z1.getMnInvoiceNumber() + "', '" + this.dsf57011Z1.getSzInvoiceType() + "', '" + this.dsf57011Z1.getSzInvoiceCompany() + "', '" + this.dsf57011Z1.getSzReferenceLegal() + "', '" + this.dsf57011Z1.getSzReference() + "', '" + this.dsf57011Z1.getMnLineNumber() + "', '" + this.dsf57011Z1.getMnSequenceNumber() + "', '" + this.dsf57011Z1.getMnSubSequenceNumber() + "', '" + this.dsf57011Z1.getSzMember() + "', '" + this.dsf57011Z1.getMnLegalNumber() + "', '" + this.dsf57011Z1.getJdDateEfective() + "', '" + this.dsf57011Z1.getJdDateExpired() + "', '" + this.dsf57011Z1.getSzOperationType() + "', '" + this.dsf57011Z1.getSzJobTypeDescription() + "', '" + this.dsf57011Z1.getSzThruCaseStatusCode() + "', '" + this.dsf57011Z1.getMnCodCliente() + "', '" + this.dsf57011Z1.getSzNameAlpha() + "', '" + this.dsf57011Z1.getSzTaxID() + "', '" + this.dsf57011Z1.getSzAddressLine01() + "', '" + this.dsf57011Z1.getSzAddressLine02() + "', '" + this.dsf57011Z1.getMnCodCliente_ShipTo() + "', '" + this.dsf57011Z1.getSzBodega() + "', '" + this.dsf57011Z1.getSzCompany() + "', '" + this.dsf57011Z1.getSzName() + "', '" + this.dsf57011Z1.getSzTaxIdentificationNumber() + "', '" + this.dsf57011Z1.getSzAddressLine1() + "', '" + this.dsf57011Z1.getSzAddressLine2() + "', '" + this.dsf57011Z1.getSzAddressLine3() + "', '" + this.dsf57011Z1.getSzAddressLine4() + "', '" + this.dsf57011Z1.getMnCodItemNumberShort() + "', '" + this.dsf57011Z1.getSzPrintDataYN() + "', '" + this.dsf57011Z1.getSzDescription() + "', '" + this.dsf57011Z1.getSzDescription2() + "', '" + this.dsf57011Z1.getMnItemNumber() + "', '" + this.dsf57011Z1.getSzUnitofMeasureasInput() + "', '" + this.dsf57011Z1.getSzUnitofMeasurePricing() + "', '" + this.dsf57011Z1.getMnQuantityShipped() + "', '" + this.dsf57011Z1.getMnUnitsQtyBackordered() + "', '" + this.dsf57011Z1.getMnUnitsQuantityCanceledScrapped() + "', '" + this.dsf57011Z1.getMnAmountPriceUnit() + "', '" + this.dsf57011Z1.getMnAmountGross() + "', '" + this.dsf57011Z1.getMnAmountExtendedPrice() + "', '" + this.dsf57011Z1.getMnAmountExtendedCost() + "', '" + this.dsf57011Z1.getMnPercent1() + "', '" + this.dsf57011Z1.getJdDateRequested() + "', '" + this.dsf57011Z1.getSzCommitted() + "', '" + this.dsf57011Z1.getSzLineType() + "', '" + this.dsf57011Z1.getJdDateInvoice() + "', '" + this.dsf57011Z1.getJdDateNetDue() + "', '" + this.dsf57011Z1.getMnRelatedNumber() + "', '" + this.dsf57011Z1.getSzRelatedOrderType() + "', '" + this.dsf57011Z1.getSzCompanyRelatedOrder() + "', '" + this.dsf57011Z1.getSzPrintMessage() + "', '" + this.dsf57011Z1.getSzSalesTaxableYN() + "', '" + this.dsf57011Z1.getSzTaxRateArea() + "', '" + this.dsf57011Z1.getSzTaxExplCode() + "', '" + this.dsf57011Z1.getSzDescriptionTaxArea() + "', '" + this.dsf57011Z1.getMnTaxAuthority() + "', '" + this.dsf57011Z1.getMnTaxAuthority2() + "', '" + this.dsf57011Z1.getMnTaxAuthority3() + "', '" + this.dsf57011Z1.getMnTaxAuthority4() + "', '" + this.dsf57011Z1.getMnTaxAuthority5() + "', '" + this.dsf57011Z1.getMnTaxRate1() + "', '" + this.dsf57011Z1.getMnTaxRate2() + "', '" + this.dsf57011Z1.getMnTaxRate3() + "', '" + this.dsf57011Z1.getMnTaxRate4() + "', '" + this.dsf57011Z1.getMnTaxRate5() + "', '" + this.dsf57011Z1.getSzTaxCalculationMethod() + "', '" + this.dsf57011Z1.getMnAmountTaxable() + "', '" + this.dsf57011Z1.getMnAmountTax() + "', '" + this.dsf57011Z1.getSzPaymentTermsCode() + "', '" + this.dsf57011Z1.getMnDiscountAvailable() + "', '" + this.dsf57011Z1.getSzUserID() + "', '" + this.dsf57011Z1.getSzProgramID() + "', '" + this.dsf57011Z1.getSzWorkStationID() + "', '" + this.dsf57011Z1.getJdDateUpdated() + "', '" + this.dsf57011Z1.getMnTimeofDay() + "', '" + this.dsf57011Z1.getMnEDIDocumentNumber() + "', '" + this.dsf57011Z1.getSzEDIDocumentType() + "', '" + this.dsf57011Z1.getSzEDIDocumentKeyCo() + "', '" + this.dsf57011Z1.getMnEDILineNumber() + "', '" + this.dsf57011Z1.getMnOrderSuffix() + "', '" + this.dsf57011Z1.getMnCodClienteParent() + "', '" + this.dsf57011Z1.getMnDiscountAmount() + "', '" + this.dsf57011Z1.getMnAmountSalesTaxTotal1() + "', '" + this.dsf57011Z1.getMnAmountSalesTaxTotal2() + "', '" + this.dsf57011Z1.getMnAmountSalesTaxTotal3() + "', '" + this.dsf57011Z1.getMnAmountSalesTaxTotal4() + "', '" + this.dsf57011Z1.getMnAmountSalesTaxTotal5() + "', '" + this.dsf57011Z1.getMnAmountNonTaxable() + "', '" + this.dsf57011Z1.getMnAmountListPrice() + "', '" + this.dsf57011Z1.getSz2ndItemNumber() + "', '" + this.dsf57011Z1.getMnCarrierNumber() + "', '" + this.dsf57011Z1.getSzAgreementSupplementDistribution() + "', '" + this.dsf57011Z1.getSzEstablecimiento() + "', '" + this.dsf57011Z1.getMnTripNumber() + "', '" + this.dsf57011Z1.getMnWeightResult() + "', '" + this.dsf57011Z1.getSzDutyStatus() + "', '" + this.dsf57011Z1.getSzLotSerialNumber() + "', '" + this.dsf57011Z1.getSzParameterDataItem01() + "', '" + this.dsf57011Z1.getSzParameterDataItem02() + "', '" + this.dsf57011Z1.getSzParameterDataItem03() + "', '" + this.dsf57011Z1.getSzParameterDataItem04() + "', '" + this.dsf57011Z1.getSzParameterDataItem05() + "', '" + this.dsf57011Z1.getSzParameterDataItem06() + "', '" + this.dsf57011Z1.getSzParameterDataItem07() + "', '" + this.dsf57011Z1.getSzParameterDataItem08() + "', '" + this.dsf57011Z1.getSzParameterDataItem09() + "', '" + this.dsf57011Z1.getSzParameterDataItem10() + "', '" + this.dsf57011Z1.getSzLegalDocumentTitle() + "', '" + this.dsf57011Z1.getSzClaveAcceso() + "', '" + this.dsf57011Z1.getSzClaveAccesoContingencia() + "', '" + this.dsf57011Z1.getSzAutorizacionElectronica() + "', '" + this.dsf57011Z1.getSzRefAutorizacion1() + "', '" + this.dsf57011Z1.getSzRefAutorizacion2() + "', '" + this.dsf57011Z1.getSzRefAutorizacion3() + "', '" + this.dsf57011Z1.getSzRefAutorizacion4() + "', '" + this.dsf57011Z1.getSzAmbiente() + "', '" + this.dsf57011Z1.getSzTipoEmision() + "', '" + this.dsf57011Z1.getSzContribuyenteEspecial() + "', '" + this.dsf57011Z1.getSzObligadoContabilidad() + "', '" + this.dsf57011Z1.getSzMoneda() + "', '" + this.dsf57011Z1.getSzCatSales01() + "', '" + this.dsf57011Z1.getSzCatSales02() + "', '" + this.dsf57011Z1.getSzCatSales03() + "', '" + this.dsf57011Z1.getSzCatSales04() + "', '" + this.dsf57011Z1.getSzCatSales05() + "', '" + this.dsf57011Z1.getSzPeriodoFiscal() + "', '" + this.dsf57011Z1.getSzRise() + "');";
      log.error("QUERY: {}", query);
      try {
        if (!this.BD.sqlInsert(query) || this.BD.sqlCommit());
      } catch (Exception e) {
        log.error("Problemas al insertar la transaccion: {} {}", query, e);
      } 
    } catch (Exception e) {
      log.error("Problemas al insertar la transaccion: {} {}", query, e);
    } 
  } 
  
}
