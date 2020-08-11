package com.sistema.reclamos.app.models.service;

import java.util.List;

import com.sistema.reclamos.app.models.entity.TipoDocumento;

public interface ITipoDocumento {

	
	
	public List<TipoDocumento> findAll();

	public void save(TipoDocumento tipoDocumento);

	public TipoDocumento findOne(Long id);

	public void delete(Long id);
	
	
}
