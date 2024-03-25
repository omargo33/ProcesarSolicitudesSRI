package com.d3v.proceso;

import com.fundamentos.conexion.managerBD;
import com.d3v.utilitarios.MainFiles;

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
  
  public int getTransaccionID() {
    return this.transaccionID;
  }
  
  public void setTransaccionID(int transaccionID) {
    this.transaccionID = transaccionID;
  }
  
  public String getComputerID() {
    return this.ComputerID;
  }
  
  public void setComputerID(String ComputerID) {
    this.ComputerID = ComputerID;
  }
  
  public String getDocEmpresa() {
    return this.docEmpresa;
  }
  
  public void setDocEmpresa(String docEmpresa) {
    this.docEmpresa = docEmpresa;
  }
  
  public String getDocType() {
    return this.docType;
  }
  
  public void setDocType(String docType) {
    this.docType = docType;
  }
  
  public int getDocDocument() {
    return this.docDocument;
  }
  
  public void setDocDocument(int docDocument) {
    this.docDocument = docDocument;
  }
  
  public int getSequence() {
    return this.sequence;
  }
  
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
  
  public int getSubSequence() {
    return this.subSequence;
  }
  
  public void setSubSequence(int subSequence) {
    this.subSequence = subSequence;
  }
  
  public String getTypeOperation() {
    return this.typeOperation;
  }
  
  public void setTypeOperation(String typeOperation) {
    this.typeOperation = typeOperation;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getCreationDateTime() {
    return this.creationDateTime;
  }
  
  public void setCreationDateTime(String creationDateTime) {
    this.creationDateTime = creationDateTime;
  }
  
  public String getCashPointReferenceID() {
    return this.cashPointReferenceID;
  }
  
  public void setCashPointReferenceID(String cashPointReferenceID) {
    this.cashPointReferenceID = cashPointReferenceID;
  }
  
  public String getCashPointOfficeReferenceID() {
    return this.cashPointOfficeReferenceID;
  }
  
  public void setCashPointOfficeReferenceID(String cashPointOfficeReferenceID) {
    this.cashPointOfficeReferenceID = cashPointOfficeReferenceID;
  }
  
  public String getCashPointPaymentGroupReferenceID() {
    return this.cashPointPaymentGroupReferenceID;
  }
  
  public void setCashPointPaymentGroupReferenceID(String cashPointPaymentGroupReferenceID) {
    this.cashPointPaymentGroupReferenceID = cashPointPaymentGroupReferenceID;
  }
  
  public String getPaymentTransactionID() {
    return this.paymentTransactionID;
  }
  
  public void setPaymentTransactionID(String paymentTransactionID) {
    this.paymentTransactionID = paymentTransactionID;
  }
  
  public String getPaymentAmount() {
    return this.paymentAmount;
  }
  
  public void setPaymentAmount(String paymentAmount) {
    this.paymentAmount = paymentAmount;
  }
  
  public String getValueDate() {
    return this.valueDate;
  }
  
  public void setValueDate(String valueDate) {
    this.valueDate = valueDate;
  }
  
  public String getItemText() {
    return this.itemText;
  }
  
  public void setItemText(String itemText) {
    this.itemText = itemText;
  }
  
  public String getPayerContractAccountID() {
    return this.payerContractAccountID;
  }
  
  public void setPayerContractAccountID(String payerContractAccountID) {
    this.payerContractAccountID = payerContractAccountID;
  }
  
  public String getChequeID() {
    return this.chequeID;
  }
  
  public void setChequeID(String chequeID) {
    this.chequeID = chequeID;
  }
  
  public String getHouseBankID() {
    return this.houseBankID;
  }
  
  public void setHouseBankID(String houseBankID) {
    this.houseBankID = houseBankID;
  }
  
  public String getHouseBankAccountInternalID() {
    return this.houseBankAccountInternalID;
  }
  
  public void setHouseBankAccountInternalID(String houseBankAccountInternalID) {
    this.houseBankAccountInternalID = houseBankAccountInternalID;
  }
  
  public String getHouseBankCountryCode() {
    return this.houseBankCountryCode;
  }
  
  public void setHouseBankCountryCode(String houseBankCountryCode) {
    this.houseBankCountryCode = houseBankCountryCode;
  }
  
  public String getPrintYN() {
    return this.printYN;
  }
  
  public void setPrintYN(String printYN) {
    this.printYN = printYN;
  }
  
  public String getReversalCashPointReferenceID() {
    return this.reversalCashPointReferenceID;
  }
  
  public void setReversalCashPointReferenceID(String reversalCashPointReferenceID) {
    this.reversalCashPointReferenceID = reversalCashPointReferenceID;
  }
  
  public String getReversalCashPointOfficeReferenceID() {
    return this.reversalCashPointOfficeReferenceID;
  }
  
  public void setReversalCashPointOfficeReferenceID(String reversalCashPointOfficeReferenceID) {
    this.reversalCashPointOfficeReferenceID = reversalCashPointOfficeReferenceID;
  }
  
  public String getReversalPaymentTransactionID() {
    return this.reversalPaymentTransactionID;
  }
  
  public void setReversalPaymentTransactionID(String reversalPaymentTransactionID) {
    this.reversalPaymentTransactionID = reversalPaymentTransactionID;
  }
  
  public String getReversalValueDate() {
    return this.reversalValueDate;
  }
  
  public void setReversalValueDate(String reversalValueDate) {
    this.reversalValueDate = reversalValueDate;
  }
  
  public String getStatusReversal() {
    return this.statusReversal;
  }
  
  public void setStatusReversal(String statusReversal) {
    this.statusReversal = statusReversal;
  }
  
  public String getClosingDocumentAmount() {
    return this.closingDocumentAmount;
  }
  
  public void setClosingDocumentAmount(String closingDocumentAmount) {
    this.closingDocumentAmount = closingDocumentAmount;
  }
  
  public String getSelectionCAorLegacy() {
    return this.selectionCAorLegacy;
  }
  
  public void setSelectionCAorLegacy(String selectionCAorLegacy) {
    this.selectionCAorLegacy = selectionCAorLegacy;
  }
  
  public String getUsuarioOriginador() {
    return this.usuarioOriginador;
  }
  
  public void setUsuarioOriginador(String usuarioOriginador) {
    this.usuarioOriginador = usuarioOriginador;
  }
  
  public String getUsuarioCierre() {
    return this.usuarioCierre;
  }
  
  public void setUsuarioCierre(String usuarioCierre) {
    this.usuarioCierre = usuarioCierre;
  }
  
  public String getUsuarioModficador() {
    return this.usuarioModficador;
  }
  
  public void setUsuarioModficador(String usuarioModficador) {
    this.usuarioModficador = usuarioModficador;
  }
  
  public String getFechaOrigen() {
    return this.fechaOrigen;
  }
  
  public void setFechaOrigen(String fechaOrigen) {
    this.fechaOrigen = fechaOrigen;
  }
  
  public String getFechaCierre() {
    return this.fechaCierre;
  }
  
  public void setFechaCierre(String fechaCierre) {
    this.fechaCierre = fechaCierre;
  }
  
  public String getFechaModificada() {
    return this.fechaModificada;
  }
  
  public void setFechaModificada(String fechaModificada) {
    this.fechaModificada = fechaModificada;
  }
  
  public String getStatusPayment() {
    return this.StatusPayment;
  }
  
  public void setStatusPayment(String StatusPayment) {
    this.StatusPayment = StatusPayment;
  }
  
  public String getMsgError() {
    return this.msgError;
  }
  
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }
  
  public String getRefUsuario1() {
    return this.refUsuario1;
  }
  
  public void setRefUsuario1(String refUsuario1) {
    this.refUsuario1 = refUsuario1;
  }
  
  public String getRefUsuario2() {
    return this.refUsuario2;
  }
  
  public void setRefUsuario2(String refUsuario2) {
    this.refUsuario2 = refUsuario2;
  }
  
  public String getRefUsuario3() {
    return this.refUsuario3;
  }
  
  public void setRefUsuario3(String refUsuario3) {
    this.refUsuario3 = refUsuario3;
  }
  
  public String getRefUsuario4() {
    return this.refUsuario4;
  }
  
  public void setRefUsuario4(String refUsuario4) {
    this.refUsuario4 = refUsuario4;
  }
  
  public String getNamePayment() {
    return this.namePayment;
  }
  
  public void setNamePayment(String namePayment) {
    this.namePayment = namePayment;
  }
  
  public String getCodigoEmpresa() {
    return this.codigoEmpresa;
  }
  
  public void setCodigoEmpresa(String codigoEmpresa) {
    this.codigoEmpresa = codigoEmpresa;
  }
  
  public String getAreaNegocio() {
    return this.areaNegocio;
  }
  
  public void setAreaNegocio(String areaNegocio) {
    this.areaNegocio = areaNegocio;
  }
  
  public String getRol() {
    return this.rol;
  }
  
  public void setRol(String rol) {
    this.rol = rol;
  }
  
  public String getIdentificadorFiscal() {
    return this.identificadorFiscal;
  }
  
  public void setIdentificadorFiscal(String identificadorFiscal) {
    this.identificadorFiscal = identificadorFiscal;
  }
  
  public String getRazonSocial() {
    return this.razonSocial;
  }
  
  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }
  
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getCorreo() {
    return this.correo;
  }
  
  public void setCorreo(String correo) {
    this.correo = correo;
  }
}
