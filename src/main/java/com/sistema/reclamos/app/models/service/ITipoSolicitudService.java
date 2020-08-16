package com.sistema.reclamos.app.models.service;

import java.util.List;

import com.sistema.reclamos.app.models.entity.TipoSolicitud;

public interface ITipoSolicitudService {

	public List<TipoSolicitud> findAll();

	public void save(TipoSolicitud tipoSolicitud);

	public TipoSolicitud findOne(Long id);

	public void delete(Long id);
	
	
}
