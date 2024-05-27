package com.leon.batch.servicio;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.batch.Constantes;
import com.leon.batch.cliente.DescargarConsumo;
import com.leon.batch.cliente.SolicitaServicio;
import com.leon.batch.cliente.TokenConsumo;
import com.leon.batch.cliente.estructuras.TokenOk;
import com.leon.batch.utilitarios.Archivos;
import com.leon.estructura.persistencia.crud.ResumenDocumentoProveedorCrudRepositorio;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.leon.estructura.persistencia.entidad.ResumenDocumentoProveedor;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import lombok.AccessLevel;

@Service
@Slf4j
@Setter
@Getter
@Transactional
public class DescargaService {

    @Getter(AccessLevel.NONE)
    Map<Integer, Parametro> mapaParametros;

    @Setter(AccessLevel.NONE)
    List<String> listaArchivos = new ArrayList<>();

    @Autowired
    private ResumenDocumentoProveedorCrudRepositorio resumenDocumentoProveedorCrudRepositorio;

    /**
     * Metodo para consultar el token de acceso al servicio del SRI.
     * 
     * @param ruc
     * @return
     */
    public String getToken() {
        TokenConsumo tokenConsumo = new TokenConsumo();
        int estadoConsumo = tokenConsumo.load(
                mapaParametros.get(Constantes.INDEX_URL_TOKEN).getTextoA(),
                mapaParametros.get(Constantes.INDEX_USER_ID).getTextoA(),
                mapaParametros.get(Constantes.INDEX_SECRET_ID).getTextoA(),
                mapaParametros.get(Constantes.INDEX_GRANT_TYPE).getTextoA());

        if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
            TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
            return tokenOk.getAccessToken();
        } else {
            return null;
        }
    }

    /**
     * Metodo para probar la lista de documentos recibidos.
     *
     * @param token
     * @param ruc
     * 
     */
    public void descargarDocumentosRecibidos(String ruc, String credencial) {
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
                    getToken(), ruc, credencial, documento.getAccessKey());

            if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
                String respuesta = descargarConsumo.getRespuesta();
                String pathUser = System.getProperty("user.dir");

                String ruta = Archivos.crearRutaClaveAccesoRUC(documento.getAccessKey(), ruc, pathUser);
                Archivos.guardarArchivo(ruta, respuesta);
            } else {
                log.error("No se puede obtener el XML autorizado. {}", descargarConsumo.toString());
            }
        }
    }
}
