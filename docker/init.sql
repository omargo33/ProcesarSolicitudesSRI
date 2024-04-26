/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.6.17-MariaDB-cll-lve : Database - dveloper_catalina
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dveloper_catalina` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;

USE `dveloper_catalina`;

/*Table structure for table `resumenDocumentosProveedores` */

DROP TABLE IF EXISTS `resumenDocumentosProveedores`;

CREATE TABLE `resumenDocumentosProveedores` (
  `access_key` varchar(255) NOT NULL,
  `document_id` int(11) DEFAULT NULL,
  `ruc_issuer` varchar(255) DEFAULT NULL,
  `commercial_name` varchar(255) DEFAULT NULL,
  `social_name_issuer` varchar(255) DEFAULT NULL,
  `issued_at` varchar(255) DEFAULT NULL,
  `establishment` varchar(255) DEFAULT NULL,
  `point_issue` varchar(255) DEFAULT NULL,
  `sequence` varchar(255) DEFAULT NULL,
  `document_type` varchar(255) DEFAULT NULL,
  `document_type_id` int(11) DEFAULT NULL,
  `issued_at_formatted` varchar(255) DEFAULT NULL,
  `total_value_without_taxes` decimal(10,2) DEFAULT NULL,
  `tip` decimal(10,2) DEFAULT NULL,
  `total_discount` decimal(10,2) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `taxpayer_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`access_key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0005` */

DROP TABLE IF EXISTS `t0005`;

