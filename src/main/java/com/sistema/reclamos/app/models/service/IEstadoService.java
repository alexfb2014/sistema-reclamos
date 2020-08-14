package com.sistema.reclamos.app.models.service;

import java.util.List;

import com.sistema.reclamos.app.models.entity.Estado;

public interface IEstadoService {

	
	public List<Estado> findAll();

	public void save(Estado estado);

	public Estado findOne(Long id);

	public void delete(Long id);
	
	public Estado findByDescripcion(String descripcion);
}
