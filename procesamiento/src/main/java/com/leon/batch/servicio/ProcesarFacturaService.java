package com.leon.batch.servicio;

import com.leon.estructura.persistencia.crud.T57011CrudRepositorio;
import com.leon.estructura.persistencia.entidad.T57011;

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

@Slf4j
@Service
@Transactional
public class ProcesarFacturaService {

    @Autowired
    private T57011CrudRepositorio t57011CrudRepositorio;

    @Autowired
    private IndicesService indicesService;

    int i=0;

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

    BundleMessages bundleMessages = new BundleMessages();



    /** 
     * Metodo que carga la factura en la base de datos
     */
    public void cargarFactura() {

        String tipoDocumento = "FX";
        String tipoFactura = "RX";
        String companiaDocumento = "00001";
        int numeroDocumento = indicesService.getT0022Secuencial(companiaDocumento, tipoDocumento, getCurrentYear());
        int numeroFactura = indicesService.getT0022Secuencial(companiaDocumento, tipoFactura, getCurrentYear());
        
        Autorizacion autorizacion = Route.getAuthorization(
                "/home/ovelez/Documentos/clientes/Leon/documentos/0103153425001/1791984722001/01/2024-04-02/27210020000853005932341.xml");
        Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);

        Detalles detalles = factura.getDetalles();
        detalles.getDetalle().forEach(detalle -> {
            T57011 t57011 = new T57011();
            cargarValoresIva(detalle);

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
                factura.getInfoTributaria().getEstab()+"-"+
                factura.getInfoTributaria().getPtoEmi()+"-"+
                factura.getInfoTributaria().getSecuencial()
            );
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
            t57011.setMnAmountExtendedPrice(baseImponibleIva0 + baseImponibleIva + baseImponibleIvaVigente );
            t57011.setMnAmountExtendedCost(0.0);
            t57011.setMnPercent1(0.0);
            t57011.setJdDateRequested(new Date());
            t57011.setSzCommitted("");

            

            
            t57011CrudRepositorio.save(t57011);
        });
    }

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
     * Metodo que carga los valores de los impuestos de la factura
     * 
     * @param detalle
     */
    private void cargarValoresIva(Factura.Detalles.Detalle detalle) {

        detalle.getImpuestos().getImpuesto().forEach(impuesto -> {
            if (impuesto.getCodigo().equals("2")) {
                baseImponibleIva += impuesto.getBaseImponible().doubleValue();
                valorIva += impuesto.getValor().doubleValue();

                if (impuesto.getCodigoPorcentaje().compareTo("0") == 0) {
                    baseImponibleIva0 += impuesto.getBaseImponible().doubleValue();
                } else {
                    baseImponibleIvaVigente += impuesto.getBaseImponible().doubleValue();
                    valorIvaVigente += impuesto.getValor().doubleValue();
                    log.info("IVA: {} {} {}", impuesto.getBaseImponible(), impuesto.getValor(),
                            // porcentajeIva(impuesto.getCodigoPorcentaje())
                            bundleMessages.getMessage("iva_" + impuesto.getCodigoPorcentaje()));
                }
                montoTotalConImpuestos += impuesto.getBaseImponible().doubleValue()
                        + impuesto.getValor().doubleValue();

            }
            if (impuesto.getCodigo().equals("3")) {
                baseImponibleICE += impuesto.getBaseImponible().doubleValue();
                valorICE += impuesto.getValor().doubleValue();
            }
            if (impuesto.getCodigo().equals("5")) {
                baseImponibleIRBPNR += impuesto.getBaseImponible().doubleValue();
                valorIRBPNR += impuesto.getValor().doubleValue();

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
}
