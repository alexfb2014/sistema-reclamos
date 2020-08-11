package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistema.reclamos.app.models.entity.Solicitud;

public interface ISolicitudDao extends PagingAndSortingRepository<Solicitud, Long>{

	
	
}
