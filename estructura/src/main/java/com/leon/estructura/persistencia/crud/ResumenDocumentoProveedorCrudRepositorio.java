package com.leon.estructura.persistencia.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
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
public interface ResumenDocumentoProveedorCrudRepositorio extends CrudRepository<ResumenDocumentoProveedor, String> {

    /**
     * Metodo para listar los resumenDocumentosProveedor que no esten en la JPA
     * T57011 por el campo szClaveAcceso con un query personaizado
     *
     */
    @Query(value = "SELECT * FROM resumenDocumentosProveedores rdp WHERE rdp.access_key NOT IN (SELECT t.szClaveAcceso FROM t57011 t)", nativeQuery = true)
    Optional<List<ResumenDocumentoProveedor>> findBySzClaveAccesoNotInT57011();
}
