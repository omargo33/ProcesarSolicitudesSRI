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

import com.leon.batch.Constantes;

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
@Transactional
public class ConfiguracionService {

   @Autowired
   private ClientesCrudRepositorio clientesCrudRepositorio;

   @Autowired
   private ParametroCrudRepositorio parametroCrudRepositorio;

   /**
    * Metodo para consultar el token de acceso al servicio del SRI.
    * 
    * @param ruc
    * @return
    */
   public Optional<List<Cliente>> getClientes() {
      return clientesCrudRepositorio.findAllActivos();
   }

   /**
    * Metodo para obtener todos los parametros que intervienen en la el proceso de
    * archivos del SRI.
    * 
    * @return
    */
   public Map<Integer, Parametro> generarParametros() {
      Map<Integer, Parametro> mapaParametros = new HashMap<>();

      Optional<List<Parametro>> listaParametros = parametroCrudRepositorio.findByIndices(
            Arrays.asList(
                  Constantes.INDEX_USER_ID,
                  Constantes.INDEX_SECRET_ID,
                  Constantes.INDEX_GRANT_TYPE,
                  Constantes.INDEX_URL_TOKEN,
                  Constantes.INDEX_URL_DOCUMENTOS_RECIBIDOS,
                  Constantes.INDEX_URL_DESCARGA_AUTORIZACION));

      if (listaParametros.isPresent()) {
         for (Parametro parametro : listaParametros.get()) {
            mapaParametros.put(parametro.getIndice(), parametro);
         }
      }

      return mapaParametros;
   }
}