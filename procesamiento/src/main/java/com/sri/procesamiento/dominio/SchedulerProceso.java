package com.sri.procesamiento.dominio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sri.procesamiento.dominio.service.ClienteService;
import com.sri.procesamiento.persistencia.entidad.Clientes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerProceso {

    @Autowired
    ClienteService clienteService;

    // cada tres minutos
    @Scheduled(fixedRate = 180000)
    public void reportCurrentTime() {

        Optional<List<Clientes>> clientesOptional = clienteService.getAllActivos();
        if (clientesOptional.isPresent()) {
            List<Clientes> clientes = clientesOptional.get();
            for (Clientes cliente : clientes) {
                log.info(cliente.toString());
            }
        } else {
            log.warn("No active clients found.");
        }
    }
}