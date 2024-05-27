package com.leon.batch.servicio;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.estructura.persistencia.crud.ResumenDocumentoProveedorCrudRepositorio;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.leon.estructura.persistencia.entidad.ResumenDocumentoProveedor;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.leon.batch.Constantes;
import com.leon.batch.cliente.DocumentosRecibidosConsumo;
import com.leon.batch.cliente.SolicitaServicio;
import com.leon.batch.cliente.TokenConsumo;
import com.leon.batch.cliente.estructuras.Documento;
import com.leon.batch.cliente.estructuras.DocumentosOk;
import com.leon.batch.cliente.estructuras.TokenOk;
import com.leon.batch.datasource.DataSourceContextHolder;
import com.leon.batch.utilitarios.ConversionesFecha;
import java.util.Map;

/**
 * Servicio de Cliente
 * 
 * @author omargo33
 * @since 2024-03-28
 * 
 */
@Service
@Slf4j
@Setter
@Transactional
public class DocumentosRecibidosService {

   Map<Integer, Parametro> mapaParametros;

   @Autowired
   private ResumenDocumentoProveedorCrudRepositorio resumenDocumentoProveedorCrudRepositorio;

   /**
    * Metodo para consultar el token de acceso al servicio del SRI.
    * 
    * @param ruc
    * @return
    */
   public void consultarDocumentosRecibidos(String ruc, String credencial) {
      TokenConsumo tokenConsumo = new TokenConsumo();
      int estadoConsumo = tokenConsumo.load(
            mapaParametros.get(Constantes.INDEX_URL_TOKEN).getTextoA(),
            mapaParametros.get(Constantes.INDEX_USER_ID).getTextoA(),
            mapaParametros.get(Constantes.INDEX_SECRET_ID).getTextoA(),
            mapaParametros.get(Constantes.INDEX_GRANT_TYPE).getTextoA());

      if (estadoConsumo == SolicitaServicio.SERVICIO_OK) {
         TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
         consumirServicioDocumentosRecibidos(tokenOk.getAccessToken(), ruc, credencial);
      } else {
         log.error("No se ha podido obtener el token de acceso. {}", tokenConsumo.toString());
      }
   }

   /**
    * Metodo para probar la lista de documentos recibidos.
    *
    * @param token
    * @param ruc
    * 
    */
   private void consumirServicioDocumentosRecibidos(String token, String ruc, String credencial) {
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
         guardarDocumentosRecibidos(ruc, documentosOk.getData());
      } else {
         log.error("No se puede obtener los documentos recibidos. {}", descargarDocumentosConsumo.toString());
      }
   }

   /**
    * Metodo para guardar los documentos recibidos.
    * 
    * @param keyDatasoruce
    * @param arregloDocumentos
    */
   private void guardarDocumentosRecibidos(String keyDatasoruce, Documento[] arregloDocumentos) {
      DataSourceContextHolder.setBranchContext(keyDatasoruce);

      for (Documento documento : arregloDocumentos) {
         resumenDocumentoProveedorCrudRepositorio.save(crearEntidad(documento));
      }
   }

   /**
    * Metodo para mapear los documentos recibidos a la entidad de resumen a la
    * entidad.
    *
    * documento.getIssuedAt() -> Llega vacio y se pone la fecha IssuedAtFormatted
    * 
    * @param documento
    * @return
    */
   private ResumenDocumentoProveedor crearEntidad(Documento documento) {
      ResumenDocumentoProveedor resumenDocumentoProveedor = new ResumenDocumentoProveedor();
      resumenDocumentoProveedor.setAccessKey(documento.getAccessKey());
      resumenDocumentoProveedor.setCommercialName(documento.getCommercialName());
      resumenDocumentoProveedor.setDocumentId(documento.getDocumentId());
      resumenDocumentoProveedor.setDocumentType(documento.getDocumentType());
      resumenDocumentoProveedor.setDocumentTypeId(documento.getDocumentTypeId());
      resumenDocumentoProveedor.setEstablishment(documento.getEstablishment());
      resumenDocumentoProveedor.setIssuedAt(
         ConversionesFecha.stringAFecha(
            documento.getIssuedAtFormatted(), "dd/MM/yyyy")
            );
      resumenDocumentoProveedor.setIssuedAtFormatted(documento.getIssuedAtFormatted());
      resumenDocumentoProveedor.setPointIssue(documento.getPointIssue());
      resumenDocumentoProveedor.setRucIssuer(documento.getRucIssuer());
      resumenDocumentoProveedor.setSequence(documento.getSequence());
      resumenDocumentoProveedor.setSocialNameIssuer(documento.getSocialNameIssuer());
      resumenDocumentoProveedor.setTaxpayerId(documento.getTaxpayerId());
      resumenDocumentoProveedor.setTip(BigDecimal.valueOf(documento.getTip()));
      resumenDocumentoProveedor.setTotalAmount(BigDecimal.valueOf(documento.getTotalAmount()));
      resumenDocumentoProveedor.setTotalDiscount(BigDecimal.valueOf(documento.getTotalDiscount()));
      resumenDocumentoProveedor.setTotalValueWithoutTaxes(BigDecimal.valueOf(documento.getTotalValueWithoutTaxes()));

      return resumenDocumentoProveedor;
   }
}