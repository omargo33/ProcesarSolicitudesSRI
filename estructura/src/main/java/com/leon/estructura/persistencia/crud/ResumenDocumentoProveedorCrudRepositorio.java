package com.leon.estructura.persistencia.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.ResumenDocumentoProveedor;


/**
 * Interface para manejar los documentos del proveedor crud.
 * 
 * @author omargo33
 * @since 2024-04-10
 */
@Repository
public interface ResumenDocumentoProveedorCrudRepositorio extends CrudRepository<ResumenDocumentoProveedor, String>{

    
}
