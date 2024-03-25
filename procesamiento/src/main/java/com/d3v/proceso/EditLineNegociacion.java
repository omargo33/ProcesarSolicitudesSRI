package com.d3v.proceso;

import com.fundamentos.conexion.managerBD;

import lombok.Getter;
import lombok.Setter;

import com.d3v.utilitarios.MainFiles;

@Getter
@Setter
public class EditLineNegociacion {
  private static String PAQUETE_OBJETO = "com.d3v.proceso";
  
  private int transaccionID;
  
  private String ComputerID;
  
  private String docEmpresa;
  
  private String docType;
  
  private int docDocument = 0;
  
  private int sequence = 0;
  
  private int subSequence = 0;
  
  private String typeOperation;
  
  private String id;
  
  private String creationDateTime;
  
  private String cashPointReferenceID;
  
  private String cashPointOfficeReferenceID;
  
  private String cashPointPaymentGroupReferenceID;
  
  private String paymentTransactionID;
  
  private String paymentAmount;
  
  private String valueDate;
  
  private String itemText;
  
  private String payerContractAccountID;
  
  private String chequeID;
  
  private String houseBankID;
  
  private String houseBankAccountInternalID;
  
  private String houseBankCountryCode;
  
  private String printYN;
  
  private String reversalCashPointReferenceID;
  
  private String reversalCashPointOfficeReferenceID;
  
  private String reversalPaymentTransactionID;
  
  private String reversalValueDate;
  
  private String statusReversal;
  
  private String closingDocumentAmount;
  
  private String selectionCAorLegacy;
  
  private String usuarioOriginador;
  
  private String usuarioCierre;
  
  private String usuarioModficador;
  
  private String fechaOrigen;
  
  private String fechaCierre;
  
  private String fechaModificada;
  
  private String StatusPayment;
  
  private String msgError;
  
  private String refUsuario1;
  
  private String refUsuario2;
  
  private String refUsuario3;
  
  private String refUsuario4;
  
  private String namePayment;
  
  private String codigoEmpresa;
  
  private String areaNegocio;
  
  private String rol;
  
  private String identificadorFiscal;
  
  private String razonSocial;
  
  private String direccion;
  
  private String telefono;
  
  private String correo;
 

  public EditLineNegociacion() {
    setTransaccionID(0);
    setComputerID("");
    setDocEmpresa("");
    setDocType("");
    setDocDocument(0);
    setSequence(0);
    setSubSequence(0);
    setTypeOperation("");
    setId("");
    setCreationDateTime("");
    setCashPointReferenceID("");
    setCashPointOfficeReferenceID("");
    setCashPointPaymentGroupReferenceID("");
    setPaymentTransactionID("");
    setPaymentAmount("0.00");
    setValueDate("0000-00-00");
    setItemText("");
    setPayerContractAccountID("");
    setChequeID("");
    setHouseBankID("");
    setHouseBankAccountInternalID("");
    setHouseBankCountryCode("");
    setPrintYN("");
    setReversalCashPointReferenceID("");
    setReversalCashPointOfficeReferenceID("");
    setReversalPaymentTransactionID("");
    setReversalValueDate("0000-00-00");
    setStatusReversal("");
    setClosingDocumentAmount("0.00");
    setSelectionCAorLegacy("");
    setUsuarioOriginador("");
    setUsuarioCierre("");
    setUsuarioModficador("");
    setFechaOrigen("0000-00-00");
    setFechaModificada("0000-00-00");
    setFechaCierre("0000-00-00");
    setStatusPayment("");
    setMsgError("");
    setRefUsuario1("");
    setRefUsuario2("");
    setRefUsuario3("");
    setRefUsuario4("");
    setNamePayment("");
    setCodigoEmpresa("");
    setAreaNegocio("");
    setRol("");
    setIdentificadorFiscal("");
    setRazonSocial("");
    setDireccion("");
    setTelefono("");
    setCorreo("");
  }
  
