package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA para la entidad T0711z1 con la consulta: "SELECT szTransaccionID,
 * iComputerID, szDocEmpresa, szDocType, mnDocDocument, mnSequence,
 * mnSubSequence, szTypeOperation, szID, szCreationDateTime,
 * szCashPointReferenceID, szCashPointOfficeReferenceID,
 * szCashPointPaymentGroupReferenceID, szPaymentTransactionID, mnPaymentAmount,
 * jdValueDate, szItemText, szPayerContractAccountID, szChequeID, szHouseBankID,
 * szHouseBankAccountInternalID, szHouseBankCountryCode, szPrintYN,
 * szReversalCashPointReferenceID, szReversalCashPointOfficeReferenceID,
 * szReversalPaymentTransactionID, szReversalValueDate, szStatusReversal,
 * mnClosingDocumentAmount, szUsuarioOriginador, szUsuarioCierre,
 * szUsuarioModficador, jdFechaOrigen, jdFechaCierre, jdFechaModificador,
 * szStatusPayment, szMsgError, szRefUsuario1, szRefUsuario2, szRefUsuario3,
 * szRefUsuario4, szNamePayment, szCodigoEmpresa, szAreaNegocio, szRol,
 * szSelectionCAorLegacy, szIdentificadorFiscal, szRazonSocial, szDireccion,
 * szTelefono, szCorreo, szCuentaActiva, szNumeroMedidor, szDireccionServicio,
 * szDirDistrCant, szValConsumoKWh, szLecturaActual, szClienteHorario,
 * szMesesPendientes, szMontoEnergia, szUnidadCalc, szUnidadConv,
 * szMontoSubsidios, szMontoComerc, szMontoAlumbrado, szTotalSEyAP,
 * szTotalPendientes, szMontoBomberos, szMontoBasura, szTotalTerceros,
 * szTotalElectricidad, szTotalPagar, szMontoCoccionElect, szMontoCalentAgua,
 * szMontoTarifaElectrica, szMontoTarifaDignidad FROM t0711z1;"
 * 
 * Y la llave primera esta compuesta por szTransaccionID, iComputerID,
 * szDocEmpresa, szDocType, mnDocDocument, mnSequence, mnSubSequence y
 * szTypeOperation.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */

@Getter
@Setter
@Entity
@Table(name = "T0711z1")
public class T0711z1 implements Serializable {

    @EmbeddedId
    private T0711z1Pk id;

    @Column(name = "szID", length = 50)
    private String szID;

    @Column(name = "szCreationDateTime", length = 100)
    private String szCreationDateTime;

    @Column(name = "szCashPointReferenceID", length = 100)
    private String szCashPointReferenceID;

    @Column(name = "szCashPointOfficeReferenceID", length = 100)
    private String szCashPointOfficeReferenceID;

    @Column(name = "szCashPointPaymentGroupReferenceID", length = 100)
    private String szCashPointPaymentGroupReferenceID;

    @Column(name = "szPaymentTransactionID", length = 100)
    private String szPaymentTransactionID;

    @Column(name = "mnPaymentAmount", length = 100)
    private BigDecimal mnPaymentAmount;

    @Column(name = "jdValueDate", length = 100)
    private Date jdValueDate;

    @Column(name = "szItemText", length = 100)
    private String szItemText;

    @Column(name = "szPayerContractAccountID", length = 100)
    private String szPayerContractAccountID;

    @Column(name = "szChequeID", length = 100)
    private String szChequeID;

    @Column(name = "szHouseBankID", length = 100)
    private String szHouseBankID;

    @Column(name = "szHouseBankAccountInternalID", length = 100)
    private String szHouseBankAccountInternalID;

    @Column(name = "szHouseBankCountryCode", length = 100)
    private String szHouseBankCountryCode;

    @Column(name = "szPrintYN", length = 3)
    private String szPrintYN;

    @Column(name = "szReversalCashPointReferenceID", length = 100)
    private String szReversalCashPointReferenceID;

    @Column(name = "szReversalCashPointOfficeReferenceID", length = 100)
    private String szReversalCashPointOfficeReferenceID;

    @Column(name = "szReversalPaymentTransactionID", length = 100)
    private String szReversalPaymentTransactionID;

    @Column(name = "szReversalValueDate")
    private Date szReversalValueDate;

    @Column(name = "szStatusReversal", length = 3)
    private String szStatusReversal;

