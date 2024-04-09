package com.leon.estructura.persistencia.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T0005;
import com.leon.estructura.persistencia.entidad.T0005Id;

/**
 * Clase para manejar los registros de la tabla T0005
 * 
 * @author omargo33
 * @since 2024-04-03
 */
@Repository
public interface T0005CrudRepositorio extends CrudRepository<T0005, T0005Id> {

        /**
         * Buscar lista de registros por szModulo, szConstante y szCodigoDefinidoUsuario
         *
         * @param szModulo
         * @param szConstante
         * @param szCodigoDefinidoUsuario
         */
        @Query(value = "SELECT t FROM T0005 t WHERE t.id.szModulo = ?1 AND t.id.szConstante = ?2 AND t.id.szCodigoDefinidoUsuario = ?3")
        T0005 findBySzModuloAndSzConstanteAndSzCodigoDefinidoUsuario(String szModulo, String szConstante,
                        String szCodigoDefinidoUsuario);

        /**
         * Buscar lista de registros por szModulo, szConstante y szDescripcion02
         *
         * @param szModulo
         * @param szConstante
         * @param szDescripcion02
         */
        @Query(value = "SELECT t FROM T0005 t WHERE t.id.szModulo = ?1 AND t.id.szConstante = ?2 AND t.szDescripcion02 = ?3")
        T0005 findBySzModuloAndSzConstanteAndSzDescripcion02(String szModulo, String szConstante,
                        String szDescripcion02);

}
