package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.reclamos.app.models.entity.Estado;

public interface IEstadoDao extends CrudRepository<Estado, Long> {

	
	public Estado findByDescripcion(String descripcion);
	
}
