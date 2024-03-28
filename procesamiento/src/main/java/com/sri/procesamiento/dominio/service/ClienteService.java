package com.sri.procesamiento.dominio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.procesamiento.persistencia.crud.ClientesCrudRepositorio;
import com.sri.procesamiento.persistencia.entidad.Clientes;

/**
 * Servicio de Cliente
 * 
 * @author omargo33
 * @since 2024-03-28
 * 
 */
@Service
@Transactional
public class ClienteService {

   @Autowired
   private ClientesCrudRepositorio clientesCrudRepositorio;

   public Optional<List<Clientes>> getAllActivos() {
      return clientesCrudRepositorio.findAllActivos();
   }
}