CREATE TABLE `t0005` (
  `szModulo` varchar(10) NOT NULL,
  `szConstante` varchar(10) NOT NULL,
  `szCodigoDefinidoUsuario` varchar(10) NOT NULL,
  `szDescripcion` varchar(200) NOT NULL,
  `szDescripcion02` varchar(200) DEFAULT NULL,
  `szUsoEspecial` varchar(15) DEFAULT NULL,
  `szHardCode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`szModulo`,`szConstante`,`szCodigoDefinidoUsuario`,`szDescripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0006` */

DROP TABLE IF EXISTS `t0006`;

CREATE TABLE `t0006` (
  `szUnidadNegocio` varchar(20) NOT NULL,
  `szDescripcion` varchar(40) DEFAULT NULL,
  `szTipo` varchar(3) DEFAULT NULL,
  `szEmpresa` varchar(5) DEFAULT NULL,
  `szDireccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szUnidadNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t0014` */

DROP TABLE IF EXISTS `t0014`;

CREATE TABLE `t0014` (
  `terminoPago` varchar(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `referenciaCiclica` int(3) DEFAULT NULL,
  `iteracion` int(3) DEFAULT NULL,
  `diasGracia` int(3) DEFAULT NULL,
  PRIMARY KEY (`terminoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0022` */

DROP TABLE IF EXISTS `t0022`;

CREATE TABLE `t0022` (
  `szCompany` varchar(5) NOT NULL,
  `szTypeDoc` varchar(3) NOT NULL,
  `mnPeriodoFiscal` int(4) NOT NULL,
  `szDescripcion` varchar(70) DEFAULT NULL,
  `mnNextNumber` int(8) DEFAULT NULL,
  PRIMARY KEY (`szCompany`,`szTypeDoc`,`mnPeriodoFiscal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t00221` */

DROP TABLE IF EXISTS `t00221`;

CREATE TABLE `t00221` (
  `szObjeto` varchar(10) NOT NULL,
  `mnNextNumber` int(9) DEFAULT NULL,
  PRIMARY KEY (`szObjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0030` */

DROP TABLE IF EXISTS `t0030`;

CREATE TABLE `t0030` (
  `szMandante` varchar(10) NOT NULL,
  `szPaisBanco` varchar(3) NOT NULL,
  `szClaveBanco` varchar(15) NOT NULL,
  `szDescripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`szMandante`,`szPaisBanco`,`szClaveBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t0101` */

DROP TABLE IF EXISTS `t0101`;

CREATE TABLE `t0101` (
  `mnNroDireccion` int(8) NOT NULL,
  `szRazonSocial` varchar(1000) DEFAULT NULL,
  `szNombreApellido` varchar(1000) DEFAULT NULL,
  `szIdentificadorFiscal` varchar(20) DEFAULT NULL,
  `szTipoIdentificacion` varchar(10) DEFAULT NULL,
  `szDireccion1` varchar(1000) DEFAULT NULL,
  `szDireccion2` varchar(1000) DEFAULT NULL,
  `szCorreo` varchar(100) DEFAULT NULL,
  `szDominioCorreo` varchar(100) DEFAULT NULL,
  `szTelfCas` varchar(20) DEFAULT NULL,
  `szTelfOfi` varchar(20) DEFAULT NULL,
  `szCel` varchar(20) DEFAULT NULL,
  `szTipoPersona` varchar(5) DEFAULT NULL,
  `mnCreditoVencido` double DEFAULT 0,
  `mnMaximoCredito` double DEFAULT 0,
  `szNickName` varchar(70) DEFAULT NULL,
  `mnSecuenciaOrdenamiento` int(4) DEFAULT NULL,
  `jdFechaNacimiento` date DEFAULT NULL,
  `szGenero` varchar(30) DEFAULT NULL,
  `szCatLd01` varchar(10) DEFAULT NULL,
  `szCatLd02` varchar(10) DEFAULT NULL,
  `szCatLd03` varchar(10) DEFAULT NULL,
  `szCatLd04` varchar(10) DEFAULT NULL,
  `szCatLd05` varchar(10) DEFAULT NULL,
  `szCatLd06` varchar(10) DEFAULT NULL,
  `szCatLd07` varchar(10) DEFAULT NULL,
  `szCatLd08` varchar(10) DEFAULT NULL,
  `szCatLd09` varchar(10) DEFAULT NULL,
  `szCatLd10` varchar(10) DEFAULT NULL,
  `szUsuario` varchar(50) DEFAULT NULL,
  `szEstacionTrabajo` varchar(60) DEFAULT NULL,
  `jdFechaTrans` date DEFAULT NULL,
  `mnTiempoTrans` time DEFAULT NULL,
  `szCompensacionLM` varchar(50) DEFAULT NULL,
  `szExplicacionFiscal` varchar(50) DEFAULT NULL,
  `szCuentaContableDefecto` varchar(100) DEFAULT NULL,
  `szTipoContribuyente` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mnNroDireccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0101rt` */

DROP TABLE IF EXISTS `t0101rt`;

CREATE TABLE `t0101rt` (
  `mnNroDireccion` int(8) NOT NULL,
  `codigoRetencionDefinidoUsuario` varchar(50) NOT NULL,
  `descripcion` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`mnNroDireccion`,`codigoRetencionDefinidoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t03012` */

DROP TABLE IF EXISTS `t03012`;

CREATE TABLE `t03012` (
  `nroDireccion` int(8) NOT NULL,
  `compania` varchar(5) NOT NULL,
  `cupoCredito` double(15,2) DEFAULT NULL,
  `cupoGastado` double(15,2) DEFAULT NULL,
  `terminoPago` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nroDireccion`,`compania`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t03b11` */

DROP TABLE IF EXISTS `t03b11`;

CREATE TABLE `t03b11` (
  `nroDoc` int(8) NOT NULL,
  `tipoDoc` varchar(3) NOT NULL,
  `companiaDoc` varchar(5) NOT NULL,
  `nroLinea` int(8) NOT NULL,
  `fechaFactura` date DEFAULT NULL,
  `fechaVencimiento` date DEFAULT NULL,
  `nroDireccion` int(8) DEFAULT NULL,
  `fiscalYear` int(11) DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `siglo` int(11) DEFAULT NULL,
  `accountID` int(10) DEFAULT NULL,
  `cuentaContable` varchar(30) DEFAULT NULL,
  `moneda` varchar(15) DEFAULT NULL,
  `importeCobrado` double(15,2) DEFAULT NULL,
  `importePagado` double(15,2) DEFAULT NULL,
  `importePendiente` double(15,2) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `horaTrans` time DEFAULT NULL,
  `usuarioTrans` varchar(50) DEFAULT NULL,
  `estacionTrans` varchar(50) DEFAULT NULL,
  `referencia` varchar(300) DEFAULT NULL,
  `referenciaLegal` varchar(30) DEFAULT NULL,
  `comprobanteControladoYN` varchar(10) DEFAULT NULL,
  `fechaAnulacion` date DEFAULT NULL,
  `razonAnulacion` varchar(100) DEFAULT NULL,
  `nroDocRelacionado` int(8) DEFAULT NULL,
  `tipoDocRelacionado` varchar(3) DEFAULT NULL,
  `companiaDocRelacionado` varchar(5) DEFAULT NULL,
  `nroLineaRelacionado` int(8) DEFAULT NULL,
  `nroLegalRelacionado` varchar(50) DEFAULT NULL,
  `nroAutorizacion` varchar(100) DEFAULT NULL,
  `explicacionAdicional` varchar(500) DEFAULT NULL,
  `fechaSustentoRelacionado` date DEFAULT NULL,
  `tipoOperacionRelacionado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nroDoc`,`tipoDoc`,`companiaDoc`,`nroLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t03b13` */

DROP TABLE IF EXISTS `t03b13`;

CREATE TABLE `t03b13` (
  `nroTrabajo` int(8) NOT NULL,
  `instrumentoPago` varchar(10) DEFAULT NULL,
  `montoPago` double(15,2) DEFAULT NULL,
  `accountID` int(10) DEFAULT NULL,
  `cuentaContable` varchar(30) DEFAULT NULL,
  `explicacionPago` varchar(200) DEFAULT NULL,
  `nroDireccion` int(8) DEFAULT NULL,
  `fechaEmision` date DEFAULT NULL,
  `nroDoc` int(8) DEFAULT NULL,
  `tipoDoc` varchar(3) DEFAULT NULL,
  `companiaDoc` varchar(5) DEFAULT NULL,
  `nroDocInv` int(8) DEFAULT NULL,
  `tipoDocInv` varchar(3) DEFAULT NULL,
  `companiaDocInv` varchar(5) DEFAULT NULL,
  `nroLinea` int(8) DEFAULT NULL,
  `referenciaPago` varchar(200) DEFAULT NULL,
  `usuarioOriginado` varchar(50) DEFAULT NULL,
  `usuarioTrans` varchar(50) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `horaTrans` time NOT NULL,
  `estacionTrans` varchar(100) DEFAULT NULL,
  `fechaAnulacion` date DEFAULT NULL,
  `razonAnulacion` varchar(200) DEFAULT NULL,
  `estadoAnulacion` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nroTrabajo`,`horaTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0411z1` */

DROP TABLE IF EXISTS `t0411z1`;

CREATE TABLE `t0411z1` (
  `mnNumDocumentoEDI` int(8) NOT NULL,
  `szTipoDocumentoEDI` varchar(3) NOT NULL,
  `szCompanyEDI` varchar(5) NOT NULL,
  `mnItemPayEDI` int(4) NOT NULL,
  `szNroFactura` varchar(20) DEFAULT NULL,
  `jFechaEmision` date DEFAULT NULL,
  `jFechaAutorizacion` date DEFAULT NULL,
  `mnNroDireccion` int(9) DEFAULT NULL,
  `szIdFiscalContribuyente` varchar(20) DEFAULT NULL,
  `szRazonSocialContribuyente` varchar(1000) DEFAULT NULL,
  `szDirMatrizContribuyente` varchar(1000) DEFAULT NULL,
  `szDirSucursalContribuyente` varchar(1000) DEFAULT NULL,
  `mnFiscalYear` int(3) DEFAULT NULL,
  `mnPeriodo` int(3) DEFAULT NULL,
  `szCodPost` varchar(3) DEFAULT NULL,
  `mnValorBruto` decimal(15,2) DEFAULT NULL,
  `mnSubTotal` double(15,2) DEFAULT NULL,
  `mnDescuento` double(15,2) DEFAULT NULL,
  `mnBase0` double(15,2) DEFAULT NULL,
  `mnBase12` double(15,2) DEFAULT NULL,
  `mnNoObjetoIVA` double(15,2) DEFAULT NULL,
  `mnImpuesto` double(15,2) DEFAULT NULL,
  `mnImporteCobrado` double(15,2) DEFAULT NULL,
  `mnImportePendiente` double(15,2) DEFAULT NULL,
  `szTipoEmision` varchar(20) DEFAULT NULL,
  `szClaveAcceso` varchar(70) DEFAULT NULL,
  `szAutElectronica` varchar(70) DEFAULT NULL,
  `mnNumDocumentoRela` varchar(100) DEFAULT NULL,
  `szTipoDocumentoRela` varchar(100) DEFAULT NULL,
  `szCompanyRela` varchar(100) DEFAULT NULL,
  `jDateUpdate` date DEFAULT NULL,
  `jDateCancel` date DEFAULT NULL,
  `szCodeCancel` varchar(3) DEFAULT NULL,
  `szDescCancel` varchar(200) DEFAULT NULL,
  `szUserCancel` varchar(50) DEFAULT NULL,
  `mnCuentaContable` int(8) DEFAULT NULL,
  `jFechaAutElectronica` varchar(50) DEFAULT NULL,
  `mnBachNumberEDI` int(8) DEFAULT NULL,
  `szUserEDI` varchar(50) DEFAULT NULL,
  `jDateUpdateEDI` date DEFAULT NULL,
  `mnTiempoEDI` time DEFAULT NULL,
  `szTipoIdentificadorComp` varchar(10) DEFAULT NULL,
  `szRazonSocialComp` varchar(100) DEFAULT NULL,
  `szIdFiscalComp` varchar(20) DEFAULT NULL,
  `szRise` varchar(20) DEFAULT NULL,
  `szMoneda` varchar(20) DEFAULT NULL,
  `szCategoria01` varchar(30) DEFAULT NULL,
  `szCategoria02` varchar(30) DEFAULT NULL,
  `szCategoria03` varchar(30) DEFAULT NULL,
  `szCategoria04` varchar(30) DEFAULT NULL,
  `szCategoria05` varchar(30) DEFAULT NULL,
  `szPathPDF` varchar(500) DEFAULT NULL,
  `szPathXML` varchar(500) DEFAULT NULL,
  `mnCodigoCorto` int(8) DEFAULT NULL,
  `szCodigoLargo` varchar(30) DEFAULT NULL,
  `szSegundoCodigoLargo` varchar(30) DEFAULT NULL,
  `szDescripcion01` varchar(300) DEFAULT NULL,
  `szDescripcion02` varchar(300) DEFAULT NULL,
  `szExplicacionFiscal` varchar(50) DEFAULT NULL,
  `szCompensacionLM` varchar(50) DEFAULT NULL,
  `szAreaFiscal` varchar(50) DEFAULT NULL,
  `szCondicionPago` varchar(10) DEFAULT NULL,
  `jFechaLM` date DEFAULT NULL,
  `szObservacion01` varchar(500) DEFAULT NULL,
  `szObservacion02` varchar(500) DEFAULT NULL,
  `jFechaComprobante` date DEFAULT NULL,
  `szEstablecimiento` varchar(10) DEFAULT NULL,
  `szPuntoEmision` varchar(10) DEFAULT NULL,
  `mnSecuencial` int(11) DEFAULT NULL,
  `nroAutorizacionComprobante` varchar(100) DEFAULT NULL,
  `jFechaCaducidad` date DEFAULT NULL,
  `szDevolucionIva` varchar(50) DEFAULT NULL,
  `mnCantidad` double(15,4) DEFAULT NULL,
  `mnPrecio` double(15,4) DEFAULT NULL,
  `mnCostoCompra` double(15,4) DEFAULT NULL,
  PRIMARY KEY (`mnNumDocumentoEDI`,`szTipoDocumentoEDI`,`szCompanyEDI`,`mnItemPayEDI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0711z1` */

DROP TABLE IF EXISTS `t0711z1`;

CREATE TABLE `t0711z1` (
  `szTransaccionID` int(11) NOT NULL,
  `iComputerID` varchar(45) NOT NULL,
  `szDocEmpresa` varchar(45) NOT NULL,
  `szDocType` varchar(45) NOT NULL,
  `mnDocDocument` int(11) NOT NULL,
  `mnSequence` int(11) NOT NULL,
  `mnSubSequence` int(11) NOT NULL,
  `szTypeOperation` varchar(3) NOT NULL,
  `szID` varchar(50) DEFAULT NULL,
  `szCreationDateTime` varchar(100) DEFAULT NULL,
  `szCashPointReferenceID` varchar(100) DEFAULT NULL,
  `szCashPointOfficeReferenceID` varchar(100) DEFAULT NULL,
  `szCashPointPaymentGroupReferenceID` varchar(100) DEFAULT NULL,
  `szPaymentTransactionID` varchar(100) DEFAULT NULL,
  `mnPaymentAmount` double(15,2) DEFAULT NULL,
  `jdValueDate` date DEFAULT NULL,
  `szItemText` varchar(100) DEFAULT NULL,
  `szPayerContractAccountID` varchar(100) DEFAULT NULL,
  `szChequeID` varchar(100) DEFAULT NULL,
  `szHouseBankID` varchar(100) DEFAULT NULL,
  `szHouseBankAccountInternalID` varchar(100) DEFAULT NULL,
  `szHouseBankCountryCode` varchar(100) DEFAULT NULL,
  `szPrintYN` varchar(3) DEFAULT NULL,
  `szReversalCashPointReferenceID` varchar(100) DEFAULT NULL,
  `szReversalCashPointOfficeReferenceID` varchar(100) DEFAULT NULL,
  `szReversalPaymentTransactionID` varchar(100) DEFAULT NULL,
  `szReversalValueDate` date DEFAULT NULL,
  `szStatusReversal` varchar(3) DEFAULT NULL,
  `mnClosingDocumentAmount` double(15,2) DEFAULT NULL,
  `szUsuarioOriginador` varchar(50) DEFAULT NULL,
  `szUsuarioCierre` varchar(50) DEFAULT NULL,
  `szUsuarioModficador` varchar(50) DEFAULT NULL,
  `jdFechaOrigen` date DEFAULT NULL,
  `jdFechaCierre` date DEFAULT NULL,
  `jdFechaModificador` date DEFAULT NULL,
  `szStatusPayment` varchar(3) DEFAULT NULL,
  `szMsgError` varchar(200) DEFAULT NULL,
  `szRefUsuario1` varchar(200) DEFAULT NULL,
  `szRefUsuario2` varchar(200) DEFAULT NULL,
  `szRefUsuario3` varchar(200) DEFAULT NULL,
  `szRefUsuario4` varchar(200) DEFAULT NULL,
  `szNamePayment` varchar(100) DEFAULT NULL,
  `szCodigoEmpresa` varchar(10) DEFAULT NULL,
  `szAreaNegocio` varchar(10) DEFAULT NULL,
  `szRol` varchar(50) DEFAULT NULL,
  `szSelectionCAorLegacy` varchar(30) DEFAULT NULL,
  `szIdentificadorFiscal` varchar(20) DEFAULT NULL,
  `szRazonSocial` varchar(150) DEFAULT NULL,
  `szDireccion` varchar(200) DEFAULT NULL,
  `szTelefono` varchar(50) DEFAULT NULL,
  `szCorreo` varchar(50) DEFAULT NULL,
  `szCuentaActiva` varchar(100) DEFAULT NULL,
  `szNumeroMedidor` varchar(100) DEFAULT NULL,
  `szDireccionServicio` varchar(200) DEFAULT NULL,
  `szDirDistrCant` varchar(200) DEFAULT NULL,
  `szValConsumoKWh` varchar(100) DEFAULT NULL,
  `szLecturaActual` varchar(100) DEFAULT NULL,
  `szClienteHorario` varchar(100) DEFAULT NULL,
  `szMesesPendientes` varchar(100) DEFAULT NULL,
  `szMontoEnergia` varchar(100) DEFAULT NULL,
  `szUnidadCalc` varchar(100) DEFAULT NULL,
  `szUnidadConv` varchar(100) DEFAULT NULL,
  `szMontoSubsidios` varchar(100) DEFAULT NULL,
  `szMontoComerc` varchar(100) DEFAULT NULL,
  `szMontoAlumbrado` varchar(100) DEFAULT NULL,
  `szTotalSEyAP` varchar(100) DEFAULT NULL,
  `szTotalPendientes` varchar(100) DEFAULT NULL,
  `szMontoBomberos` varchar(100) DEFAULT NULL,
  `szMontoBasura` varchar(100) DEFAULT NULL,
  `szTotalTerceros` varchar(100) DEFAULT NULL,
  `szTotalElectricidad` varchar(100) DEFAULT NULL,
  `szTotalPagar` varchar(100) DEFAULT NULL,
  `szMontoCoccionElect` varchar(100) DEFAULT NULL,
  `szMontoCalentAgua` varchar(100) DEFAULT NULL,
  `szMontoTarifaElectrica` varchar(100) DEFAULT NULL,
  `szMontoTarifaDignidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szTransaccionID`,`iComputerID`,`szDocEmpresa`,`szDocType`,`mnDocDocument`,`mnSequence`,`mnSubSequence`,`szTypeOperation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079801` */

DROP TABLE IF EXISTS `t079801`;

CREATE TABLE `t079801` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `jdFechaVigencia` date NOT NULL,
  `jdFechaCaducidad` date NOT NULL,
  `szEstado` varchar(10) DEFAULT NULL,
  `szNroAutorizacionEmision` varchar(50) DEFAULT NULL,
  `szTipoEmision` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`,`jdFechaVigencia`,`jdFechaCaducidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t079802` */

DROP TABLE IF EXISTS `t079802`;

CREATE TABLE `t079802` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `szUnidadNegocioEst` varchar(45) NOT NULL,
  `szCodOficina` varchar(3) NOT NULL,
  `szTipoOficina` varchar(3) DEFAULT NULL,
  `szCodOficinaInterna` varchar(100) DEFAULT NULL,
  `szCodOficinaExtenra` varchar(100) DEFAULT NULL,
  `szDireccionSucursal` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`,`szCodOficina`,`szUnidadNegocioEst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079803` */

DROP TABLE IF EXISTS `t079803`;

CREATE TABLE `t079803` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `szUnidadNegocio` varchar(45) NOT NULL,
  `szCodOficina` varchar(3) NOT NULL,
  `szCodCaja` varchar(3) NOT NULL,
  `szCodCajaInterna` varchar(100) DEFAULT NULL,
  `szCodCajaExterna` varchar(100) DEFAULT NULL,
  `szEstadoYN` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`,`szCodOficina`,`szCodCaja`,`szUnidadNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079804` */

DROP TABLE IF EXISTS `t079804`;

CREATE TABLE `t079804` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `szUnidadNegocio` varchar(45) NOT NULL,
  `szCodOficina` varchar(20) NOT NULL,
  `szCodCaja` varchar(20) NOT NULL,
  `jdFechaEmision` date NOT NULL,
  `szDocType` varchar(3) NOT NULL,
  `iSeqInicial` int(11) DEFAULT NULL,
  `iSeqFinal` int(11) DEFAULT NULL,
  `szCierreCaja` varchar(60) DEFAULT NULL,
  `iDocNumber` int(9) DEFAULT NULL,
  `szTypeDoc` varchar(3) DEFAULT NULL,
  `szCompanyDoc` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`,`szCodOficina`,`szCodCaja`,`jdFechaEmision`,`szDocType`,`szUnidadNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079805` */

DROP TABLE IF EXISTS `t079805`;

CREATE TABLE `t079805` (
  `szRol` varchar(100) NOT NULL,
  `szUnidadNegocio` varchar(45) DEFAULT NULL,
  `szCodOficina` varchar(45) DEFAULT NULL,
  `szCodCaja` varchar(45) DEFAULT NULL,
  `szTipoEmision` varchar(10) NOT NULL,
  PRIMARY KEY (`szRol`,`szTipoEmision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079810` */

DROP TABLE IF EXISTS `t079810`;

CREATE TABLE `t079810` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `szIdentificacionFiscal` varchar(20) DEFAULT NULL,
  `szRazonSocial` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t079810a` */

DROP TABLE IF EXISTS `t079810a`;

CREATE TABLE `t079810a` (
  `szCodEmpresa` varchar(5) NOT NULL,
  `cuentaUsuario` varchar(100) DEFAULT NULL,
  `credencialUsuario` varchar(100) DEFAULT NULL,
  `from` varchar(100) DEFAULT NULL,
  `host` varchar(100) DEFAULT NULL,
  `puerto` varchar(50) DEFAULT NULL,
  `cuentaCorreo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szCodEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0901` */

DROP TABLE IF EXISTS `t0901`;

CREATE TABLE `t0901` (
  `Company` varchar(5) DEFAULT NULL,
  `AccountID` int(10) NOT NULL,
  `BusinessUnit` varchar(12) DEFAULT NULL,
  `ObjectAccount` varchar(6) DEFAULT NULL,
  `Subsidiary` varchar(8) DEFAULT NULL,
  `AccountNumber3rd` varchar(25) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `AccountLevelofDetail` varchar(2) DEFAULT NULL,
  `BillableYN` varbinary(2) DEFAULT NULL,
  `CurrencyCodeFrom` varchar(3) DEFAULT NULL,
  `CategoryCode01` varchar(3) DEFAULT NULL,
  `CategoryCode02` varchar(3) DEFAULT NULL,
  `CategoryCode03` varchar(3) DEFAULT NULL,
  `CategoryCode04` varchar(3) DEFAULT NULL,
  `CategoryCode05` varchar(3) DEFAULT NULL,
  `CategoryCode06` varchar(3) DEFAULT NULL,
  `CategoryCode07` varchar(3) DEFAULT NULL,
  `CategoryCode08` varchar(3) DEFAULT NULL,
  `CategoryCode09` varchar(3) DEFAULT NULL,
  `CategoryCode10` varchar(3) DEFAULT NULL,
  `ObjectAccountAlternate` varchar(6) DEFAULT NULL,
  `SubsidiaryAlternate` varchar(8) DEFAULT NULL,
  `TaxRateArea` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t0911` */

DROP TABLE IF EXISTS `t0911`;

CREATE TABLE `t0911` (
  `DocumentCompany` varchar(5) DEFAULT NULL,
  `DocumentType` varchar(3) DEFAULT NULL,
  `DocumentVoucher` int(8) DEFAULT NULL,
  `DateVoucher` date DEFAULT NULL,
  `JournalEntryLineNumber` int(6) DEFAULT NULL,
  `LineExtensionCode` int(6) DEFAULT NULL,
  `PostedCode` varchar(5) DEFAULT NULL,
  `BatchNumber` int(8) DEFAULT NULL,
  `BatchType` varchar(3) DEFAULT NULL,
  `DateBatch` date DEFAULT NULL,
  `DateBatchSystemDate` date DEFAULT NULL,
  `BatchTime` time DEFAULT NULL,
  `AccountNumber` varchar(30) DEFAULT NULL,
  `AccountModeGL` varchar(3) DEFAULT NULL,
  `AccountID` int(10) DEFAULT NULL,
  `BusinessUnit` varchar(12) DEFAULT NULL,
  `ObjectAccount` varchar(6) DEFAULT NULL,
  `Subsidiary` varchar(8) DEFAULT NULL,
  `SubledgerGL` varchar(8) DEFAULT NULL,
  `SubledgerType` varchar(3) DEFAULT NULL,
  `LedgerTypes` varchar(3) DEFAULT NULL,
  `PeriodNumber` int(2) DEFAULT NULL,
  `Century` int(2) DEFAULT NULL,
  `FiscalYear` int(2) DEFAULT NULL,
  `CurrencyCodeFrom` varchar(3) DEFAULT NULL,
  `Amount` double(15,2) DEFAULT NULL,
  `Units` double(15,2) DEFAULT NULL,
  `UnitofMeasure` varchar(3) DEFAULT NULL,
  `ReverseorVoid` varchar(3) DEFAULT NULL,
  `NameAlphaExplanation` varchar(50) DEFAULT NULL,
  `NameRemarkExplanation` varchar(50) DEFAULT NULL,
  `Reference1` varchar(30) DEFAULT NULL,
  `Reference2` varchar(30) DEFAULT NULL,
  `Reference3` varchar(30) DEFAULT NULL,
  `DocumentPayItemAlter` int(6) DEFAULT NULL,
  `DocumentOriginalAlter` int(8) DEFAULT NULL,
  `DocumentTypeOriginalAlter` varchar(3) DEFAULT NULL,
  `DocumentCompanyAlter` varchar(5) DEFAULT NULL,
  `AddressNumber` int(8) DEFAULT NULL,
  `DateInvoice` date DEFAULT NULL,
  `BusinessUnitHome` varchar(12) DEFAULT NULL,
  `UserID` varchar(50) DEFAULT NULL,
  `ProgramID` varchar(50) DEFAULT NULL,
  `WorkStationID` varchar(50) DEFAULT NULL,
  `DateUpdate` date DEFAULT NULL,
  `TimeLastUpdate` time DEFAULT NULL,
  `ItemNumberShort` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4070` */

DROP TABLE IF EXISTS `t4070`;

CREATE TABLE `t4070` (
  `mnNroTransaccion` int(8) NOT NULL,
  `szRegla` varchar(30) DEFAULT NULL,
  `szDescripcionRegla` varchar(300) DEFAULT NULL,
  `szTipoMonto` varchar(3) DEFAULT NULL,
  `mnMonto` double(15,4) DEFAULT NULL,
  `mnCodigoCorto` int(9) DEFAULT NULL,
  `mnBodega` varchar(15) DEFAULT NULL,
  `jdFechaTrans` date DEFAULT NULL,
  `mnTiempoTrans` time DEFAULT NULL,
  `szUsuario` varchar(100) DEFAULT NULL,
  `szEstacionTrabajo` varchar(100) DEFAULT NULL,
  `szEstado` varchar(15) DEFAULT NULL,
  `szAutomatico` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mnNroTransaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4101` */

DROP TABLE IF EXISTS `t4101`;

CREATE TABLE `t4101` (
  `mnCodigoCorto` int(11) NOT NULL,
  `szCodigoLargo` varchar(45) DEFAULT NULL,
  `sz2CodigoLargo` varchar(45) DEFAULT NULL,
  `szDescripcion` varchar(60) DEFAULT NULL,
  `szDescripcion02` varchar(60) DEFAULT NULL,
  `szTextoBusqueda` varchar(100) DEFAULT NULL,
  `szCatInv01` varchar(45) DEFAULT NULL,
  `szCatInv02` varchar(45) DEFAULT NULL,
  `szCatInv03` varchar(45) DEFAULT NULL,
  `szCatInv04` varchar(45) DEFAULT NULL,
  `szCatInv05` varchar(45) DEFAULT NULL,
  `szCatInv06` varchar(45) DEFAULT NULL,
  `szCatInv07` varchar(45) DEFAULT NULL,
  `szCatInv08` varchar(45) DEFAULT NULL,
  `szUnidadMedida` varchar(45) DEFAULT NULL,
  `sz2UnidadMedida` varchar(45) DEFAULT NULL,
  `sz3UnidadMedida` varchar(45) DEFAULT NULL,
  `szUnidadPeso` varchar(45) DEFAULT NULL,
  `szUnidadVolumen` varchar(45) DEFAULT NULL,
  `szCodigoGLPT` varchar(45) DEFAULT NULL,
  `szTipoStock` varchar(45) DEFAULT NULL,
  `szUser` varchar(45) DEFAULT NULL,
  `szWorkStation` varchar(45) DEFAULT NULL,
  `jdDateTransaction` date DEFAULT NULL,
  `mnTime` time DEFAULT NULL,
  `szImpuestos` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mnCodigoCorto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t41012` */

DROP TABLE IF EXISTS `t41012`;

CREATE TABLE `t41012` (
  `nroTransaccion` int(9) NOT NULL AUTO_INCREMENT,
  `codigoCorto` int(8) DEFAULT NULL,
  `unidadMedida` varchar(30) DEFAULT NULL,
  `valor` double(15,4) DEFAULT NULL,
  `unidadMedidaConversion` varchar(30) DEFAULT NULL,
  `valorConversion` double(15,4) DEFAULT NULL,
  PRIMARY KEY (`nroTransaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t41013` */

DROP TABLE IF EXISTS `t41013`;

CREATE TABLE `t41013` (
  `codigoCortoPadre` int(8) NOT NULL,
  `nroLinea` int(8) NOT NULL,
  `codigoCortoHijo` int(8) DEFAULT NULL,
  `cantidadFormulacion` double(15,4) DEFAULT NULL,
  `unidadMedidaFormulacion` varchar(30) DEFAULT NULL,
  `observacion` varchar(300) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `tiempoTrans` time DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `espacioTranbajo` varchar(100) DEFAULT NULL,
  `cantidad` double(15,4) DEFAULT NULL,
  `unidadMedida` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigoCortoPadre`,`nroLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t41019` */

DROP TABLE IF EXISTS `t41019`;

CREATE TABLE `t41019` (
  `nroDocumento` int(9) NOT NULL,
  `tipoDocumento` varchar(2) NOT NULL,
  `empresaDocumento` varchar(5) NOT NULL,
  `nroLineaDocumento` int(9) NOT NULL,
  `codigoCortoPadre` int(9) DEFAULT NULL,
  `cantidadProduccion` double(15,4) DEFAULT NULL,
  `unidadMedidaProduccion` varchar(10) DEFAULT NULL,
  `fechaProduccion` date DEFAULT NULL,
  `fechaEmision` date DEFAULT NULL,
  `nroLinea` int(9) DEFAULT NULL,
  `codigoCortoHijo` int(9) DEFAULT NULL,
  `cantidadFormulacion` double(15,4) DEFAULT NULL,
  `unidadMedidaFormulacion` varchar(10) DEFAULT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `tiempoTrans` time DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `espacioTranbajo` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `cantidadConversion` double(15,4) DEFAULT NULL,
  `unidadMedidaConversion` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nroDocumento`,`tipoDocumento`,`empresaDocumento`,`nroLineaDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4102` */

DROP TABLE IF EXISTS `t4102`;

CREATE TABLE `t4102` (
  `mnCodigoCorto` int(11) NOT NULL,
  `szCodigoLargo` varchar(45) DEFAULT NULL,
  `sz2CodigoLargo` varchar(45) DEFAULT NULL,
  `szDescripcion` varchar(60) DEFAULT NULL,
  `szDescripcion02` varchar(60) DEFAULT NULL,
  `szTextoBusqueda` varchar(100) DEFAULT NULL,
  `szCatInv01` varchar(45) DEFAULT NULL,
  `szCatInv02` varchar(45) DEFAULT NULL,
  `szCatInv03` varchar(45) DEFAULT NULL,
  `szCatInv04` varchar(45) DEFAULT NULL,
  `szCatInv05` varchar(45) DEFAULT NULL,
  `szCatInv06` varchar(45) DEFAULT NULL,
  `szCatInv07` varchar(45) DEFAULT NULL,
  `szCatInv08` varchar(45) DEFAULT NULL,
  `szUnidadMedida` varchar(45) DEFAULT NULL,
  `sz2UnidadMedida` varchar(45) DEFAULT NULL,
  `sz3UnidadMedida` varchar(45) DEFAULT NULL,
  `szUnidadPeso` varchar(45) DEFAULT NULL,
  `szUnidadVolumen` varchar(45) DEFAULT NULL,
  `szCodigoGLPT` varchar(45) DEFAULT NULL,
  `szTipoStock` varchar(45) DEFAULT NULL,
  `szUser` varchar(45) DEFAULT NULL,
  `szWorkStation` varchar(45) DEFAULT NULL,
  `jdDateTransaction` date DEFAULT NULL,
  `mnTime` time DEFAULT NULL,
  `szUnidadNegocio` varchar(12) NOT NULL,
  `szImpuestos` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mnCodigoCorto`,`szUnidadNegocio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t41021` */

DROP TABLE IF EXISTS `t41021`;

CREATE TABLE `t41021` (
  `mnCodigoCorto` int(8) NOT NULL,
  `szUnidadNegocio` varchar(15) NOT NULL,
  `szUbicacion` varchar(15) NOT NULL,
  `szLote` varchar(30) NOT NULL,
  `szCategoriaGL` varchar(30) NOT NULL,
  `jdFechaUltRecep` date DEFAULT NULL,
  `mnCantDisponibleHD` double(15,4) DEFAULT NULL,
  `mnCantBackOrder` double(15,4) DEFAULT NULL,
  `mnCantOrdenCompra` double(15,4) DEFAULT NULL,
  `mnCantOrdenTrabajo` double(15,4) DEFAULT NULL,
  `mnCantConfirmadaFirme` double(15,4) DEFAULT NULL,
  `mnCantConfirmadaFlexible` double(15,4) DEFAULT NULL,
  `szUsuario` varchar(50) DEFAULT NULL,
  `szProgramaID` varchar(50) DEFAULT NULL,
  `jdFechaAct` date DEFAULT NULL,
  `mnTiempoAct` time DEFAULT NULL,
  `szHost` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mnCodigoCorto`,`szUnidadNegocio`,`szUbicacion`,`szLote`,`szCategoriaGL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4105` */

DROP TABLE IF EXISTS `t4105`;

CREATE TABLE `t4105` (
  `mnNroTransaccion` int(9) NOT NULL,
  `mnCodigoCorto` int(8) DEFAULT NULL,
  `szTipoCosto` varchar(30) DEFAULT NULL,
  `mnCosto` double(15,4) DEFAULT NULL,
  `szBodega` varchar(15) DEFAULT NULL,
  `szEstado` varchar(15) DEFAULT NULL,
  `szLote` varchar(15) DEFAULT NULL,
  `jdFechaTrans` date DEFAULT NULL,
  `mnTiempoTrans` time DEFAULT NULL,
  `szUsuario` varchar(100) DEFAULT NULL,
  `szPrograma` varchar(100) DEFAULT NULL,
  `szEstacionTrabajo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mnNroTransaccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4106` */

DROP TABLE IF EXISTS `t4106`;

CREATE TABLE `t4106` (
  `mnCodigoCorto` int(8) NOT NULL,
  `szCodigoLargo` varchar(45) DEFAULT NULL,
  `sz2CodigoLargo` varchar(45) DEFAULT NULL,
  `szUnidadNegocio` varchar(12) NOT NULL,
  `jdFechaInicialVigencia` date NOT NULL,
  `jdFechaCaducidadVigencia` date NOT NULL,
  `szEstado` varchar(15) NOT NULL,
  `mnPrecioVentaPublico` double(15,4) DEFAULT NULL,
  `szUser` varchar(45) DEFAULT NULL,
  `szWorkStation` varchar(45) DEFAULT NULL,
  `jdDateTransaction` date DEFAULT NULL,
  `mnTime` time NOT NULL,
  PRIMARY KEY (`mnCodigoCorto`,`szUnidadNegocio`,`jdFechaInicialVigencia`,`jdFechaCaducidadVigencia`,`szEstado`,`mnTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t4111` */

DROP TABLE IF EXISTS `t4111`;

CREATE TABLE `t4111` (
  `mnNroTransaccion` int(9) NOT NULL,
  `szCompanyOrden` varchar(5) DEFAULT NULL,
  `szTipoDocOrden` varchar(3) DEFAULT NULL,
  `mnNumDocOrden` int(8) DEFAULT NULL,
  `mnNroLinea` int(6) DEFAULT NULL,
  `mnCodigoCorto` int(8) DEFAULT NULL,
  `szCodigoLargo` varchar(25) DEFAULT NULL,
  `sz2CodigoLargo` varchar(25) DEFAULT NULL,
  `szBodega` varchar(15) DEFAULT NULL,
  `szUbicacion` varchar(25) DEFAULT NULL,
  `szLote` varchar(25) DEFAULT NULL,
  `szUnidadMedPri` varchar(5) DEFAULT NULL,
  `szUnidadMedSeg` varchar(5) DEFAULT NULL,
  `szSucursal` varchar(15) DEFAULT NULL,
  `szCompanyInvoice` varchar(5) DEFAULT NULL,
  `szTipoDocInvoice` varchar(3) DEFAULT NULL,
  `mnNumDocInvoice` int(8) DEFAULT NULL,
  `jdFechaLM` date DEFAULT NULL,
  `szCategoriaLM` varchar(10) DEFAULT NULL,
  `mnAddressNumber` int(8) DEFAULT NULL,
  `szExplificacionFiscal` varchar(150) DEFAULT NULL,
  `mnCantidadTrans` double(15,4) DEFAULT NULL,
  `mnCostoUnitario` double(15,4) DEFAULT NULL,
  `mnPrecioUnitario` double(15,4) DEFAULT NULL,
  `mnPrecioTotal` double(15,2) DEFAULT NULL,
  `jdFechaTrans` date DEFAULT NULL,
  `mnTiempoTrans` time DEFAULT NULL,
  `szUsuario` varchar(50) DEFAULT NULL,
  `szEstacionTrabajo` varchar(100) DEFAULT NULL,
  `mnIDCuenta` int(20) DEFAULT NULL,
  `cantidadTransSeg` double(15,4) DEFAULT NULL,
  `unidadMedidaTer` varchar(5) DEFAULT NULL,
  `cantidadTransTercantidadTransTer` double(15,4) DEFAULT NULL,
  `unidadMedidaConv` varchar(5) DEFAULT NULL,
  `cantidadTransConv` double(15,4) DEFAULT NULL,
  PRIMARY KEY (`mnNroTransaccion`),
  KEY `mnCodigoCorto` (`mnCodigoCorto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t42011` */

DROP TABLE IF EXISTS `t42011`;

CREATE TABLE `t42011` (
  `nroDoc` int(9) NOT NULL,
  `tipoDoc` varchar(4) NOT NULL,
  `companiaDoc` varchar(5) NOT NULL,
  `fechaEmision` date DEFAULT NULL,
  `fechaAsignada` date DEFAULT NULL,
  `idCodPersonaAsignada` int(8) DEFAULT NULL,
  `cliente` varchar(150) DEFAULT NULL,
  `horaAsignadoTurno` time DEFAULT NULL,
  `tiempoAsignadoTurno` time DEFAULT NULL,
  `estado` varchar(3) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `estacionTrabajo` varchar(50) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `horaTrans` time DEFAULT NULL,
  `nroDocRela` int(9) DEFAULT NULL,
  `tipoDocRela` varchar(4) DEFAULT NULL,
  `companiaRela` varchar(5) DEFAULT NULL,
  `prioridad` int(2) DEFAULT NULL,
  `observaciones` varchar(400) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `idCodPersona` int(8) DEFAULT NULL,
  `usuarioAnular` varchar(50) DEFAULT NULL,
  `estacionTrabajoAnular` varchar(50) DEFAULT NULL,
  `fechaTransAnular` date DEFAULT NULL,
  `horaTransAnular` time DEFAULT NULL,
  `medioComunicacion` varchar(50) DEFAULT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `detProblema` varchar(500) DEFAULT NULL,
  `detSolucion` varchar(500) DEFAULT NULL,
  `medioSoporte` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nroDoc`,`tipoDoc`,`companiaDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*Table structure for table `t42012` */

DROP TABLE IF EXISTS `t42012`;

CREATE TABLE `t42012` (
  `nroTrabajo` int(8) NOT NULL,
  `fechaTransaccion` date DEFAULT NULL,
  `horaAsignada` time DEFAULT NULL,
  `tiempoAsignado` time DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `fechaVigencia` date DEFAULT NULL,
  `fechaCaducidad` date DEFAULT NULL,
  `nroDireccion` int(8) DEFAULT NULL,
  `reglaDia` varchar(100) DEFAULT NULL,
  `usuarioAct` varchar(50) DEFAULT NULL,
  `fechaAct` date DEFAULT NULL,
  `horaAct` time DEFAULT NULL,
  `workStationAct` varchar(50) DEFAULT NULL,
  `estadoRegla` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nroTrabajo`),
  KEY `CONSULTA` (`fechaVigencia`,`fechaCaducidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t519800` */

DROP TABLE IF EXISTS `t519800`;

CREATE TABLE `t519800` (
  `id` int(8) NOT NULL,
  `servidor` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `credencial` varchar(300) DEFAULT NULL,
  `protocolo` varchar(50) DEFAULT NULL,
  `puerto` varchar(10) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `tiempoTrans` time DEFAULT NULL,
  `clavePublica` longtext DEFAULT NULL,
  `clavePrivada` longtext DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t519801` */

DROP TABLE IF EXISTS `t519801`;

CREATE TABLE `t519801` (
  `id` int(10) NOT NULL,
  `idNumeroMsg` varchar(200) DEFAULT NULL,
  `asunto` varchar(300) DEFAULT NULL,
  `nroLinea` int(10) DEFAULT NULL,
  `remitente` varchar(400) DEFAULT NULL,
  `fechaEnvio` varchar(100) DEFAULT NULL,
  `tiempoEnvio` time DEFAULT NULL,
  `tamano` varchar(50) DEFAULT NULL,
  `fechaLectura` date DEFAULT NULL,
  `tiempoLectura` time DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `fileText` longtext DEFAULT NULL,
  `referenciaProceso` varchar(500) DEFAULT NULL,
  `tipoComprobante` varchar(10) DEFAULT NULL,
  `claveAcceso` varchar(80) DEFAULT NULL,
  `autorizacionElectronica` varchar(80) DEFAULT NULL,
  `nroLegalComprobante` varchar(20) DEFAULT NULL,
  `identificacionFiscalCliente` varchar(20) DEFAULT NULL,
  `cliente` varchar(200) DEFAULT NULL,
  `identificacionFiscalProveedor` varchar(20) DEFAULT NULL,
  `proveedor` varchar(200) DEFAULT NULL,
  `clavePublica` longtext DEFAULT NULL,
  `fechaEmision` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FechaLecturaRemite` (`fechaEnvio`,`fechaLectura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t57001` */

DROP TABLE IF EXISTS `t57001`;

CREATE TABLE `t57001` (
  `mnDocumentNumber` int(8) DEFAULT NULL,
  `szDocumentType` varchar(6) DEFAULT NULL,
  `szDocumentCompany` varchar(15) DEFAULT NULL,
  `mnInvoiceNumber` int(8) NOT NULL,
  `szInvoiceType` varchar(6) NOT NULL,
  `szInvoiceCompany` varchar(15) NOT NULL,
  `szReferenceLegal` varchar(60) NOT NULL,
  `szReference` varchar(60) DEFAULT NULL,
  `mnCodigoCliente` int(8) DEFAULT NULL,
  `szNombreXML` varchar(300) DEFAULT NULL,
  `szIDPathXMLBase` varchar(400) DEFAULT NULL,
  `szIDPathXMLFirmado` varchar(400) DEFAULT NULL,
  `szIDPathXMLRespuesta` varchar(400) DEFAULT NULL,
  `szIDPathPDF` varchar(400) DEFAULT NULL,
  `szNroAutorizacion` varchar(300) DEFAULT NULL,
  `szFechaAutorizacion` varchar(300) DEFAULT NULL,
  `szClaveAcceso` varchar(300) DEFAULT NULL,
  `mnBachNumber` int(8) DEFAULT NULL,
  `szBachType` varchar(6) DEFAULT NULL,
  `jdDateInvoice` date DEFAULT NULL,
  `szAmbiente` varchar(15) DEFAULT NULL,
  `szEstadoAutorizacion` varchar(15) DEFAULT NULL,
  `mnIdentificador` varchar(10) DEFAULT NULL,
  `szProceso` varchar(10) DEFAULT NULL,
  `szMensajeError` varchar(400) DEFAULT NULL,
  `szInformacionAdicional` varchar(400) DEFAULT NULL,
  `szEtiqueta` varchar(50) DEFAULT NULL,
  `szEnvioYN` varchar(2) DEFAULT NULL,
  `szAutorizadoYN` varchar(2) DEFAULT NULL,
  `szUsuarioTrans` varchar(20) DEFAULT NULL,
  `jdFechaTrans` date DEFAULT NULL,
  PRIMARY KEY (`mnInvoiceNumber`,`szInvoiceType`,`szInvoiceCompany`,`szReferenceLegal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t57001d` */

DROP TABLE IF EXISTS `t57001d`;

CREATE TABLE `t57001d` (
  `mnNroTrabajo` int(9) NOT NULL,
  `szTipoPlantilla` varchar(2) DEFAULT NULL,
  `mnInvoiceNumber` int(8) DEFAULT NULL,
  `szInvoiceType` varchar(3) DEFAULT NULL,
  `szInvoiceCompany` varchar(5) DEFAULT NULL,
  `szReferenceLegal` varchar(25) DEFAULT NULL,
  `szIdFiscalCliente` varchar(25) DEFAULT NULL,
  `szClaveAcceso` varchar(70) DEFAULT NULL,
  `szNroAutorizacion` varchar(70) DEFAULT NULL,
  `szFechaAutorizacion` varchar(50) DEFAULT NULL,
  `szAmbiente` varchar(50) DEFAULT NULL,
  `jdFechaTrans` datetime DEFAULT NULL,
  `szCorreo` varchar(100) DEFAULT NULL,
  `szCC` varchar(300) DEFAULT NULL,
  `szContexto01` varchar(200) DEFAULT NULL,
  `szContexto02` varchar(200) DEFAULT NULL,
  `szContexto03` varchar(200) DEFAULT NULL,
  `szContexto04` varchar(200) DEFAULT NULL,
  `szContexto05` varchar(200) DEFAULT NULL,
  `szContexto06` varchar(200) DEFAULT NULL,
  `szContexto07` varchar(200) DEFAULT NULL,
  `szContexto08` varchar(200) DEFAULT NULL,
  `szContexto09` varchar(200) DEFAULT NULL,
  `szContexto10` varchar(200) DEFAULT NULL,
  `szPathReferencia1` varchar(250) DEFAULT NULL,
  `szPathReferencia2` varchar(250) DEFAULT NULL,
  `szPathReferencia3` varchar(250) DEFAULT NULL,
  `szMsgError` varchar(300) DEFAULT NULL,
  `szProceso` varchar(2) DEFAULT NULL,
  `mnCountError` int(3) DEFAULT NULL,
  PRIMARY KEY (`mnNroTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t5701` */

DROP TABLE IF EXISTS `t5701`;

CREATE TABLE `t5701` (
  `szIdentificadorFiscal` varchar(20) NOT NULL,
  `szEstado` varchar(3) DEFAULT NULL,
  `jdFechaRegistro` date NOT NULL,
  `jdFechaCaducidad` date NOT NULL,
  `szNameArchivoP12` varchar(300) DEFAULT NULL,
  `szPwsArchivoP12` varchar(300) DEFAULT NULL,
  `szLogAuditoria` varchar(3) DEFAULT NULL,
  `mnTiempoEspera` int(25) DEFAULT NULL,
  `szCodPathArchivoOrigen` varchar(5) DEFAULT NULL,
  `szCodPathArchivoFirmado` varchar(5) DEFAULT NULL,
  `szCodPathArchivoRide` varchar(5) DEFAULT NULL,
  `szCodPathArchivoP12` varchar(5) DEFAULT NULL,
  `szTipoEmision` varchar(5) DEFAULT NULL,
  `szAmbiente` varchar(5) DEFAULT NULL,
  `szModoConsumoServicio` varchar(5) DEFAULT NULL,
  `szLogo` varchar(5) DEFAULT NULL,
  `szMarcaAgua` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`szIdentificadorFiscal`,`jdFechaRegistro`,`jdFechaCaducidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t57011` */

DROP TABLE IF EXISTS `t57011`;

CREATE TABLE `t57011` (
  `szComputerID` varchar(200) NOT NULL,
  `mnJobNumber` int(8) NOT NULL,
  `szBachType` varchar(2) DEFAULT NULL,
  `mnBachNumber` int(8) NOT NULL,
  `mnDocumentNumber` int(8) NOT NULL,
  `szDocumentType` varchar(2) NOT NULL,
  `szDocumentCompany` varchar(5) NOT NULL,
  `mnInvoiceNumber` int(8) NOT NULL,
  `szInvoiceType` varchar(2) NOT NULL,
  `szInvoiceCompany` varchar(5) NOT NULL,
  `szReferenceLegal` varchar(20) DEFAULT NULL,
  `szReference` varchar(20) NOT NULL,
  `mnLineNumber` int(5) NOT NULL,
  `mnSequenceNumber` int(5) NOT NULL,
  `mnSubSequenceNumber` int(5) NOT NULL,
  `szMember` varchar(15) DEFAULT NULL,
  `mnLegalNumber` varchar(10) DEFAULT NULL,
  `jdDateEfective` date DEFAULT NULL,
  `jdDateExpired` date DEFAULT NULL,
  `szOperationType` varchar(100) DEFAULT NULL,
  `szJobTypeDescription` varchar(30) NOT NULL,
  `szThruCaseStatusCode` varchar(3) DEFAULT NULL,
  `mnCodCliente` int(8) DEFAULT NULL,
  `szNameAlpha` varchar(150) DEFAULT NULL,
  `szTaxID` varchar(20) DEFAULT NULL,
  `szAddressLine01` varchar(2000) DEFAULT NULL,
  `szAddressLine02` varchar(2000) DEFAULT NULL,
  `mnCodCliente_ShipTo` int(8) DEFAULT NULL,
  `szBodega` varchar(12) DEFAULT NULL,
  `szCompany` varchar(5) DEFAULT NULL,
  `szName` varchar(160) DEFAULT NULL,
  `szTaxIdentificationNumber` varchar(20) DEFAULT NULL,
  `szAddressLine1` varchar(2000) DEFAULT NULL,
  `szAddressLine2` varchar(2000) DEFAULT NULL,
  `szAddressLine3` varchar(2000) DEFAULT NULL,
  `szAddressLine4` varchar(2000) DEFAULT NULL,
  `mnCodItemNumberShort` int(8) DEFAULT NULL,
  `szPrintDataYN` varchar(2) DEFAULT NULL,
  `szDescription` varchar(250) DEFAULT NULL,
  `szDescription2` varchar(250) DEFAULT NULL,
  `mnItemNumber` varchar(25) DEFAULT NULL,
  `szUnitofMeasureasInput` varchar(3) DEFAULT NULL,
  `szUnitofMeasurePricing` varchar(3) DEFAULT NULL,
  `mnQuantityShipped` decimal(15,4) DEFAULT NULL,
  `mnUnitsQtyBackordered` decimal(15,4) DEFAULT NULL,
  `mnUnitsQuantityCanceledScrapped` decimal(15,5) DEFAULT NULL,
  `mnAmountPriceUnit` decimal(15,4) DEFAULT NULL,
  `mnAmountGross` decimal(15,4) DEFAULT NULL,
  `mnAmountExtendedPrice` decimal(15,4) DEFAULT NULL,
  `mnAmountExtendedCost` decimal(15,4) DEFAULT NULL,
  `mnPercent1` decimal(15,4) DEFAULT NULL,
  `jdDateRequested` date DEFAULT NULL,
  `szCommitted` varchar(2) DEFAULT NULL,
  `szLineType` varchar(15) DEFAULT NULL,
  `jdDateInvoice` date DEFAULT NULL,
  `jdDateNetDue` date DEFAULT NULL,
  `mnRelatedNumber` int(8) DEFAULT NULL,
  `szRelatedOrderType` varchar(2) DEFAULT NULL,
  `szCompanyRelatedOrder` varchar(5) DEFAULT NULL,
  `szPrintMessage` varchar(30) DEFAULT NULL,
  `szSalesTaxableYN` varchar(2) DEFAULT NULL,
  `szTaxRateArea` varchar(30) DEFAULT NULL,
  `szTaxExplCode` varchar(50) DEFAULT NULL,
  `szDescriptionTaxArea` varchar(50) DEFAULT NULL,
  `mnTaxAuthority` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority2` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority3` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority4` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority5` decimal(15,4) DEFAULT NULL,
  `mnTaxRate1` decimal(15,4) DEFAULT NULL,
  `mnTaxRate2` decimal(15,4) DEFAULT NULL,
  `mnTaxRate3` decimal(15,4) DEFAULT NULL,
  `mnTaxRate4` decimal(15,4) DEFAULT NULL,
  `mnTaxRate5` decimal(15,4) DEFAULT NULL,
  `szTaxCalculationMethod` varchar(20) DEFAULT NULL,
  `mnAmountTaxable` decimal(15,4) DEFAULT NULL,
  `mnAmountTax` decimal(15,4) DEFAULT NULL,
  `szPaymentTermsCode` varchar(20) DEFAULT NULL,
  `mnDiscountAvailable` decimal(15,4) DEFAULT NULL,
  `szUserID` varchar(15) DEFAULT NULL,
  `szProgramID` varchar(300) DEFAULT NULL,
  `szWorkStationID` varchar(300) DEFAULT NULL,
  `jdDateUpdated` date DEFAULT NULL,
  `mnTimeofDay` time DEFAULT NULL,
  `mnEDIDocumentNumber` int(8) DEFAULT NULL,
  `szEDIDocumentType` varchar(2) DEFAULT NULL,
  `szEDIDocumentKeyCo` varchar(5) DEFAULT NULL,
  `mnEDILineNumber` int(5) DEFAULT NULL,
  `mnOrderSuffix` int(5) DEFAULT NULL,
  `mnCodClienteParent` int(8) DEFAULT NULL,
  `mnDiscountAmount` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal1` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal2` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal3` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal4` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal5` decimal(15,4) DEFAULT NULL,
  `mnAmountNonTaxable` decimal(15,4) DEFAULT NULL,
  `mnAmountListPrice` decimal(15,4) DEFAULT NULL,
  `sz2ndItemNumber` varchar(25) DEFAULT NULL,
  `mnCarrierNumber` int(8) DEFAULT NULL,
  `szAgreementSupplementDistribution` varchar(30) DEFAULT NULL,
  `szEstablecimiento` varchar(12) DEFAULT NULL,
  `mnTripNumber` int(8) DEFAULT NULL,
  `mnWeightResult` decimal(15,4) DEFAULT NULL,
  `szDutyStatus` varchar(15) DEFAULT NULL,
  `szLotSerialNumber` varchar(30) DEFAULT NULL,
  `szParameterDataItem01` varchar(2000) DEFAULT NULL,
  `szParameterDataItem02` varchar(2000) DEFAULT NULL,
  `szParameterDataItem03` varchar(2000) DEFAULT NULL,
  `szParameterDataItem04` varchar(2000) DEFAULT NULL,
  `szParameterDataItem05` varchar(2000) DEFAULT NULL,
  `szParameterDataItem06` varchar(2000) DEFAULT NULL,
  `szParameterDataItem07` varchar(2000) DEFAULT NULL,
  `szParameterDataItem08` varchar(2000) DEFAULT NULL,
  `szParameterDataItem09` varchar(2000) DEFAULT NULL,
  `szParameterDataItem10` varchar(2000) DEFAULT NULL,
  `szLegalDocumentTitle` varchar(100) DEFAULT NULL,
  `szClaveAcceso` varchar(100) DEFAULT NULL,
  `szClaveAccesoContingencia` varchar(100) DEFAULT NULL,
  `szAutorizacionElectronica` varchar(100) DEFAULT NULL,
  `szRefAutorizacion1` varchar(100) DEFAULT NULL,
  `szRefAutorizacion2` varchar(100) DEFAULT NULL,
  `szRefAutorizacion3` varchar(100) DEFAULT NULL,
  `szRefAutorizacion4` varchar(100) DEFAULT NULL,
  `szAmbiente` varchar(10) DEFAULT NULL,
  `szTipoEmision` varchar(10) DEFAULT NULL,
  `szContribuyenteEspecial` varchar(15) DEFAULT NULL,
  `szObligadoContabilidad` varchar(3) DEFAULT NULL,
  `szMoneda` varchar(15) DEFAULT NULL,
  `szCatSales01` varchar(150) DEFAULT NULL,
  `szCatSales02` varchar(150) DEFAULT NULL,
  `szCatSales03` varchar(150) DEFAULT NULL,
  `szCatSales04` varchar(150) DEFAULT NULL,
  `szCatSales05` varchar(150) DEFAULT NULL,
  `szPeriodoFiscal` varchar(5) DEFAULT NULL,
  `szRise` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`szComputerID`,`mnJobNumber`,`mnDocumentNumber`,`szDocumentType`,`szDocumentCompany`,`mnInvoiceNumber`,`szInvoiceType`,`szInvoiceCompany`,`mnLineNumber`,`mnSequenceNumber`,`mnSubSequenceNumber`,`szJobTypeDescription`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t57011z1` */

DROP TABLE IF EXISTS `t57011z1`;

CREATE TABLE `t57011z1` (
  `szComputerID` varchar(15) NOT NULL,
  `mnJobNumber` int(8) NOT NULL,
  `szBachType` varchar(2) DEFAULT NULL,
  `mnBachNumber` int(8) NOT NULL,
  `mnDocumentNumber` int(8) NOT NULL,
  `szDocumentType` varchar(2) NOT NULL,
  `szDocumentCompany` varchar(5) NOT NULL,
  `mnInvoiceNumber` int(8) NOT NULL,
  `szInvoiceType` varchar(2) NOT NULL,
  `szInvoiceCompany` varchar(5) NOT NULL,
  `szReferenceLegal` varchar(20) DEFAULT NULL,
  `szReference` varchar(20) NOT NULL,
  `mnLineNumber` int(5) NOT NULL,
  `mnSequenceNumber` int(5) NOT NULL,
  `mnSubSequenceNumber` int(5) NOT NULL,
  `szMember` varchar(15) DEFAULT NULL,
  `mnLegalNumber` varchar(10) DEFAULT NULL,
  `jdDateEfective` date DEFAULT NULL,
  `jdDateExpired` date DEFAULT NULL,
  `szOperationType` varchar(2) DEFAULT NULL,
  `szJobTypeDescription` varchar(30) NOT NULL,
  `szThruCaseStatusCode` varchar(3) DEFAULT NULL,
  `mnCodCliente` int(8) DEFAULT NULL,
  `szNameAlpha` varchar(150) DEFAULT NULL,
  `szTaxID` varchar(20) DEFAULT NULL,
  `szAddressLine01` varchar(200) DEFAULT NULL,
  `szAddressLine02` varchar(200) DEFAULT NULL,
  `mnCodCliente_ShipTo` int(8) DEFAULT NULL,
  `szBodega` varchar(12) DEFAULT NULL,
  `szCompany` varchar(5) DEFAULT NULL,
  `szName` varchar(60) DEFAULT NULL,
  `szTaxIdentificationNumber` varchar(20) DEFAULT NULL,
  `szAddressLine1` varchar(200) DEFAULT NULL,
  `szAddressLine2` varchar(200) DEFAULT NULL,
  `szAddressLine3` varchar(200) DEFAULT NULL,
  `szAddressLine4` varchar(200) DEFAULT NULL,
  `mnCodItemNumberShort` int(8) DEFAULT NULL,
  `szPrintDataYN` varchar(2) DEFAULT NULL,
  `szDescription` varchar(250) DEFAULT NULL,
  `szDescription2` varchar(250) DEFAULT NULL,
  `mnItemNumber` varchar(25) DEFAULT NULL,
  `szUnitofMeasureasInput` varchar(3) DEFAULT NULL,
  `szUnitofMeasurePricing` varchar(3) DEFAULT NULL,
  `mnQuantityShipped` decimal(15,4) DEFAULT NULL,
  `mnUnitsQtyBackordered` decimal(15,4) DEFAULT NULL,
  `mnUnitsQuantityCanceledScrapped` decimal(15,5) DEFAULT NULL,
  `mnAmountPriceUnit` decimal(15,4) DEFAULT NULL,
  `mnAmountGross` decimal(15,4) DEFAULT NULL,
  `mnAmountExtendedPrice` decimal(15,4) DEFAULT NULL,
  `mnAmountExtendedCost` decimal(15,4) DEFAULT NULL,
  `mnPercent1` decimal(15,4) DEFAULT NULL,
  `jdDateRequested` date DEFAULT NULL,
  `szCommitted` varchar(2) DEFAULT NULL,
  `szLineType` varchar(15) DEFAULT NULL,
  `jdDateInvoice` date DEFAULT NULL,
  `jdDateNetDue` date DEFAULT NULL,
  `mnRelatedNumber` int(8) DEFAULT NULL,
  `szRelatedOrderType` varchar(2) DEFAULT NULL,
  `szCompanyRelatedOrder` varchar(5) DEFAULT NULL,
  `szPrintMessage` varchar(30) DEFAULT NULL,
  `szSalesTaxableYN` varchar(2) DEFAULT NULL,
  `szTaxRateArea` varchar(30) DEFAULT NULL,
  `szTaxExplCode` varchar(50) DEFAULT NULL,
  `szDescriptionTaxArea` varchar(50) DEFAULT NULL,
  `mnTaxAuthority` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority2` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority3` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority4` decimal(15,4) DEFAULT NULL,
  `mnTaxAuthority5` decimal(15,4) DEFAULT NULL,
  `mnTaxRate1` decimal(15,4) DEFAULT NULL,
  `mnTaxRate2` decimal(15,4) DEFAULT NULL,
  `mnTaxRate3` decimal(15,4) DEFAULT NULL,
  `mnTaxRate4` decimal(15,4) DEFAULT NULL,
  `mnTaxRate5` decimal(15,4) DEFAULT NULL,
  `szTaxCalculationMethod` varchar(20) DEFAULT NULL,
  `mnAmountTaxable` decimal(15,4) DEFAULT NULL,
  `mnAmountTax` decimal(15,4) DEFAULT NULL,
  `szPaymentTermsCode` varchar(20) DEFAULT NULL,
  `mnDiscountAvailable` decimal(15,4) DEFAULT NULL,
  `szUserID` varchar(15) DEFAULT NULL,
  `szProgramID` varchar(30) DEFAULT NULL,
  `szWorkStationID` varchar(30) DEFAULT NULL,
  `jdDateUpdated` date DEFAULT NULL,
  `mnTimeofDay` time DEFAULT NULL,
  `mnEDIDocumentNumber` int(8) DEFAULT NULL,
  `szEDIDocumentType` varchar(2) DEFAULT NULL,
  `szEDIDocumentKeyCo` varchar(5) DEFAULT NULL,
  `mnEDILineNumber` int(5) DEFAULT NULL,
  `mnOrderSuffix` int(5) DEFAULT NULL,
  `mnCodClienteParent` int(8) DEFAULT NULL,
  `mnDiscountAmount` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal1` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal2` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal3` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal4` decimal(15,4) DEFAULT NULL,
  `mnAmountSalesTaxTotal5` decimal(15,4) DEFAULT NULL,
  `mnAmountNonTaxable` decimal(15,4) DEFAULT NULL,
  `mnAmountListPrice` decimal(15,4) DEFAULT NULL,
  `sz2ndItemNumber` varchar(25) DEFAULT NULL,
  `mnCarrierNumber` int(8) DEFAULT NULL,
  `szAgreementSupplementDistribution` varchar(30) DEFAULT NULL,
  `szEstablecimiento` varchar(12) DEFAULT NULL,
  `mnTripNumber` int(8) DEFAULT NULL,
  `mnWeightResult` decimal(15,4) DEFAULT NULL,
  `szDutyStatus` varchar(15) DEFAULT NULL,
  `szLotSerialNumber` varchar(30) DEFAULT NULL,
  `szParameterDataItem01` varchar(500) DEFAULT NULL,
  `szParameterDataItem02` varchar(500) DEFAULT NULL,
  `szParameterDataItem03` varchar(500) DEFAULT NULL,
  `szParameterDataItem04` varchar(500) DEFAULT NULL,
  `szParameterDataItem05` varchar(500) DEFAULT NULL,
  `szParameterDataItem06` varchar(500) DEFAULT NULL,
  `szParameterDataItem07` varchar(500) DEFAULT NULL,
  `szParameterDataItem08` varchar(500) DEFAULT NULL,
  `szParameterDataItem09` varchar(500) DEFAULT NULL,
  `szParameterDataItem10` varchar(500) DEFAULT NULL,
  `szLegalDocumentTitle` varchar(100) DEFAULT NULL,
  `szClaveAcceso` varchar(100) DEFAULT NULL,
  `szClaveAccesoContingencia` varchar(100) DEFAULT NULL,
  `szAutorizacionElectronica` varchar(100) DEFAULT NULL,
  `szRefAutorizacion1` varchar(100) DEFAULT NULL,
  `szRefAutorizacion2` varchar(100) DEFAULT NULL,
  `szRefAutorizacion3` varchar(100) DEFAULT NULL,
  `szRefAutorizacion4` varchar(100) DEFAULT NULL,
  `szAmbiente` varchar(10) DEFAULT NULL,
  `szTipoEmision` varchar(10) DEFAULT NULL,
  `szContribuyenteEspecial` varchar(15) DEFAULT NULL,
  `szObligadoContabilidad` varchar(3) DEFAULT NULL,
  `szMoneda` varchar(15) DEFAULT NULL,
  `szCatSales01` varchar(200) DEFAULT NULL,
  `szCatSales02` varchar(200) DEFAULT NULL,
  `szCatSales03` varchar(200) DEFAULT NULL,
  `szCatSales04` varchar(200) DEFAULT NULL,
  `szCatSales05` varchar(200) DEFAULT NULL,
  `szPeriodoFiscal` varchar(5) DEFAULT NULL,
  `szRise` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`szComputerID`,`mnJobNumber`,`mnDocumentNumber`,`szDocumentType`,`szDocumentCompany`,`mnInvoiceNumber`,`szInvoiceType`,`szInvoiceCompany`,`mnLineNumber`,`mnSequenceNumber`,`mnSubSequenceNumber`,`szJobTypeDescription`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t579540` */

DROP TABLE IF EXISTS `t579540`;

CREATE TABLE `t579540` (
  `szNameSoftKey` varchar(30) NOT NULL,
  `szAmbiente` varchar(2) NOT NULL,
  `szUsuarioRol` varchar(10) NOT NULL,
  `szDescripcion` varchar(100) DEFAULT NULL,
  `szWSDL` varchar(1000) DEFAULT NULL,
  `szCredencial` varchar(100) DEFAULT NULL,
  `szPws` varchar(100) DEFAULT NULL,
  `iTimeOut` int(7) DEFAULT NULL,
  `szSOAPAction` varchar(100) DEFAULT NULL,
  `szRequestMethod` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szNameSoftKey`,`szAmbiente`,`szUsuarioRol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t57path` */

DROP TABLE IF EXISTS `t57path`;

CREATE TABLE `t57path` (
  `szCodPathArchivo` varchar(5) NOT NULL,
  `szDescripcion` varchar(100) DEFAULT NULL,
  `szPathArchivo` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`szCodPathArchivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t7101` */

DROP TABLE IF EXISTS `t7101`;

CREATE TABLE `t7101` (
  `nroTrabajo` int(8) NOT NULL,
  `secuencia` int(8) DEFAULT NULL,
  `descripcionTurno` varchar(300) DEFAULT NULL,
  `horario` time DEFAULT NULL,
  `tipoEntrada` varchar(50) DEFAULT NULL,
  `nroDireccion` int(8) DEFAULT NULL,
  `codigoEmpleado` int(8) DEFAULT NULL,
  `minutosMinLimite` int(11) DEFAULT NULL,
  `minutosMaxLimite` int(11) DEFAULT NULL,
  PRIMARY KEY (`nroTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t710101` */

DROP TABLE IF EXISTS `t710101`;

CREATE TABLE `t710101` (
  `nroDireccion` int(11) NOT NULL,
  `nroLinea` int(11) NOT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `nroAfiliacionIESS` varchar(100) DEFAULT NULL,
  `unidadNegocio` varchar(100) DEFAULT NULL,
  `claseAfiliacion` varchar(100) DEFAULT NULL,
  `tipoRelacion` varchar(100) DEFAULT NULL,
  `banco` varchar(300) DEFAULT NULL,
  `tipoCuentaBanco` varchar(100) DEFAULT NULL,
  `notificacion` varchar(200) DEFAULT NULL,
  `cuentaPago` varchar(200) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `codigoRelog` varchar(100) DEFAULT NULL,
  `Sueldo` double(15,2) DEFAULT NULL,
  `HoraBase` double(15,2) DEFAULT NULL,
  `usuarioTrans` varchar(50) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `tiempoTrans` time DEFAULT NULL,
  `estacionTrabajo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nroDireccion`,`nroLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t7102` */

DROP TABLE IF EXISTS `t7102`;

CREATE TABLE `t7102` (
  `nroTrabajo` int(8) NOT NULL,
  `empresaDocumento` varchar(5) NOT NULL,
  `nroDocumento` int(9) NOT NULL,
  `tipoDocumento` varchar(50) NOT NULL,
  `nroLinea` int(9) NOT NULL,
  `maquina` varchar(100) DEFAULT NULL,
  `idEmpleado` int(10) DEFAULT NULL,
  `nombreEmpleado` varchar(300) DEFAULT NULL,
  `departamento` varchar(300) DEFAULT NULL,
  `tipoVerificacion` varchar(100) DEFAULT NULL,
  `dia` varchar(100) DEFAULT NULL,
  `fechaHoraMarcacion` varchar(200) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `estacionTrabajo` varchar(100) DEFAULT NULL,
  `fechaTrans` date DEFAULT NULL,
  `tiempoTrans` time DEFAULT NULL,
  PRIMARY KEY (`nroTrabajo`,`empresaDocumento`,`nroDocumento`,`tipoDocumento`,`nroLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t7111` */

DROP TABLE IF EXISTS `t7111`;

CREATE TABLE `t7111` (
  `idComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `razonComercialEmpresa` varchar(200) DEFAULT NULL,
  `razonSocialEmpresa` varchar(300) DEFAULT NULL,
  `direccionEmpresa` varchar(300) DEFAULT NULL,
  `rucEmpresa` varchar(50) DEFAULT NULL,
  `calificacionArtesanal` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `periodo` varchar(100) DEFAULT NULL,
  `ciEmpleado` varchar(25) DEFAULT NULL,
  `nombreEmpleado` varchar(300) DEFAULT NULL,
  `cargoEmpleado` varchar(100) DEFAULT NULL,
  `departamentoEmpleado` varchar(30) DEFAULT NULL,
  `sueldo` double(15,2) DEFAULT NULL,
  `diasTrabajado` int(9) DEFAULT NULL,
  `sueldoGanado` double(15,2) DEFAULT NULL,
  `horasExtras50` double(15,2) DEFAULT NULL,
  `horasExtras100` double(15,2) DEFAULT NULL,
  `incentivoProduccion` double(15,2) DEFAULT NULL,
  `fondosReserva` double(15,2) DEFAULT NULL,
  `13SueldoMensualizado` double(15,2) DEFAULT NULL,
  `14SueldoMensualizado` double(15,2) DEFAULT NULL,
  `alimentacion` double(15,2) DEFAULT NULL,
  `aportePersonalIESS` double(15,2) DEFAULT NULL,
  `impuestoRenta` double(15,2) DEFAULT NULL,
  `subsidioIESS` double(15,2) DEFAULT NULL,
  `multas` double(15,2) DEFAULT NULL,
  `anticipos` double(15,2) DEFAULT NULL,
  `prestamosIESS` double(15,2) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  `fechaEmision` date DEFAULT NULL,
  `tiempoEmision` time DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t769800` */

DROP TABLE IF EXISTS `t769800`;

CREATE TABLE `t769800` (
  `empresa` varchar(5) NOT NULL,
  `rucInformante` varchar(30) DEFAULT NULL,
  `razonSocial` varchar(200) DEFAULT NULL,
  `rucRepresentanteLegal` varchar(30) DEFAULT NULL,
  `rucContador` varchar(30) DEFAULT NULL,
  `periodoFiscal` int(10) DEFAULT 0,
  `periodo` int(10) DEFAULT 0,
  `direccion` varchar(300) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `tipoRepresentanteLegal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t769801` */

DROP TABLE IF EXISTS `t769801`;

CREATE TABLE `t769801` (
  `nroTrabajo` int(8) NOT NULL AUTO_INCREMENT,
  `TipoIDInformante` varchar(30) DEFAULT NULL,
  `IdInformante` varchar(50) DEFAULT NULL,
  `razonSocial` varchar(300) DEFAULT NULL,
  `Anio` varchar(10) DEFAULT NULL,
  `Mes` varchar(10) DEFAULT NULL,
  `numEstabRuc` varchar(10) DEFAULT NULL,
  `totalVentas` double(12,4) DEFAULT NULL,
  `codigoOperativo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nroTrabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t98000` */

DROP TABLE IF EXISTS `t98000`;

CREATE TABLE `t98000` (
  `szIdentificionFiscal` varchar(20) NOT NULL,
  `szRazonSocial` varchar(100) DEFAULT NULL,
  `szTipoContribuyente` varchar(50) DEFAULT NULL,
  `szNumeroResolucion` varchar(50) DEFAULT NULL,
  `szFechaResolucion` date DEFAULT NULL,
  `szDireccion` varchar(200) DEFAULT NULL,
  `szPathImagen` varchar(300) DEFAULT NULL,
  `szAddressNumber` int(8) NOT NULL,
  `szCompany` varchar(5) DEFAULT NULL,
  `szAmbiente` varchar(15) DEFAULT NULL,
  `szEmision` varchar(15) DEFAULT NULL,
  `szObligadoContabilidad` varchar(15) DEFAULT NULL,
  `leyendaMicroEmpresario` varchar(350) DEFAULT NULL,
  `leyendaAgenteRetencion` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`szIdentificionFiscal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t9801` */

DROP TABLE IF EXISTS `t9801`;

CREATE TABLE `t9801` (
  `szUser` varchar(60) NOT NULL,
  `szPasw` varchar(500) NOT NULL,
  `szEmail` varchar(200) NOT NULL,
  `szCountFailedPasw` varchar(3) DEFAULT NULL,
  `szLockoutUser` varchar(3) DEFAULT NULL,
  `szReceiveEmail` varchar(3) DEFAULT NULL,
  `szGeneratePasw` varchar(3) DEFAULT NULL,
  `szStatusUser` varchar(3) DEFAULT NULL,
  `szResetCredencia` varchar(3) DEFAULT NULL,
  `mnAddressNumber` int(8) DEFAULT NULL,
  `jdDateUpdate` datetime DEFAULT NULL,
  `jdDateCreate` datetime DEFAULT NULL,
  `Bodega` varchar(50) DEFAULT NULL,
  `IdMenu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`szUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t9802` */

DROP TABLE IF EXISTS `t9802`;

CREATE TABLE `t9802` (
  `mnJobTrans` int(8) NOT NULL,
  `szUser` varchar(50) DEFAULT NULL,
  `szRol` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mnJobTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Table structure for table `t9803` */

DROP TABLE IF EXISTS `t9803`;

CREATE TABLE `t9803` (
  `szRol` varchar(50) NOT NULL,
  `szDescripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`szRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: procesamiento_sri
-- ------------------------------------------------------
-- Server version	5.7.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`procesamiento_sri` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;

USE `procesamiento_sri`;



--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(128) NOT NULL,
  `sri_usuario` varchar(16) NOT NULL,
  `sri_credencial` varchar(256) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_programa` varchar(128) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'dveloper_catalina_usuario','0103153425001','LCAG2019','A','2024-03-28 15:52:16','manual'),(2,'dveloper_rosa_usuario','0911774198001','ROSITA1234','X','2024-03-28 15:52:54','manual'),(3,'dveloper_indupan_facturador','1715726772001','Indupan1111@','X','2024-03-28 15:53:22','manual'),(4,'dveloper_cris','0103153425001','<NO DEFINIDO>','X','2024-03-28 15:53:22','manual');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `id_parametro` int(11) NOT NULL AUTO_INCREMENT,
  `indice` int(11) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `descripcion` varchar(256) NOT NULL,
  `texto_a` varchar(1024) DEFAULT NULL,
  `texto_b` varchar(1024) DEFAULT NULL,
  `numero_a` double DEFAULT '-1',
  `numero_b` double DEFAULT '-1',
  `estado` varchar(8) NOT NULL,
  `usuario` varchar(128) NOT NULL DEFAULT '<NO_DEFINIDO>',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_programa` varchar(128) NOT NULL,
  PRIMARY KEY (`id_parametro`),
  UNIQUE KEY `parametros_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (1,50,'Cliente SRI','Cliente SRI contratado campo CLIENT_ID','33nda5ed9snbl7edpgp7f3it1c',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 14:59:28','manual'),(2,51,'Cliente SRI','Cliente SRI contratado campo SECRET_ID','o0js143is9nh3rc0hdgu1uu83uluic11vvrv28h88sdh3h3nubq',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:02:35','manual'),(3,52,'Cliente SRI','Cliente SRI contratado campo GRANT_TYPE','client_credentials',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(4,53,'Cliente SRI URL token','Cliente SRI url Token','https://auth.invoicy.app/token',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(6,54,'Cliente SRI URL documentos_proveedores','Cliente SRI url Documentos Recibidos','https://api.invoicy.app/v1/documents',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(7,55,'Cliente SRI URL documentos','Cliente SRI url Descarga Autorizacion','https://api.invoicy.app/v1/documents',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual');
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-11  4:33:45
