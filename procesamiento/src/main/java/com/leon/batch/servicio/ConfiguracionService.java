package com.leon.batch.servicio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.estructura.persistencia.crud.ClientesCrudRepositorio;
import com.leon.estructura.persistencia.crud.ParametroCrudRepositorio;
import com.leon.estructura.persistencia.entidad.Cliente;
import com.leon.estructura.persistencia.entidad.Parametro;

import lombok.extern.slf4j.Slf4j;

import com.leon.batch.Constantes;
import com.leon.batch.cliente.DocumentosRecibidosConsumo;
import com.leon.batch.cliente.SolicitaServicio;
import com.leon.batch.cliente.TokenConsumo;
import com.leon.batch.cliente.estructuras.Documento;
import com.leon.batch.cliente.estructuras.DocumentosOk;
import com.leon.batch.cliente.estructuras.TokenOk;

import java.util.Map;
import java.util.HashMap;

/**
 * Servicio de Cliente
 * 
 * @author omargo33
 * @since 2024-03-28
 * 
 */
@Service
@Slf4j
@Transactional
public class ConfiguracionService {

   @Autowired
   private ClientesCrudRepositorio clientesCrudRepositorio;

   @Autowired
   private ParametroCrudRepositorio parametroCrudRepositorio;

   Map<Integer, Parametro> mapaParametros = new HashMap<>();

   public Optional<List<Cliente>> getClientes() {
      return clientesCrudRepositorio.findAllActivos();
   }

   /**
    * Metodo para obtener todos los parametros que intervienen en la el proceso de
    * archivos del SRI.
    * 
    * @return
    */
   public void generarParametros() {

      Optional<List<Parametro>> listaParametros = parametroCrudRepositorio.findByIndices(
            Arrays.asList(
                  Constantes.INDEX_USER_ID,
                  Constantes.INDEX_SECRET_ID,
                  Constantes.INDEX_GRANT_TYPE,
                  Constantes.INDEX_URL_TOKEN,
                  Constantes.INDEX_URL_DOCUMENTOS_RECIBIDOS,
                  Constantes.INDEX_URL_DESCARGA_AUTORIZACION));

      for (Parametro parametro : listaParametros.get()) {
         mapaParametros.put(parametro.getIndice(), parametro);
      }
   }

   /**
    * Metodo para consultar el token de acceso al servicio del SRI.
    * 
    * @param ruc
    * @return
    */
   public void consultarToken(String ruc, String credencial) {
      TokenConsumo tokenConsumo = new TokenConsumo();
      int estadoConsumo = tokenConsumo.load(
            mapaParametros.get(Constantes.INDEX_URL_TOKEN).getTextoA(),
            mapaParametros.get(Constantes.INDEX_USER_ID).getTextoA(),
            mapaParametros.get(Constantes.INDEX_SECRET_ID).getTextoA(),
            mapaParametros.get(Constantes.INDEX_GRANT_TYPE).getTextoA());

      if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
         TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
         probarListaDocumentos(tokenOk.getAccessToken(), ruc, credencial);
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
   private void probarListaDocumentos(String token, String ruc, String credencial) {
      DocumentosRecibidosConsumo descargarDocumentosConsumo = new DocumentosRecibidosConsumo();
      int estadoConsumo = descargarDocumentosConsumo.load(
            mapaParametros.get(Constantes.INDEX_URL_DOCUMENTOS_RECIBIDOS).getTextoA(),
            token,
            ruc,
            credencial,
            String.format("%02d", java.time.LocalDate.now().getMonthValue()),
            String.valueOf(java.time.LocalDate.now().getYear()));
      if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
         DocumentosOk documentosOk = descargarDocumentosConsumo.getJsonRespuesta(DocumentosOk.class);
         for (Documento documento : documentosOk.getData()) {
            log.info("Documento: " + documento.toString());
         }
      } else {
         log.error("No se puede obtener los documentos recibidos. " + descargarDocumentosConsumo.toString());
      }
   }
}
