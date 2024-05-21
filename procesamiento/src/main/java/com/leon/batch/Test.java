package com.leon.batch;

import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura.Detalles;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.aplicaciones13.documentos.utilidades.Route;
import com.leon.batch.utilitarios.BundleMessages;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

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

    public static void main(String[] args) {
        Test test = new Test();
        test.procesar();

    }

    public void procesar() {
        Autorizacion autorizacion = Route.getAuthorization(
                "/home/ovelez/Documentos/clientes/Leon/documentos/0103153425001/1791984722001/01/2024-04-02/27210020000853005932341.xml");
        Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);

        Detalles detalles = factura.getDetalles();
        detalles.getDetalle().forEach(detalle -> {
            log.info("factura: {} {} {} {} {} {} {} {} {} {} {} {}",
                    factura.getInfoTributaria().getRazonSocial(),
                    factura.getInfoTributaria().getRuc(),
                    factura.getInfoTributaria().getClaveAcceso(),
                    factura.getInfoTributaria().getCodDoc(),
                    factura.getInfoTributaria().getEstab(),
                    factura.getInfoTributaria().getPtoEmi(),
                    factura.getInfoTributaria().getSecuencial(),
                    factura.getInfoTributaria().getDirMatriz(),
                    factura.getInfoTributaria().getAgenteRetencion(),
                    factura.getInfoTributaria().getContribuyenteRimpe(),
                    factura.getInfoTributaria().getTipoEmision(),
                    factura.getInfoTributaria().getAmbiente());

            log.info("infoFactura {} {} {} {} {} {} {} {} {} {} ", factura.getInfoFactura().getFechaEmision(),
                    factura.getInfoFactura().getDirEstablecimiento(),
                    factura.getInfoFactura().getContribuyenteEspecial(),
                    factura.getInfoFactura().getObligadoContabilidad(),
                    factura.getInfoFactura().getTipoIdentificacionComprador(),
                    factura.getInfoFactura().getRazonSocialComprador(),
                    factura.getInfoFactura().getIdentificacionComprador(),
                    factura.getInfoFactura().getDireccionComprador()
            // , factura.getInfoFactura().getRise()
                    , factura.getInfoFactura().getMoneda(), factura.getInfoFactura().getPropina());

            montoTotalConImpuestos += factura.getInfoFactura().getPropina().doubleValue();

            log.info("detalle: {} {} {} {} {} {} {} {} {}", String.valueOf(detalle.getCantidad()),
                    detalle.getCodigoAuxiliar(),
                    detalle.getCodigoPrincipal(), detalle.getDescripcion(), detalle.getDescuento().toString(),
                    String.valueOf(detalle.getPrecioSinSubsidio()), String.valueOf(detalle.getPrecioTotalSinImpuesto()),
                    String.valueOf(detalle.getPrecioUnitario()), detalle.getUnidadMedida());

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

            try {
                detalle.getDetallesAdicionales().getDetAdicional().forEach(detalleAdicional -> {
                    log.info("detalle adicional: {} {}", detalleAdicional.getNombre(),
                            String.valueOf(detalleAdicional.getValor()));
                });

            } catch (NullPointerException e) {
                log.info("No hay detalles adicionales");
            }

            try {
                factura.getInfoAdicional().getCampoAdicional().forEach(campoAdicional -> {
                    String nombre = campoAdicional.getNombre();
                    String valor = campoAdicional.getValue();
                    mensajeInfoAdicional = mensajeInfoAdicional + String.format("%s: %s;", nombre, valor);

                    if (nombre != null && nombre.toUpperCase().startsWith("DIRECCI")) {
                        log.info("campo adicional direccion: {} {}", nombre, valor);
                    }
                    if (nombre != null && nombre.toUpperCase().startsWith("OBERVACI")) {
                        log.info("campo adicional observacion: {} {}", nombre, valor);
                    }
                });

                if (mensajeInfoAdicional != null && !mensajeInfoAdicional.isEmpty()) {
                    log.info("mensajeInfoAdicional: {}", mensajeInfoAdicional);
                }
            } catch (Exception e) {
                log.error("No hay campos adicionales", e.toString());
            }
        });
    }
}
