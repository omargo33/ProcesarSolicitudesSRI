package com.leon.batch.dominio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leon.estructura.persistencia.entidad.Cliente;
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

        clienteService.generarParametros();
        Optional<List<Cliente>> clientesOptional = clienteService.getClientes();
        if (clientesOptional.isPresent()) {
            List<Cliente> clientes = clientesOptional.get();
            for (Cliente cliente : clientes) {                
                clienteService.consultarToken(cliente.getSriUsuario(), cliente.getSriCredencial());
            }
        } else {
            log.warn("No hay clientes a consultar.");
        }        
    }
}
