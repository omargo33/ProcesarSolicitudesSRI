package com.leon.estructura.persistencia.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.estructura.persistencia.entidad.T00221;

@Repository
public interface T00221CrudRepositorio extends CrudRepository<T00221, String> {
}