  public void saveTransaction(managerBD BD, String esquema) {
    String a = getPaymentAmount();
    String b = a.substring(getPaymentAmount().length() - 1);
    if (b.equals("."))
      setPaymentAmount(getPaymentAmount().concat("0")); 
    if (getTransaccionID() == 0) {
      EditLinerNroSiguiente nno = new EditLinerNroSiguiente();
      nno.setBD(BD);
      nno.setEsquema(esquema);
      nno.getDSF00221().setObjeto("t0711z1");
      nno.editlineObjeto("1");
      setTransaccionID(nno.getDSF00221().getNextNumber());
    } 
    String query = "";
    query = "INSERT INTO  " + esquema + ".t0711z1  ( szTransaccionID ,   iComputerID ,   szDocEmpresa ,   szDocType ,   mnDocDocument ,   mnSequence ,   mnSubSequence ,   szTypeOperation ,   szID ,   szCreationDateTime ,   szCashPointReferenceID ,   szCashPointOfficeReferenceID ,   szCashPointPaymentGroupReferenceID ,   szPaymentTransactionID ,   mnPaymentAmount ,   jdValueDate ,   szItemText ,   szPayerContractAccountID ,   szChequeID ,   szHouseBankID ,   szHouseBankAccountInternalID ,   szHouseBankCountryCode ,   szPrintYN ,   szReversalCashPointReferenceID ,   szReversalCashPointOfficeReferenceID ,   szReversalPaymentTransactionID ,   szReversalValueDate ,   szStatusReversal ,   mnClosingDocumentAmount,   szUsuarioOriginador,   szUsuarioCierre,   szUsuarioModficador,   jdFechaOrigen,   jdFechaCierre,   jdFechaModificador,   szStatusPayment,   szMsgError,   szRefUsuario1,   szRefUsuario2,   szRefUsuario3,   szRefUsuario4,   szNamePayment,   szCodigoEmpresa,   szAreaNegocio,   szRol,   szSelectionCAorLegacy,   szIdentificadorFiscal,   szRazonSocial,   szDireccion,   szTelefono,   szCorreo  )  VALUES ('" + getTransaccionID() + "',  '" + getComputerID() + "',  '" + getDocEmpresa() + "',  '" + getDocType() + "',  '" + getDocDocument() + "',  '" + getSequence() + "',  '" + getSubSequence() + "',  '" + getTypeOperation() + "',  '" + getId() + "',  '" + getCreationDateTime() + "',  '" + getCashPointReferenceID() + "',  '" + getCashPointOfficeReferenceID() + "',  '" + getCashPointPaymentGroupReferenceID() + "',  '" + getPaymentTransactionID() + "',  '" + getPaymentAmount() + "',  '" + getValueDate() + "',  '" + getItemText() + "',  '" + getPayerContractAccountID() + "',  '" + getChequeID() + "',  '" + getHouseBankID() + "',  '" + getHouseBankAccountInternalID() + "',  '" + getHouseBankCountryCode() + "',  '" + getPrintYN() + "',  '" + getReversalCashPointReferenceID() + "',  '" + getReversalCashPointOfficeReferenceID() + "',  '" + getReversalPaymentTransactionID() + "',  '" + getReversalValueDate() + "',  '" + getStatusReversal() + "',  '" + getClosingDocumentAmount() + "', '" + getUsuarioOriginador() + "', '" + getUsuarioCierre() + "', '" + getUsuarioModficador() + "', '" + getFechaOrigen() + "', '" + getFechaCierre() + "', '" + getFechaModificada() + "', '" + getStatusPayment() + "', '" + getMsgError() + "', '" + getRefUsuario1() + "', '" + getRefUsuario2() + "', '" + getRefUsuario3() + "', '" + getRefUsuario4() + "', '" + getNamePayment() + "', '" + getCodigoEmpresa() + "', '" + getAreaNegocio() + "', '" + getRol() + "', '" + getSelectionCAorLegacy() + "', '" + getIdentificadorFiscal() + "', '" + getRazonSocial() + "', '" + getDireccion() + "', '" + getTelefono() + "', '" + getCorreo() + "' );";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".EditLineRecaudacion()", query });
    if (!BD.sqlInsert(query) || BD.sqlCommit());
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".EditLineRecaudacion()", Integer.valueOf(getDocDocument()), getTypeOperation(), getPaymentTransactionID(), BD.getMsjError() });
  }
  
  public void updTransaction(managerBD BD, String esquema) {
    String query = "";
    query = "UPDATE " + esquema + ".t0711z1 SET szStatusPayment =  '" + getStatusPayment() + "' , szMsgError = '" + getMsgError() + "' WHERE  szDocEmpresa = '" + getDocEmpresa() + "' AND   szDocType = '" + getDocType() + "' AND   mnDocDocument = '" + getDocDocument() + "' ;";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".updTransaction()", query });
    if (!BD.sqlUpdate(query) || BD.sqlCommit());
  }
  
  public void AnulacionCierreCaja(managerBD BD, String esquema) {
    String query = "";
    query = "UPDATE " + esquema + ".t0711z1 SET szReversalCashPointReferenceID =  '" + getReversalCashPointReferenceID() + "' , szReversalPaymentTransactionID = '" + getReversalPaymentTransactionID() + "',  szReversalValueDate = '" + getReversalValueDate() + "',  szStatusReversal = '" + getStatusReversal() + "',  szMsgError = '" + getMsgError() + "' WHERE  szCashPointPaymentGroupReferenceID = '" + getCashPointPaymentGroupReferenceID() + "' AND   szDocType = 'CC' and szStatusReversal not in ('A') ;";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".AnulacionCierreCaja()", query });
    if (!BD.sqlUpdate(query) || BD.sqlCommit());
  }
  
  public void AnulacionComprobante(managerBD BD, String esquema) {
    String query = "";
    query = "UPDATE " + esquema + ".t0711z1 SET szUsuarioModficador =  '" + getUsuarioModficador() + "' , szReversalCashPointReferenceID = '" + getReversalPaymentTransactionID() + "',  szReversalValueDate = '" + getReversalValueDate() + "',  szStatusReversal = '" + getStatusReversal() + "'  WHERE  szPaymentTransactionID = '" + getPaymentTransactionID() + "' ;";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".AnulacionComprobante()", query });
    if (!BD.sqlUpdate(query) || BD.sqlCommit());
  }
  
  public void marcarRegCierreCaja(managerBD BD, String esquema) {
    String query = "UPDATE " + esquema + ".t0711z1 SET szStatusPayment =  '" + getStatusPayment() + "' , szUsuarioCierre = '" + getUsuarioOriginador() + "' , jdFechaCierre = '" + getFechaOrigen() + "' , szRefUsuario3 = '" + getDocType() + "-" + getDocDocument() + "-" + getDocEmpresa() + "' WHERE  szCashPointPaymentGroupReferenceID = '" + getCashPointPaymentGroupReferenceID() + "' and szTypeOperation not in ('00') ;";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".marcarRegCierreCaja()", query });
    if (!BD.sqlUpdate(query) || BD.sqlCommit());
  }
  
  public void limpiaGrupoPagos(managerBD BD, String esquema) {
    String query = " UPDATE " + esquema + ".t079804  SET szCierreCaja = ' ' ,  iDocNumber = 0 , szTypeDoc = ' ' ,  szCompanyDoc = ' '  WHERE  szCodEmpresa = '" + getDocEmpresa() + "' AND  szCodOficina = '" + getCashPointOfficeReferenceID() + "' AND   szCodCaja = '" + getCashPointReferenceID() + "' AND   jdFechaEmision = '" + getValueDate() + "' AND   szDocType = '" + getDocType() + "' ;";
    MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".limpiaGrupoPagos()", query });
    if (!BD.sqlUpdate(query) || BD.sqlCommit());
  }
  
}
