package com.leon.batch.dominio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leon.estructura.persistencia.entidad.Cliente;
import com.leon.estructura.persistencia.entidad.Parametro;
import com.leon.batch.datasource.PropiedadesBaseDatos;
import com.leon.batch.datasource.DataSourceContextHolder;
import com.leon.batch.servicio.ConfiguracionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class SchedulerProceso {

    @Autowired
    ConfiguracionService clienteService;

    @Autowired
    PropiedadesBaseDatos baseDatos;

    // cada tres minutos
    @Scheduled(fixedRate = 180000)
    public void reportCurrentTime() {

        DataSourceContextHolder.setBranchContext("config");

        Optional<List<Cliente>> clientesOptional = clienteService.getClientes();
        if (clientesOptional.isPresent()) {
            List<Cliente> clientes = clientesOptional.get();
            for (Cliente cliente : clientes) {
                log.info(cliente.toString());
            }
        } else {
            log.warn("No hay clientes a consultar.");
        }

        Optional<List<Parametro>> parametros = clienteService.getParametros();

        if (parametros.isPresent()) {
            List<Parametro> parametrosList = parametros.get();
            for (Parametro parametro : parametrosList) {
                log.info(parametro.toString());
            }
        } else {
            log.warn("No hay parametros a consultar.");
        }
    }
}
