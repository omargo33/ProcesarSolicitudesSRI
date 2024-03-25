package com.d3v.proceso;

import com.fundamentos.conexion.ManagerBD;

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
  DsF57011Z1 DSF57011Z1 = new DsF57011Z1();
  
  List<DsF57011Z1> listDSF57011Z1;
  
  private String esquema;
  
  ManagerBD BD;
  
  public EditLineSalesZ1() {
    setDSF57011Z1(new DsF57011Z1());
    setListDSF57011Z1(new ArrayList<>());
    setEsquema("");
    setBD(null);
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
      query = "SELECT * FROM " + this.esquema + ".t57011 WHERE szInvoiceCompany =  '" + this.DSF57011Z1.getSzInvoiceCompany() + "'  AND szJobTypeDescription =  '" + this.DSF57011Z1.getSzJobTypeDescription() + "'  AND szReferenceLegal = '" + this.DSF57011Z1.getSzReferenceLegal() + "'  AND szOperationType = '" + this.DSF57011Z1.getSzOperationType() + "'  AND mnLegalNumber = '" + this.DSF57011Z1.getMnLegalNumber() + "'  ";
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
        this.listDSF57011Z1.add(comprobante);
        setDSF57011Z1(comprobante);
      } 
    } catch (Exception e) {
      log.error("Problemas al consultar la transaccion: {} {}", query, e);
    } 
  }
  
  public void saveSales() {
    String query = "";
    try {
      query = "INSERT INTO " + this.esquema + ".t57011 (szComputerID, mnJobNumber, szBachType, mnBachNumber, mnDocumentNumber, szDocumentType, szDocumentCompany, mnInvoiceNumber, szInvoiceType, szInvoiceCompany, szReferenceLegal, szReference, mnLineNumber, mnSequenceNumber, mnSubSequenceNumber, szMember, mnLegalNumber, jdDateEfective, jdDateExpired, szOperationType, szJobTypeDescription, szThruCaseStatusCode, mnCodCliente, szNameAlpha, szTaxID, szAddressLine01, szAddressLine02, mnCodCliente_ShipTo, szBodega, szCompany, szName, szTaxIdentificationNumber, szAddressLine1, szAddressLine2, szAddressLine3, szAddressLine4, mnCodItemNumberShort, szPrintDataYN, szDescription, szDescription2, mnItemNumber, szUnitofMeasureasInput, szUnitofMeasurePricing, mnQuantityShipped, mnUnitsQtyBackordered, mnUnitsQuantityCanceledScrapped, mnAmountPriceUnit, mnAmountGross, mnAmountExtendedPrice, mnAmountExtendedCost, mnPercent1, jdDateRequested, szCommitted, szLineType, jdDateInvoice, jdDateNetDue, mnRelatedNumber, szRelatedOrderType, szCompanyRelatedOrder, szPrintMessage, szSalesTaxableYN, szTaxRateArea, szTaxExplCode, szDescriptionTaxArea, mnTaxAuthority, mnTaxAuthority2, mnTaxAuthority3, mnTaxAuthority4, mnTaxAuthority5, mnTaxRate1, mnTaxRate2, mnTaxRate3, mnTaxRate4, mnTaxRate5, szTaxCalculationMethod, mnAmountTaxable, mnAmountTax, szPaymentTermsCode, mnDiscountAvailable, szUserID, szProgramID, szWorkStationID, jdDateUpdated, mnTimeofDay, mnEDIDocumentNumber, szEDIDocumentType, szEDIDocumentKeyCo, mnEDILineNumber, mnOrderSuffix, mnCodClienteParent, mnDiscountAmount, mnAmountSalesTaxTotal1, mnAmountSalesTaxTotal2, mnAmountSalesTaxTotal3, mnAmountSalesTaxTotal4, mnAmountSalesTaxTotal5, mnAmountNonTaxable, mnAmountListPrice, sz2ndItemNumber, mnCarrierNumber, szAgreementSupplementDistribution, szEstablecimiento, mnTripNumber, mnWeightResult, szDutyStatus, szLotSerialNumber, szParameterDataItem01, szParameterDataItem02, szParameterDataItem03, szParameterDataItem04, szParameterDataItem05, szParameterDataItem06, szParameterDataItem07, szParameterDataItem08, szParameterDataItem09, szParameterDataItem10, szLegalDocumentTitle, szClaveAcceso, szClaveAccesoContingencia, szAutorizacionElectronica, szRefAutorizacion1, szRefAutorizacion2, szRefAutorizacion3, szRefAutorizacion4, szAmbiente, szTipoEmision, szContribuyenteEspecial, szObligadoContabilidad, szMoneda, szCatSales01, szCatSales02, szCatSales03, szCatSales04, szCatSales05, szPeriodoFiscal, szRise)VALUES('" + this.DSF57011Z1.getSzComputerID() + "', '" + this.DSF57011Z1.getMnJobNumber() + "', '" + this.DSF57011Z1.getSzBachType() + "', '" + this.DSF57011Z1.getMnBachNumber() + "', '" + this.DSF57011Z1.getMnDocumentNumber() + "', '" + this.DSF57011Z1.getSzDocumentType() + "', '" + this.DSF57011Z1.getSzDocumentCompany() + "', '" + this.DSF57011Z1.getMnInvoiceNumber() + "', '" + this.DSF57011Z1.getSzInvoiceType() + "', '" + this.DSF57011Z1.getSzInvoiceCompany() + "', '" + this.DSF57011Z1.getSzReferenceLegal() + "', '" + this.DSF57011Z1.getSzReference() + "', '" + this.DSF57011Z1.getMnLineNumber() + "', '" + this.DSF57011Z1.getMnSequenceNumber() + "', '" + this.DSF57011Z1.getMnSubSequenceNumber() + "', '" + this.DSF57011Z1.getSzMember() + "', '" + this.DSF57011Z1.getMnLegalNumber() + "', '" + this.DSF57011Z1.getJdDateEfective() + "', '" + this.DSF57011Z1.getJdDateExpired() + "', '" + this.DSF57011Z1.getSzOperationType() + "', '" + this.DSF57011Z1.getSzJobTypeDescription() + "', '" + this.DSF57011Z1.getSzThruCaseStatusCode() + "', '" + this.DSF57011Z1.getMnCodCliente() + "', '" + this.DSF57011Z1.getSzNameAlpha() + "', '" + this.DSF57011Z1.getSzTaxID() + "', '" + this.DSF57011Z1.getSzAddressLine01() + "', '" + this.DSF57011Z1.getSzAddressLine02() + "', '" + this.DSF57011Z1.getMnCodCliente_ShipTo() + "', '" + this.DSF57011Z1.getSzBodega() + "', '" + this.DSF57011Z1.getSzCompany() + "', '" + this.DSF57011Z1.getSzName() + "', '" + this.DSF57011Z1.getSzTaxIdentificationNumber() + "', '" + this.DSF57011Z1.getSzAddressLine1() + "', '" + this.DSF57011Z1.getSzAddressLine2() + "', '" + this.DSF57011Z1.getSzAddressLine3() + "', '" + this.DSF57011Z1.getSzAddressLine4() + "', '" + this.DSF57011Z1.getMnCodItemNumberShort() + "', '" + this.DSF57011Z1.getSzPrintDataYN() + "', '" + this.DSF57011Z1.getSzDescription() + "', '" + this.DSF57011Z1.getSzDescription2() + "', '" + this.DSF57011Z1.getMnItemNumber() + "', '" + this.DSF57011Z1.getSzUnitofMeasureasInput() + "', '" + this.DSF57011Z1.getSzUnitofMeasurePricing() + "', '" + this.DSF57011Z1.getMnQuantityShipped() + "', '" + this.DSF57011Z1.getMnUnitsQtyBackordered() + "', '" + this.DSF57011Z1.getMnUnitsQuantityCanceledScrapped() + "', '" + this.DSF57011Z1.getMnAmountPriceUnit() + "', '" + this.DSF57011Z1.getMnAmountGross() + "', '" + this.DSF57011Z1.getMnAmountExtendedPrice() + "', '" + this.DSF57011Z1.getMnAmountExtendedCost() + "', '" + this.DSF57011Z1.getMnPercent1() + "', '" + this.DSF57011Z1.getJdDateRequested() + "', '" + this.DSF57011Z1.getSzCommitted() + "', '" + this.DSF57011Z1.getSzLineType() + "', '" + this.DSF57011Z1.getJdDateInvoice() + "', '" + this.DSF57011Z1.getJdDateNetDue() + "', '" + this.DSF57011Z1.getMnRelatedNumber() + "', '" + this.DSF57011Z1.getSzRelatedOrderType() + "', '" + this.DSF57011Z1.getSzCompanyRelatedOrder() + "', '" + this.DSF57011Z1.getSzPrintMessage() + "', '" + this.DSF57011Z1.getSzSalesTaxableYN() + "', '" + this.DSF57011Z1.getSzTaxRateArea() + "', '" + this.DSF57011Z1.getSzTaxExplCode() + "', '" + this.DSF57011Z1.getSzDescriptionTaxArea() + "', '" + this.DSF57011Z1.getMnTaxAuthority() + "', '" + this.DSF57011Z1.getMnTaxAuthority2() + "', '" + this.DSF57011Z1.getMnTaxAuthority3() + "', '" + this.DSF57011Z1.getMnTaxAuthority4() + "', '" + this.DSF57011Z1.getMnTaxAuthority5() + "', '" + this.DSF57011Z1.getMnTaxRate1() + "', '" + this.DSF57011Z1.getMnTaxRate2() + "', '" + this.DSF57011Z1.getMnTaxRate3() + "', '" + this.DSF57011Z1.getMnTaxRate4() + "', '" + this.DSF57011Z1.getMnTaxRate5() + "', '" + this.DSF57011Z1.getSzTaxCalculationMethod() + "', '" + this.DSF57011Z1.getMnAmountTaxable() + "', '" + this.DSF57011Z1.getMnAmountTax() + "', '" + this.DSF57011Z1.getSzPaymentTermsCode() + "', '" + this.DSF57011Z1.getMnDiscountAvailable() + "', '" + this.DSF57011Z1.getSzUserID() + "', '" + this.DSF57011Z1.getSzProgramID() + "', '" + this.DSF57011Z1.getSzWorkStationID() + "', '" + this.DSF57011Z1.getJdDateUpdated() + "', '" + this.DSF57011Z1.getMnTimeofDay() + "', '" + this.DSF57011Z1.getMnEDIDocumentNumber() + "', '" + this.DSF57011Z1.getSzEDIDocumentType() + "', '" + this.DSF57011Z1.getSzEDIDocumentKeyCo() + "', '" + this.DSF57011Z1.getMnEDILineNumber() + "', '" + this.DSF57011Z1.getMnOrderSuffix() + "', '" + this.DSF57011Z1.getMnCodClienteParent() + "', '" + this.DSF57011Z1.getMnDiscountAmount() + "', '" + this.DSF57011Z1.getMnAmountSalesTaxTotal1() + "', '" + this.DSF57011Z1.getMnAmountSalesTaxTotal2() + "', '" + this.DSF57011Z1.getMnAmountSalesTaxTotal3() + "', '" + this.DSF57011Z1.getMnAmountSalesTaxTotal4() + "', '" + this.DSF57011Z1.getMnAmountSalesTaxTotal5() + "', '" + this.DSF57011Z1.getMnAmountNonTaxable() + "', '" + this.DSF57011Z1.getMnAmountListPrice() + "', '" + this.DSF57011Z1.getSz2ndItemNumber() + "', '" + this.DSF57011Z1.getMnCarrierNumber() + "', '" + this.DSF57011Z1.getSzAgreementSupplementDistribution() + "', '" + this.DSF57011Z1.getSzEstablecimiento() + "', '" + this.DSF57011Z1.getMnTripNumber() + "', '" + this.DSF57011Z1.getMnWeightResult() + "', '" + this.DSF57011Z1.getSzDutyStatus() + "', '" + this.DSF57011Z1.getSzLotSerialNumber() + "', '" + this.DSF57011Z1.getSzParameterDataItem01() + "', '" + this.DSF57011Z1.getSzParameterDataItem02() + "', '" + this.DSF57011Z1.getSzParameterDataItem03() + "', '" + this.DSF57011Z1.getSzParameterDataItem04() + "', '" + this.DSF57011Z1.getSzParameterDataItem05() + "', '" + this.DSF57011Z1.getSzParameterDataItem06() + "', '" + this.DSF57011Z1.getSzParameterDataItem07() + "', '" + this.DSF57011Z1.getSzParameterDataItem08() + "', '" + this.DSF57011Z1.getSzParameterDataItem09() + "', '" + this.DSF57011Z1.getSzParameterDataItem10() + "', '" + this.DSF57011Z1.getSzLegalDocumentTitle() + "', '" + this.DSF57011Z1.getSzClaveAcceso() + "', '" + this.DSF57011Z1.getSzClaveAccesoContingencia() + "', '" + this.DSF57011Z1.getSzAutorizacionElectronica() + "', '" + this.DSF57011Z1.getSzRefAutorizacion1() + "', '" + this.DSF57011Z1.getSzRefAutorizacion2() + "', '" + this.DSF57011Z1.getSzRefAutorizacion3() + "', '" + this.DSF57011Z1.getSzRefAutorizacion4() + "', '" + this.DSF57011Z1.getSzAmbiente() + "', '" + this.DSF57011Z1.getSzTipoEmision() + "', '" + this.DSF57011Z1.getSzContribuyenteEspecial() + "', '" + this.DSF57011Z1.getSzObligadoContabilidad() + "', '" + this.DSF57011Z1.getSzMoneda() + "', '" + this.DSF57011Z1.getSzCatSales01() + "', '" + this.DSF57011Z1.getSzCatSales02() + "', '" + this.DSF57011Z1.getSzCatSales03() + "', '" + this.DSF57011Z1.getSzCatSales04() + "', '" + this.DSF57011Z1.getSzCatSales05() + "', '" + this.DSF57011Z1.getSzPeriodoFiscal() + "', '" + this.DSF57011Z1.getSzRise() + "');";
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
