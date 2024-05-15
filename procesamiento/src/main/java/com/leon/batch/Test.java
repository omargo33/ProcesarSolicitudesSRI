package com.leon.batch;

import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura.Detalles;
import com.aplicaciones13.documentos.estructuras.factura.v2_1_0.Factura;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.aplicaciones13.documentos.utilidades.Route;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {

        Autorizacion autorizacion = Route.getAuthorization(
                "/home/ovelez/Documentos/clientes/Leon/documentos/0103153425001/1791984722001/01/2024-04-02/27210020000853005932341.xml");

        log.info(autorizacion.getComprobante());
        Factura factura = Conversion.xmlToPojo(autorizacion.getComprobante(), Factura.class);
        log.info(factura.getInfoTributaria().getRuc());

        Detalles detalles = factura.getDetalles();

        detalles.getDetalle().forEach(detalle -> {
            log.info(detalle.getDescripcion());
        });
    }
}
