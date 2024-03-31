package  com.leon.estructura.persistencia.entidad;

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
public class T0911Id   implements Serializable {


     private String documentCompany;
     private String documentType;
     private Integer documentVoucher;
     private Date dateVoucher;
     private Integer journalEntryLineNumber;
     private Integer lineExtensionCode;
     private String postedCode;
     private Integer batchNumber;
     private String batchType;
     private Date dateBatch;
     private Date dateBatchSystemDate;
     private Date batchTime;
     private String accountNumber;
     private String accountModeGl;
     private Integer accountId;
     private String businessUnit;
     private String objectAccount;
     private String subsidiary;
     private String subledgerGl;
     private String subledgerType;
     private String ledgerTypes;
     private Integer periodNumber;
     private Integer century;
     private Integer fiscalYear;
     private String currencyCodeFrom;
     private Double amount;
     private Double units;
     private String unitofMeasure;
     private String reverseorVoid;
     private String nameAlphaExplanation;
     private String nameRemarkExplanation;
     private String reference1;
     private String reference2;
     private String reference3;
     private Integer documentPayItemAlter;
     private Integer documentOriginalAlter;
     private String documentTypeOriginalAlter;
     private String documentCompanyAlter;
     private Integer addressNumber;
     private Date dateInvoice;
     private String businessUnitHome;
     private String userId;
     private String programId;
     private String workStationId;
     private Date dateUpdate;
     private Date timeLastUpdate;
     private Integer itemNumberShort;

  


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof T0911Id) ) return false;
		 T0911Id castOther = ( T0911Id ) other; 
         
		 return ( (this.getDocumentCompany()==castOther.getDocumentCompany()) || ( this.getDocumentCompany()!=null && castOther.getDocumentCompany()!=null && this.getDocumentCompany().equals(castOther.getDocumentCompany()) ) )
 && ( (this.getDocumentType()==castOther.getDocumentType()) || ( this.getDocumentType()!=null && castOther.getDocumentType()!=null && this.getDocumentType().equals(castOther.getDocumentType()) ) )
 && ( (this.getDocumentVoucher()==castOther.getDocumentVoucher()) || ( this.getDocumentVoucher()!=null && castOther.getDocumentVoucher()!=null && this.getDocumentVoucher().equals(castOther.getDocumentVoucher()) ) )
 && ( (this.getDateVoucher()==castOther.getDateVoucher()) || ( this.getDateVoucher()!=null && castOther.getDateVoucher()!=null && this.getDateVoucher().equals(castOther.getDateVoucher()) ) )
 && ( (this.getJournalEntryLineNumber()==castOther.getJournalEntryLineNumber()) || ( this.getJournalEntryLineNumber()!=null && castOther.getJournalEntryLineNumber()!=null && this.getJournalEntryLineNumber().equals(castOther.getJournalEntryLineNumber()) ) )
 && ( (this.getLineExtensionCode()==castOther.getLineExtensionCode()) || ( this.getLineExtensionCode()!=null && castOther.getLineExtensionCode()!=null && this.getLineExtensionCode().equals(castOther.getLineExtensionCode()) ) )
 && ( (this.getPostedCode()==castOther.getPostedCode()) || ( this.getPostedCode()!=null && castOther.getPostedCode()!=null && this.getPostedCode().equals(castOther.getPostedCode()) ) )
 && ( (this.getBatchNumber()==castOther.getBatchNumber()) || ( this.getBatchNumber()!=null && castOther.getBatchNumber()!=null && this.getBatchNumber().equals(castOther.getBatchNumber()) ) )
 && ( (this.getBatchType()==castOther.getBatchType()) || ( this.getBatchType()!=null && castOther.getBatchType()!=null && this.getBatchType().equals(castOther.getBatchType()) ) )
 && ( (this.getDateBatch()==castOther.getDateBatch()) || ( this.getDateBatch()!=null && castOther.getDateBatch()!=null && this.getDateBatch().equals(castOther.getDateBatch()) ) )
 && ( (this.getDateBatchSystemDate()==castOther.getDateBatchSystemDate()) || ( this.getDateBatchSystemDate()!=null && castOther.getDateBatchSystemDate()!=null && this.getDateBatchSystemDate().equals(castOther.getDateBatchSystemDate()) ) )
 && ( (this.getBatchTime()==castOther.getBatchTime()) || ( this.getBatchTime()!=null && castOther.getBatchTime()!=null && this.getBatchTime().equals(castOther.getBatchTime()) ) )
 && ( (this.getAccountNumber()==castOther.getAccountNumber()) || ( this.getAccountNumber()!=null && castOther.getAccountNumber()!=null && this.getAccountNumber().equals(castOther.getAccountNumber()) ) )
 && ( (this.getAccountModeGl()==castOther.getAccountModeGl()) || ( this.getAccountModeGl()!=null && castOther.getAccountModeGl()!=null && this.getAccountModeGl().equals(castOther.getAccountModeGl()) ) )
 && ( (this.getAccountId()==castOther.getAccountId()) || ( this.getAccountId()!=null && castOther.getAccountId()!=null && this.getAccountId().equals(castOther.getAccountId()) ) )
 && ( (this.getBusinessUnit()==castOther.getBusinessUnit()) || ( this.getBusinessUnit()!=null && castOther.getBusinessUnit()!=null && this.getBusinessUnit().equals(castOther.getBusinessUnit()) ) )
 && ( (this.getObjectAccount()==castOther.getObjectAccount()) || ( this.getObjectAccount()!=null && castOther.getObjectAccount()!=null && this.getObjectAccount().equals(castOther.getObjectAccount()) ) )
 && ( (this.getSubsidiary()==castOther.getSubsidiary()) || ( this.getSubsidiary()!=null && castOther.getSubsidiary()!=null && this.getSubsidiary().equals(castOther.getSubsidiary()) ) )
 && ( (this.getSubledgerGl()==castOther.getSubledgerGl()) || ( this.getSubledgerGl()!=null && castOther.getSubledgerGl()!=null && this.getSubledgerGl().equals(castOther.getSubledgerGl()) ) )
 && ( (this.getSubledgerType()==castOther.getSubledgerType()) || ( this.getSubledgerType()!=null && castOther.getSubledgerType()!=null && this.getSubledgerType().equals(castOther.getSubledgerType()) ) )
 && ( (this.getLedgerTypes()==castOther.getLedgerTypes()) || ( this.getLedgerTypes()!=null && castOther.getLedgerTypes()!=null && this.getLedgerTypes().equals(castOther.getLedgerTypes()) ) )
 && ( (this.getPeriodNumber()==castOther.getPeriodNumber()) || ( this.getPeriodNumber()!=null && castOther.getPeriodNumber()!=null && this.getPeriodNumber().equals(castOther.getPeriodNumber()) ) )
 && ( (this.getCentury()==castOther.getCentury()) || ( this.getCentury()!=null && castOther.getCentury()!=null && this.getCentury().equals(castOther.getCentury()) ) )
 && ( (this.getFiscalYear()==castOther.getFiscalYear()) || ( this.getFiscalYear()!=null && castOther.getFiscalYear()!=null && this.getFiscalYear().equals(castOther.getFiscalYear()) ) )
 && ( (this.getCurrencyCodeFrom()==castOther.getCurrencyCodeFrom()) || ( this.getCurrencyCodeFrom()!=null && castOther.getCurrencyCodeFrom()!=null && this.getCurrencyCodeFrom().equals(castOther.getCurrencyCodeFrom()) ) )
 && ( (this.getAmount()==castOther.getAmount()) || ( this.getAmount()!=null && castOther.getAmount()!=null && this.getAmount().equals(castOther.getAmount()) ) )
 && ( (this.getUnits()==castOther.getUnits()) || ( this.getUnits()!=null && castOther.getUnits()!=null && this.getUnits().equals(castOther.getUnits()) ) )
 && ( (this.getUnitofMeasure()==castOther.getUnitofMeasure()) || ( this.getUnitofMeasure()!=null && castOther.getUnitofMeasure()!=null && this.getUnitofMeasure().equals(castOther.getUnitofMeasure()) ) )
 && ( (this.getReverseorVoid()==castOther.getReverseorVoid()) || ( this.getReverseorVoid()!=null && castOther.getReverseorVoid()!=null && this.getReverseorVoid().equals(castOther.getReverseorVoid()) ) )
 && ( (this.getNameAlphaExplanation()==castOther.getNameAlphaExplanation()) || ( this.getNameAlphaExplanation()!=null && castOther.getNameAlphaExplanation()!=null && this.getNameAlphaExplanation().equals(castOther.getNameAlphaExplanation()) ) )
 && ( (this.getNameRemarkExplanation()==castOther.getNameRemarkExplanation()) || ( this.getNameRemarkExplanation()!=null && castOther.getNameRemarkExplanation()!=null && this.getNameRemarkExplanation().equals(castOther.getNameRemarkExplanation()) ) )
 && ( (this.getReference1()==castOther.getReference1()) || ( this.getReference1()!=null && castOther.getReference1()!=null && this.getReference1().equals(castOther.getReference1()) ) )
 && ( (this.getReference2()==castOther.getReference2()) || ( this.getReference2()!=null && castOther.getReference2()!=null && this.getReference2().equals(castOther.getReference2()) ) )
 && ( (this.getReference3()==castOther.getReference3()) || ( this.getReference3()!=null && castOther.getReference3()!=null && this.getReference3().equals(castOther.getReference3()) ) )
 && ( (this.getDocumentPayItemAlter()==castOther.getDocumentPayItemAlter()) || ( this.getDocumentPayItemAlter()!=null && castOther.getDocumentPayItemAlter()!=null && this.getDocumentPayItemAlter().equals(castOther.getDocumentPayItemAlter()) ) )
 && ( (this.getDocumentOriginalAlter()==castOther.getDocumentOriginalAlter()) || ( this.getDocumentOriginalAlter()!=null && castOther.getDocumentOriginalAlter()!=null && this.getDocumentOriginalAlter().equals(castOther.getDocumentOriginalAlter()) ) )
 && ( (this.getDocumentTypeOriginalAlter()==castOther.getDocumentTypeOriginalAlter()) || ( this.getDocumentTypeOriginalAlter()!=null && castOther.getDocumentTypeOriginalAlter()!=null && this.getDocumentTypeOriginalAlter().equals(castOther.getDocumentTypeOriginalAlter()) ) )
 && ( (this.getDocumentCompanyAlter()==castOther.getDocumentCompanyAlter()) || ( this.getDocumentCompanyAlter()!=null && castOther.getDocumentCompanyAlter()!=null && this.getDocumentCompanyAlter().equals(castOther.getDocumentCompanyAlter()) ) )
 && ( (this.getAddressNumber()==castOther.getAddressNumber()) || ( this.getAddressNumber()!=null && castOther.getAddressNumber()!=null && this.getAddressNumber().equals(castOther.getAddressNumber()) ) )
 && ( (this.getDateInvoice()==castOther.getDateInvoice()) || ( this.getDateInvoice()!=null && castOther.getDateInvoice()!=null && this.getDateInvoice().equals(castOther.getDateInvoice()) ) )
 && ( (this.getBusinessUnitHome()==castOther.getBusinessUnitHome()) || ( this.getBusinessUnitHome()!=null && castOther.getBusinessUnitHome()!=null && this.getBusinessUnitHome().equals(castOther.getBusinessUnitHome()) ) )
 && ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) )
 && ( (this.getProgramId()==castOther.getProgramId()) || ( this.getProgramId()!=null && castOther.getProgramId()!=null && this.getProgramId().equals(castOther.getProgramId()) ) )
 && ( (this.getWorkStationId()==castOther.getWorkStationId()) || ( this.getWorkStationId()!=null && castOther.getWorkStationId()!=null && this.getWorkStationId().equals(castOther.getWorkStationId()) ) )
 && ( (this.getDateUpdate()==castOther.getDateUpdate()) || ( this.getDateUpdate()!=null && castOther.getDateUpdate()!=null && this.getDateUpdate().equals(castOther.getDateUpdate()) ) )
 && ( (this.getTimeLastUpdate()==castOther.getTimeLastUpdate()) || ( this.getTimeLastUpdate()!=null && castOther.getTimeLastUpdate()!=null && this.getTimeLastUpdate().equals(castOther.getTimeLastUpdate()) ) )
 && ( (this.getItemNumberShort()==castOther.getItemNumberShort()) || ( this.getItemNumberShort()!=null && castOther.getItemNumberShort()!=null && this.getItemNumberShort().equals(castOther.getItemNumberShort()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getDocumentCompany() == null ? 0 : this.getDocumentCompany().hashCode() );
         result = 37 * result + ( getDocumentType() == null ? 0 : this.getDocumentType().hashCode() );
         result = 37 * result + ( getDocumentVoucher() == null ? 0 : this.getDocumentVoucher().hashCode() );
         result = 37 * result + ( getDateVoucher() == null ? 0 : this.getDateVoucher().hashCode() );
         result = 37 * result + ( getJournalEntryLineNumber() == null ? 0 : this.getJournalEntryLineNumber().hashCode() );
         result = 37 * result + ( getLineExtensionCode() == null ? 0 : this.getLineExtensionCode().hashCode() );
         result = 37 * result + ( getPostedCode() == null ? 0 : this.getPostedCode().hashCode() );
         result = 37 * result + ( getBatchNumber() == null ? 0 : this.getBatchNumber().hashCode() );
         result = 37 * result + ( getBatchType() == null ? 0 : this.getBatchType().hashCode() );
         result = 37 * result + ( getDateBatch() == null ? 0 : this.getDateBatch().hashCode() );
         result = 37 * result + ( getDateBatchSystemDate() == null ? 0 : this.getDateBatchSystemDate().hashCode() );
         result = 37 * result + ( getBatchTime() == null ? 0 : this.getBatchTime().hashCode() );
         result = 37 * result + ( getAccountNumber() == null ? 0 : this.getAccountNumber().hashCode() );
         result = 37 * result + ( getAccountModeGl() == null ? 0 : this.getAccountModeGl().hashCode() );
         result = 37 * result + ( getAccountId() == null ? 0 : this.getAccountId().hashCode() );
         result = 37 * result + ( getBusinessUnit() == null ? 0 : this.getBusinessUnit().hashCode() );
         result = 37 * result + ( getObjectAccount() == null ? 0 : this.getObjectAccount().hashCode() );
         result = 37 * result + ( getSubsidiary() == null ? 0 : this.getSubsidiary().hashCode() );
         result = 37 * result + ( getSubledgerGl() == null ? 0 : this.getSubledgerGl().hashCode() );
         result = 37 * result + ( getSubledgerType() == null ? 0 : this.getSubledgerType().hashCode() );
         result = 37 * result + ( getLedgerTypes() == null ? 0 : this.getLedgerTypes().hashCode() );
         result = 37 * result + ( getPeriodNumber() == null ? 0 : this.getPeriodNumber().hashCode() );
         result = 37 * result + ( getCentury() == null ? 0 : this.getCentury().hashCode() );
         result = 37 * result + ( getFiscalYear() == null ? 0 : this.getFiscalYear().hashCode() );
         result = 37 * result + ( getCurrencyCodeFrom() == null ? 0 : this.getCurrencyCodeFrom().hashCode() );
         result = 37 * result + ( getAmount() == null ? 0 : this.getAmount().hashCode() );
         result = 37 * result + ( getUnits() == null ? 0 : this.getUnits().hashCode() );
         result = 37 * result + ( getUnitofMeasure() == null ? 0 : this.getUnitofMeasure().hashCode() );
         result = 37 * result + ( getReverseorVoid() == null ? 0 : this.getReverseorVoid().hashCode() );
         result = 37 * result + ( getNameAlphaExplanation() == null ? 0 : this.getNameAlphaExplanation().hashCode() );
         result = 37 * result + ( getNameRemarkExplanation() == null ? 0 : this.getNameRemarkExplanation().hashCode() );
         result = 37 * result + ( getReference1() == null ? 0 : this.getReference1().hashCode() );
         result = 37 * result + ( getReference2() == null ? 0 : this.getReference2().hashCode() );
         result = 37 * result + ( getReference3() == null ? 0 : this.getReference3().hashCode() );
         result = 37 * result + ( getDocumentPayItemAlter() == null ? 0 : this.getDocumentPayItemAlter().hashCode() );
         result = 37 * result + ( getDocumentOriginalAlter() == null ? 0 : this.getDocumentOriginalAlter().hashCode() );
         result = 37 * result + ( getDocumentTypeOriginalAlter() == null ? 0 : this.getDocumentTypeOriginalAlter().hashCode() );
         result = 37 * result + ( getDocumentCompanyAlter() == null ? 0 : this.getDocumentCompanyAlter().hashCode() );
         result = 37 * result + ( getAddressNumber() == null ? 0 : this.getAddressNumber().hashCode() );
         result = 37 * result + ( getDateInvoice() == null ? 0 : this.getDateInvoice().hashCode() );
         result = 37 * result + ( getBusinessUnitHome() == null ? 0 : this.getBusinessUnitHome().hashCode() );
         result = 37 * result + ( getUserId() == null ? 0 : this.getUserId().hashCode() );
         result = 37 * result + ( getProgramId() == null ? 0 : this.getProgramId().hashCode() );
         result = 37 * result + ( getWorkStationId() == null ? 0 : this.getWorkStationId().hashCode() );
         result = 37 * result + ( getDateUpdate() == null ? 0 : this.getDateUpdate().hashCode() );
         result = 37 * result + ( getTimeLastUpdate() == null ? 0 : this.getTimeLastUpdate().hashCode() );
         result = 37 * result + ( getItemNumberShort() == null ? 0 : this.getItemNumberShort().hashCode() );
         return result;
   }   


}


