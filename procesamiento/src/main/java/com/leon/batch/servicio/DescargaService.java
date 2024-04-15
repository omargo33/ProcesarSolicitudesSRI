package com.leon.batch.servicio;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.leon.batch.Constantes;
import com.leon.batch.cliente.DescargarConsumo;
import com.leon.batch.cliente.SolicitaServicio;
import com.leon.batch.cliente.TokenConsumo;
import com.leon.batch.cliente.estructuras.TokenOk;
import com.leon.batch.cliente.estructuras.autorizacion.Authorization;
import com.leon.batch.utilitarios.ConversionesFecha;
import com.leon.estructura.persistencia.crud.ResumenDocumentoProveedorCrudRepositorio;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.leon.estructura.persistencia.entidad.ResumenDocumentoProveedor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DescargaService {

    Map<Integer, Parametro> mapaParametros;

    @Autowired
    private ResumenDocumentoProveedorCrudRepositorio resumenDocumentoProveedorCrudRepositorio;

    /**
     * Metodo para consultar el token de acceso al servicio del SRI.
     * 
     * @param ruc
     * @return
     */
    public void descargarDocumentosRecibidos(String ruc, String credencial) {
        TokenConsumo tokenConsumo = new TokenConsumo();
        int estadoConsumo = tokenConsumo.load(
                mapaParametros.get(Constantes.INDEX_URL_TOKEN).getTextoA(),
                mapaParametros.get(Constantes.INDEX_USER_ID).getTextoA(),
                mapaParametros.get(Constantes.INDEX_SECRET_ID).getTextoA(),
                mapaParametros.get(Constantes.INDEX_GRANT_TYPE).getTextoA());

        if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
            TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
            consumirServcioDescarga(tokenOk.getAccessToken(), ruc, credencial);
        } else {
            log.error("tokenConsumo: " + tokenConsumo.toString());
        }
    }

    /**
     * Metodo para probar la lista de documentos recibidos.
     *
     * @param token
     * @param ruc
     * 
     */
    private void consumirServcioDescarga(String token, String ruc, String credencial) {
        DescargarConsumo descargarConsumo = new DescargarConsumo();

        Optional<List<ResumenDocumentoProveedor>> listaDocumentosADescargar = resumenDocumentoProveedorCrudRepositorio
                .findBySzClaveAccesoNotInT57011();
        if (!listaDocumentosADescargar.isPresent()) {
            log.error("No hay XML autorizado para descargar");
            return;
        }

        for (ResumenDocumentoProveedor documento : listaDocumentosADescargar.get()) {
            int estadoConsumo = descargarConsumo.load(
                    mapaParametros.get(Constantes.INDEX_URL_DESCARGA_AUTORIZACION).getTextoA(),
                    token, ruc, credencial, documento.getAccessKey());

            if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
                String respuesta = descargarConsumo.getRespuesta();

                Authorization authorization = descargarConsumo.construirAuthorization(descargarConsumo.getRespuesta());
                System.out.println("Documento: " + respuesta);
                System.out.println("Ambiente: " + authorization.getAmbiente());
                System.out.println("Estado: " + authorization.getEstado());
                System.out.println("Fecha Autorizacion: " + authorization.getFechaAutorizacion());
                System.out.println("Fecha Autorizacion: " + ConversionesFecha.stringDateIso(authorization.getFechaAutorizacion()));

                System.out.println("No autorizacion: " + authorization.getNumeroAutorizacion());

                System.out.println("Documento: " + authorization.getComprobante());

                
                

            } else {
                log.error("No se puede obtener el XML autorizado. " + descargarConsumo.toString());
            }
        }

    }

}
