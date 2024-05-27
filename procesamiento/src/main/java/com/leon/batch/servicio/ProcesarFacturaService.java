package com.leon.batch.servicio;

import com.leon.estructura.persistencia.crud.T57011CrudRepositorio;
import com.leon.estructura.persistencia.entidad.T57011;
import com.leon.estructura.persistencia.entidad.T57011Id;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura.Detalles;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.aplicaciones13.documentos.utilidades.Route;
import com.leon.batch.utilitarios.BundleMessages;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * Clase que procesa la factura y la carga en la base de datos.
 * 
 * @author omargo33
 * @since 2024-05-26
 * 
 */
@Slf4j
@Service
@Transactional
public class ProcesarFacturaService {

    @Autowired
    private T57011CrudRepositorio t57011CrudRepositorio;

    @Autowired
    private IndicesService indicesService;

    int i = 0;

    double baseImponibleIva0 = 0;
    double baseImponibleIva = 0;
    double valorIva = 0;
    double baseImponibleIvaVigente = 0;
    double valorIvaVigente = 0;
    double baseImponibleICE = 0;
    double valorICE = 0;
    double baseImponibleIRBPNR = 0;
    double valorIRBPNR = 0;
    String mensajeInfoAdicional = "";
    double montoTotalConImpuestos = 0;

    int impuestoCodigo = 0;
    int impuestoCodigoPorcentaje = 0;
    double impuestoBaseImponible = 0.0;
    double impuestoValor = 0.0;

    String informacionAdicionalObservacion = "";
    String informacionAdicionalDireccion = "";

    BundleMessages bundleMessages = new BundleMessages();

    /**
     * Metodo que carga la factura en la base de datos
     */
    public void cargarFactura(String pathFile) {
        String tipoDocumento = "FX";
        String tipoFactura = "RX";
        String companiaDocumento = "00001";
        int numeroDocumento = indicesService.getT0022Secuencial(companiaDocumento, tipoDocumento, getCurrentYear());
        int numeroFactura = indicesService.getT0022Secuencial(companiaDocumento, tipoFactura, getCurrentYear());

        Autorizacion autorizacion = Route.getAuthorization(pathFile);
        Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);

