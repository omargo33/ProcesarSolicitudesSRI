package com.leon.batch.dominio;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leon.estructura.persistencia.entidad.Cliente;
import com.leon.batch.datasource.DataSourceContextHolder;
import com.leon.batch.servicio.ConfiguracionService;
import com.leon.batch.servicio.DocumentosRecibidosService;

import lombok.extern.slf4j.Slf4j;

import com.leon.estructura.persistencia.entidad.Parametro;

@Slf4j
@Component
@EnableScheduling
public class SchedulerProceso {

    @Autowired
    ConfiguracionService clienteService;

    @Autowired
    DocumentosRecibidosService documentosRecibidosService;

    Map<Integer, Parametro> mapaParametro;
    List<Cliente> listaClientes;

    /**
     * Metodo para ejecutar el proceso de consulta de documentos recibidos.
     * 
     * Cada 3 minutos
     * 
     * @return
     */
    @Scheduled(fixedRate = 180000)
    public void reportCurrentTime() {
        if (ejecutarConfiguracion()) {
            for (Cliente cliente : listaClientes) {
                ejecutarConsultasDocumentosRecibidos(cliente.getSriUsuario(), cliente.getSriCredencial());
            }
        }
    }

    /** 
     * Metodo para ejecutar la configuracion de parametros y clientes.
     * 
     * @return
     */
    private boolean ejecutarConfiguracion() {
        DataSourceContextHolder.setBranchContext("config");
        mapaParametro = clienteService.generarParametros();
        Optional<List<Cliente>> clientesOptional = clienteService.getClientes();
        if (clientesOptional.isPresent()) {
            listaClientes = clientesOptional.get();
        }

        if (mapaParametro == null || listaClientes == null) {
            log.error("Error en la configuracion de parametros o clientes");
            return false;
        }

        if (mapaParametro.size() > 0 && !listaClientes.isEmpty()) {
            log.error("Faltan parametros o clientes en la configuracion, parametros: {}, clientes: {}",
                    mapaParametro.size(), listaClientes.size());
            return false;
        }

        return true;
    }

    /** 
     * Metodo para ejecutar las consultas de documentos recibidos.
     * 
     * @param ruc
     * @param credencial
     */
    private void ejecutarConsultasDocumentosRecibidos(String ruc, String credencial) {
        DataSourceContextHolder.setBranchContext(ruc);
        documentosRecibidosService.setMapaParametros(mapaParametro);
        documentosRecibidosService.consultarDocumentosRecibidos(ruc, credencial);
    }
}
