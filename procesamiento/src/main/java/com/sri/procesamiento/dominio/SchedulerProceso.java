package com.sri.procesamiento.dominio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leon.estructura.persistencia.entidad.Cliente;
import com.sri.procesamiento.servicio.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class SchedulerProceso {

    @Autowired
    ClienteService clienteService;

    // cada tres minutos
    @Scheduled(fixedRate = 180000)
    public void reportCurrentTime() {

        Optional<List<Cliente>> clientesOptional = clienteService.getAllActivos();
        if (clientesOptional.isPresent()) {
            List<Cliente> clientes = clientesOptional.get();
            for (Cliente cliente : clientes) {
                log.info(cliente.toString());
            }
        } else {
            log.warn("No hay clientes a consultar.");
        }
    }
}