        Detalles detalles = factura.getDetalles();
        detalles.getDetalle().forEach(detalle -> {
            T57011 t57011 = new T57011();
            t57011.setId(new T57011Id());

            calcularValoresIva(detalle);

            t57011.getId().setSzComputerId("-");
            t57011.getId().setMnJobNumber(indicesService.getT00221Secuencial("t57011z1"));
            t57011.setSzBachType("");
            t57011.setMnBachNumber(0);
            t57011.getId().setMnDocumentNumber(numeroDocumento);
            t57011.getId().setSzDocumentType(tipoDocumento);
            t57011.getId().setSzDocumentCompany(companiaDocumento);
            t57011.getId().setMnInvoiceNumber(numeroFactura);
            t57011.getId().setSzInvoiceType(tipoFactura);
            t57011.getId().setSzInvoiceCompany(companiaDocumento);
            t57011.setSzReferenceLegal(
                    factura.getInfoTributaria().getEstab() + "-" +
                            factura.getInfoTributaria().getPtoEmi() + "-" +
                            factura.getInfoTributaria().getSecuencial());
            t57011.setSzReference("");
            t57011.getId().setMnLineNumber(getLineNumber());
            t57011.getId().setMnSequenceNumber(0);
            t57011.getId().setMnSubSequenceNumber(0);
            t57011.setSzMember("LOADINV");
            t57011.setMnLegalNumber("9999999999");
            t57011.setJdDateEfective(new Date());
            t57011.setJdDateExpired(new Date());
            t57011.setSzOperationType("Factura");
            t57011.getId().setSzJobTypeDescription("");
            t57011.setSzThruCaseStatusCode("");
            t57011.setMnCodCliente(0);
            t57011.setSzNameAlpha(factura.getInfoFactura().getRazonSocialComprador());
            t57011.setSzTaxID(factura.getInfoFactura().getIdentificacionComprador());
            t57011.setSzAddressLine01("");
            t57011.setSzAddressLine02("");
            t57011.setMnCodClienteShipTo(0);
            t57011.setSzBodega("");
            t57011.setSzCompany("");
            t57011.setSzName(factura.getInfoTributaria().getRazonSocial());
            t57011.setSzTaxIdentificationNumber(factura.getInfoTributaria().getRuc());
            t57011.setSzAddressLine1(factura.getInfoTributaria().getDirMatriz());
            t57011.setSzAddressLine2(factura.getInfoFactura().getDirEstablecimiento());
            t57011.setSzAddressLine3(factura.getInfoFactura().getDireccionComprador());
            t57011.setSzAddressLine4("");
            t57011.setMnCodItemNumberShort(0);
            t57011.setSzPrintDataYN("");
            t57011.setSzDescription(detalle.getDescripcion());
            t57011.setSzDescription2("");
            t57011.setMnItemNumber("0");
            t57011.setSzUnitofMeasureasInput("");
            t57011.setSzUnitofMeasurePricing("");
            t57011.setMnQuantityShipped(detalle.getCantidad().doubleValue());
            t57011.setMnUnitsQtyBackordered(0.0);
            t57011.setMnUnitsQuantityCanceledScrapped(0.0);
            t57011.setMnAmountPriceUnit(detalle.getPrecioUnitario().doubleValue());
            t57011.setMnAmountGross(0.0);
            t57011.setMnAmountExtendedPrice(baseImponibleIva0 + baseImponibleIva + baseImponibleIvaVigente);
            t57011.setMnAmountExtendedCost(0.0);
            t57011.setMnPercent1(0.0);
            t57011.setJdDateRequested(new Date());
            t57011.setSzCommitted("");
            t57011.setSzLineType("");
            t57011.setJdDateInvoice(convertirFechaEmision(factura.getInfoFactura().getFechaEmision()));
            t57011.setJdDateNetDue(new Date());
            t57011.setMnRelatedNumber(0);
            t57011.setSzRelatedOrderType("");
            t57011.setSzCompanyRelatedOrder("");
            t57011.setSzPrintMessage("");
            t57011.setSzTaxRateArea("");
            t57011.setSzTaxRateArea("");
            t57011.setSzTaxExplCode("");
            t57011.setSzDescriptionTaxArea("");
            t57011.setMnTaxAuthority(0.0);
            t57011.setMnTaxAuthority2(0.0);
            t57011.setMnTaxAuthority3(0.0);
            t57011.setMnTaxAuthority4(0.0);
            t57011.setMnTaxAuthority5(0.0);
            t57011.setMnTaxRate1(Double.valueOf(impuestoCodigo));
            t57011.setMnTaxRate2(Double.valueOf(impuestoCodigoPorcentaje));
            t57011.setMnTaxRate3(0.0);
            t57011.setMnTaxRate4(0.0);
            t57011.setMnTaxRate5(0.0);
            t57011.setSzTaxCalculationMethod("");
            t57011.setMnAmountExtendedPrice(impuestoBaseImponible);
            t57011.setMnAmountTax(impuestoValor);
            t57011.setMnAmountTaxable(0.0);
            t57011.setSzPaymentTermsCode("");
            t57011.setMnDiscountAvailable(0.0);
            t57011.setSzUserID("ROBOT-002");
            t57011.setSzProgramID("");
            t57011.setSzWorkStationID("-");
            t57011.setJdDateUpdated(new Date());

            // TODO: el campo de time of day no se esta guardando
            // t57011.setMnTimeofDay(LocalTime.now());

            t57011.setMnEDIDocumentNumber(0);
            t57011.setSzEDIDocumentType("");
            t57011.setSzEDIDocumentKeyCo("");
            t57011.setMnEDILineNumber(0);
            t57011.setMnOrderSuffix(0);
            t57011.setMnCodClienteParent(0);
            t57011.setMnDiscountAmount(detalle.getDescuento().doubleValue());
            t57011.setMnAmountSalesTaxTotal1(factura.getInfoFactura().getPropina().doubleValue());
            t57011.setMnAmountSalesTaxTotal2(0.0);
            t57011.setMnAmountSalesTaxTotal3(0.0);
            t57011.setMnAmountSalesTaxTotal4(0.0);
            t57011.setMnAmountSalesTaxTotal5(0.0);
            t57011.setMnAmountNonTaxable(0.0);
            t57011.setMnAmountListPrice(0.0);
            t57011.setSz2ndItemNumber(detalle.getCodigoPrincipal());
            t57011.setMnCarrierNumber(0);
            t57011.setSzAgreementSupplementDistribution("");
            t57011.setSzEstablecimiento("");
            t57011.setMnTripNumber(0);
            t57011.setMnWeightResult(0.0);
            t57011.setSzDutyStatus("");
            t57011.setSzLotSerialNumber("");
            t57011.setSzParameterDataItem01("");
            t57011.setSzParameterDataItem02("");
            t57011.setSzParameterDataItem03("");
            t57011.setSzParameterDataItem04(factura.getInfoTributaria().getContribuyenteRimpe());
            t57011.setSzParameterDataItem05(factura.getInfoTributaria().getAgenteRetencion());
            t57011.setSzParameterDataItem06(getObservacionDeInfoAdicional(factura.getInfoAdicional()));
            t57011.setSzParameterDataItem07("");
            t57011.setSzParameterDataItem08("");
            t57011.setSzParameterDataItem09("");
            t57011.setSzParameterDataItem10("");
            t57011.setSzLegalDocumentTitle("");
            t57011.setSzClaveAcceso(factura.getInfoTributaria().getClaveAcceso());
            t57011.setSzClaveAccesoContingencia("");
            t57011.setSzAutorizacionElectronica(autorizacion.getNumeroAutorizacion());
            t57011.setSzRefAutorizacion1(String.valueOf(autorizacion.getFechaAutorizacion()));
            t57011.setSzAddressLine3(getDireccionDeInfoAdicional(factura.getInfoAdicional()));
            t57011.setSzRefAutorizacion2("");
            t57011.setSzRefAutorizacion3("");
            t57011.setSzRefAutorizacion4("");
            t57011.setSzAmbiente(autorizacion.getAmbiente());
            t57011.setSzTipoEmision(factura.getInfoTributaria().getTipoEmision());
            t57011.setSzContribuyenteEspecial(factura.getInfoFactura().getContribuyenteEspecial());
            t57011.setSzObligadoContabilidad(String.valueOf(factura.getInfoFactura().getObligadoContabilidad()));
            t57011.setSzMoneda(factura.getInfoFactura().getMoneda());
            t57011.setSzCatSales01(factura.getInfoFactura().getTipoIdentificacionComprador());
            t57011.setSzCatSales02("");
            t57011.setSzCatSales03("");
            t57011.setSzCatSales04("");
            t57011.setSzCatSales05("");
            t57011.setSzPeriodoFiscal("");
            t57011.setSzRise("");
            try {
                t57011CrudRepositorio.save(t57011);
            } catch (Exception e) {
                log.warn("Error al guardar la factura: {}", e.toString());
            }
        });
    }

    /**
     * Metodo que obtiene el año actual
     * 
     * @return
     */
    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Metodo para crear un numero secuencial de ingreso de linea.
     */
    private int getLineNumber() {
        return i++;
    }

    /**
     * Metodo que carga los valores de los impuestos de la factura.
     * 
     * Carga codigo de impuesto y codigo de porcentaje.
     * 
     * Evalua el codigo de impuesto y el codigo del porcentaje, en el caso de IVA se toma el iva 0.
     * 
     * Luego verifica el ICE y el IRBPNR.
     * 
     * Presentar los valores de los impuestos en el log para validacion.
     * 
     * @param detalle
     */
    private void calcularValoresIva(Factura.Detalles.Detalle detalle) {
        detalle.getImpuestos().getImpuesto().forEach(impuesto -> {
            if (impuesto.getCodigo() != null && impuesto.getCodigo().length() > 0) {
                impuestoCodigo = Integer.valueOf(impuesto.getCodigo());
            }
            if (impuesto.getCodigoPorcentaje() != null && impuesto.getCodigoPorcentaje().length() > 0) {
                impuestoCodigoPorcentaje = Integer.valueOf(impuesto.getCodigoPorcentaje());
            }

            impuestoBaseImponible = impuesto.getBaseImponible().doubleValue();
            impuestoValor = impuesto.getValor().doubleValue();

            switch (impuestoCodigo) {
                case 2:
                    baseImponibleIva += impuesto.getBaseImponible().doubleValue();
                    valorIva += impuesto.getValor().doubleValue();

                    if (impuestoCodigoPorcentaje == 0) {
                        baseImponibleIva0 += impuesto.getBaseImponible().doubleValue();
                    } else {
                        baseImponibleIvaVigente += impuesto.getBaseImponible().doubleValue();
                        valorIvaVigente += impuesto.getValor().doubleValue();
                        log.info("IVA: {} {} {}",
                                impuesto.getBaseImponible(),
                                impuesto.getValor(),
                                bundleMessages.getMessage("iva_" + impuestoCodigoPorcentaje));
                    }
                    montoTotalConImpuestos += impuesto.getBaseImponible().doubleValue()
                            + impuesto.getValor().doubleValue();

                    break;
                case 3:
                    baseImponibleICE += impuesto.getBaseImponible().doubleValue();
                    valorICE += impuesto.getValor().doubleValue();
                    break;
                case 5:
                    baseImponibleIRBPNR += impuesto.getBaseImponible().doubleValue();
                    valorIRBPNR += impuesto.getValor().doubleValue();
                    break;
                default:
                    log.info("El codigo no de impuesto {} no se reconoce", impuestoCodigo);
                    break;
            }
        });

        log.info("impuesto: {} {} {} {} {} {} {} {} {} {} {}",
                baseImponibleIva0,
                baseImponibleIva,
                valorIva,
                baseImponibleIvaVigente,
                valorIvaVigente,
                baseImponibleICE,
                valorICE,
                baseImponibleIRBPNR,
                valorIRBPNR,
                mensajeInfoAdicional,
                montoTotalConImpuestos);
    }

    /**
     * Metodo que convierte la fecha de la factura al formato de la base de datos y
     * espera errores.
     * 
     * @param date
     * @return
     */
    private Date convertirFechaEmision(String date) {
        try {
            SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dmyFormat.parse(date);
        } catch (Exception ex) {
            log.info("Error al convertir la fecha 1 {}", ex.toString());
        }
        try {
            SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dmyFormat.parse(date);
        } catch (Exception ex) {
            log.info("Error al convertir la fecha 2 {}", ex.toString());
        }
        return new Date();
    }

    /**
     * Metodo que obtiene la observacion de la factura desde la informacion
     * adicional.
     * 
     * @param infoAdicional
     * @return
     */
    private String getObservacionDeInfoAdicional(Factura.InfoAdicional infoAdicional) {
        infoAdicional.getCampoAdicional().forEach(campo -> {

            if (campo.getNombre() != null && campo.getNombre().toUpperCase().startsWith("OBERVACI")) {
                informacionAdicionalObservacion = campo.getValue();
            }
        });
        return informacionAdicionalObservacion;
    }

    /**
     * Metodo que obtiene la direccion de la factura desde la informacion adicional.
     * 
     * @param infoAdicional
     * @return
     */
    private String getDireccionDeInfoAdicional(Factura.InfoAdicional infoAdicional) {
        infoAdicional.getCampoAdicional().forEach(campo -> {

            if (campo.getNombre() != null && campo.getNombre().toUpperCase().startsWith("DIRECCI")) {
                informacionAdicionalDireccion = campo.getValue();
            }
        });
        return informacionAdicionalDireccion;
    }
}
