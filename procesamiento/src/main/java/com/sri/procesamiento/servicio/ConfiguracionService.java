package com.sri.procesamiento.servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.estructura.persistencia.crud.ClientesCrudRepositorio;
import com.leon.estructura.persistencia.crud.ParametroCrudRepositorio;
import com.leon.estructura.persistencia.entidad.Cliente;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.sri.procesamiento.Constantes;

/**
 * Servicio de Cliente
 * 
 * @author omargo33
 * @since 2024-03-28
 * 
 */
@Service
@Transactional
public class ConfiguracionService {

   @Autowired
   private ClientesCrudRepositorio clientesCrudRepositorio;

   @Autowired
   private ParametroCrudRepositorio parametroCrudRepositorio;

   public Optional<List<Cliente>> getClientes() {
      return clientesCrudRepositorio.findAllActivos();
   }

   /**
    * Metodo para obtener todos los parametros que intervienen en la el proceso de
    * archivos del SRI.
    *
    */

   public Optional<List<Parametro>> getParametros() {
      return parametroCrudRepositorio.findByIndices(
            List.of(
                  Constantes.INDEX_USER_ID,
                  Constantes.INDEX_SECRET_ID,
                  Constantes.INDEX_MASTER_CREDENCIAL,
                  Constantes.INDEX_URL_TOKEN,
                  Constantes.INDEX_URL_SOLICITUD_DOCUMENTOS_RECIBIDOS,
                  Constantes.INDEX_URL_DOCUMENTOS_ENVIADOS,
                  Constantes.INDEX_PATH_CERTIFICADO_DIGITAL)

      );
   }
}