    @Column(name = "mnClosingDocumentAmount")
    private double mnClosingDocumentAmount;

    @Column(name = "szUsuarioOriginador", length = 50)
    private String szUsuarioOriginador;

    @Column(name = "szUsuarioCierre", length = 50)
    private String szUsuarioCierre;

    @Column(name = "szUsuarioModficador", length = 50)
    private String szUsuarioModficador;

    @Column(name = "jdFechaOrigen")
    private Date jdFechaOrigen;

    @Column(name = "jdFechaCierre")
    private Date jdFechaCierre;

    @Column(name = "jdFechaModificador")
    private Date jdFechaModificador;

    @Column(name = "szStatusPayment", length = 3)
    private String szStatusPayment;

    @Column(name = "szMsgError", length = 200)
    private String szMsgError;

    @Column(name = "szRefUsuario1", length = 200)
    private String szRefUsuario1;

    @Column(name = "szRefUsuario2", length = 200)
    private String szRefUsuario2;

    @Column(name = "szRefUsuario3", length = 200)
    private String szRefUsuario3;

    @Column(name = "szRefUsuario4", length = 200)
    private String szRefUsuario4;

    @Column(name = "szNamePayment", length = 100)
    private String szNamePayment;

    @Column(name = "szCodigoEmpresa", length = 10)
    private String szCodigoEmpresa;

    @Column(name = "szAreaNegocio", length = 10)
    private String szAreaNegocio;

    @Column(name = "szRol", length = 50)
    private String szRol;

    @Column(name = "szSelectionCAorLegacy", length = 30)
    private String szSelectionCAorLegacy;

    @Column(name = "szIdentificadorFiscal", length = 20)
    private String szIdentificadorFiscal;

    @Column(name = "szRazonSocial", length = 15)
    private String szRazonSocial;

    @Column(name = "szDireccion", length = 200)
    private String szDireccion;

    @Column(name = "szTelefono", length = 50)
    private String szTelefono;

    @Column(name = "szCorreo", length = 50)
    private String szCorreo;

    @Column(name = "szCuentaActiva", length = 100)
    private String szCuentaActiva;

    @Column(name = "szNumeroMedidor", length = 100)
    private String szNumeroMedidor;

    @Column(name = "szDireccionServicio", length = 200)
    private String szDireccionServicio;

    @Column(name = "szDirDistrCant", length = 200)
    private String szDirDistrCant;

    @Column(name = "szValConsumoKWh", length = 100)
    private String szValConsumoKWh;

    @Column(name = "szLecturaActual", length = 100)
    private String szLecturaActual;

    @Column(name = "szClienteHorario", length = 100)
    private String szClienteHorario;

    @Column(name = "szMesesPendientes", length = 100)
    private String szMesesPendientes;

    @Column(name = "szMontoEnergia", length = 100)
    private String szMontoEnergia;

    @Column(name = "szUnidadCalc", length = 100)
    private String szUnidadCalc;

    @Column(name = "szUnidadConv", length = 100)
    private String szUnidadConv;

    @Column(name = "szMontoSubsidios", length = 100)
    private String szMontoSubsidios;

    @Column(name = "szMontoComerc", length = 100)
    private String szMontoComerc;

    @Column(name = "szMontoAlumbrado", length = 100)
    private String szMontoAlumbrado;

    @Column(name = "szTotalSEyAP", length = 100)
    private String szTotalSEyAP;

    @Column(name = "szTotalPendientes", length = 100)
    private String szTotalPendientes;

    @Column(name = "szMontoBomberos", length = 100)
    private String szMontoBomberos;

    @Column(name = "szMontoBasura", length = 100)
    private String szMontoBasura;

    @Column(name = "szTotalTerceros", length = 100)
    private String szTotalTerceros;

    @Column(name = "szTotalElectricidad", length = 100)
    private String szTotalElectricidad;

    @Column(name = "szTotalPagar", length = 100)
    private String szTotalPagar;

    @Column(name = "szMontoCoccionElect", length = 100)
    private String szMontoCoccionElect;

    @Column(name = "szMontoCalentAgua", length = 100)
    private String szMontoCalentAgua;

    @Column(name = "szMontoTarifaElectrica", length = 100)
    private String szMontoTarifaElectrica;

    @Column(name = "szMontoTarifaDignidad", length = 100)
    private String szMontoTarifaDignidad;
}
