package com.leon.batch.servicio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicaciones13.documentos.estructuras.autorizacion.Autorizacion;
import com.aplicaciones13.documentos.utilidades.Conversion;
import com.leon.batch.Constantes;
import com.leon.batch.cliente.DescargarConsumo;
import com.leon.batch.cliente.SolicitaServicio;
import com.leon.batch.cliente.TokenConsumo;
import com.leon.batch.cliente.estructuras.TokenOk;
import com.leon.batch.utilitarios.Archivos;
import com.leon.estructura.persistencia.crud.ResumenDocumentoProveedorCrudRepositorio;
import com.leon.estructura.persistencia.crud.T57011CrudRepositorio;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.leon.estructura.persistencia.entidad.ResumenDocumentoProveedor;
import com.leon.estructura.persistencia.entidad.T57011;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Setter
@Transactional
public class DescargaService {

    Map<Integer, Parametro> mapaParametros;

    @Autowired
    private ResumenDocumentoProveedorCrudRepositorio resumenDocumentoProveedorCrudRepositorio;

    @Autowired
    private T57011CrudRepositorio t57011CrudRepositorio;

    @Autowired
    private IndicesService indicesService;

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

                Autorizacion authorization = Conversion.xmlToPojo(descargarConsumo.getRespuesta(), Autorizacion.class);
                log.info("Fecha Autorizacion: {}", authorization.getFechaAutorizacion());
                log.info("Fecha Autorizacion: {}", authorization.getNumeroAutorizacion());
            } else {
                log.error("No se puede obtener el XML autorizado. {}", descargarConsumo.toString());
            }
        }
    }

    private void guardarData(){



SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
    Date date = new Date();  
    int currentYear = Integer.parseInt(formatter.format(date));  

        indicesService.getT0022Secuencial("00001", "FX", currentYear);

        T57011 t57011 = new T57011();
        
        t57011.getId().setSzDocumentCompany("00001");
        t57011.getId().setSzDocumentType("FX");


       /*  t57011.getId().setSzDocumentCompany(empresaDocumento);
        t57011.getId().setSzDocumentType(tipoDocumento);
        t57011.getId().setMnDocumentNumber(nroDocumento);
        t57011.getId().setMnLineNumber(String.valueOf(i + 1));
        t57011.getId().setSzInvoiceCompany(empresaComprobante);
        t57011.getId().setSzInvoiceType(tipoComprobante);
        t57011.getId().setMnInvoiceNumber(nroComprobante);
        t57011.setMnLegalNumber("9999999999");
        t57011.getId().setMnJobNumber(nroTrabajo);
        t57011.setSzUserID("ROBOT");
        t57011.getId().setJdDateUpdated(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd"));
        t57011.getId().setSzMember("LOADINV");
        t57011.setSzWorkStationID("-");
        t57011.setSzComputerID("-");
        t57011.getId().setMnTimeofDay(MainFechaString.getHora());
        t57011.getId().setSzAutorizacionElectronica(nroAutorizacion);
        t57011.getId().setSzRefAutorizacion1(fechaAutorizacion);


        t57011CrudRepositorio.save(t57011);

*/
    }
}
