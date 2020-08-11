package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.sistema.reclamos.app.models.entity.Solicitud;

public interface ISolicitudService {

	
	
	
	public List<Solicitud> findAll();
	
	public Page<Solicitud> findAll(Pageable pageable);
	
	public void save(Solicitud solicitud);
	
	public Solicitud findOne(Long id);
	
	
	public void delete(Long id);
	
	
}
