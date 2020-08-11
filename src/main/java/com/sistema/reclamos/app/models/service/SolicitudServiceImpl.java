package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.reclamos.app.models.dao.ISolicitudDao;
import com.sistema.reclamos.app.models.entity.Solicitud;


@Service
public class SolicitudServiceImpl implements ISolicitudService{

	@Autowired
	ISolicitudDao solicitudDao;
	
	
	@Override
	@Transactional(readOnly = true) 
	public List<Solicitud> findAll() {
		
		return (List<Solicitud>) solicitudDao.findAll();
	}

	@Override
	@Transactional
	public void save(Solicitud solicitud) {
		
		solicitud.detalle.solicitud = solicitud;
		
		solicitudDao.save(solicitud);
	}

	@Override
	@Transactional(readOnly = true) 
	public Solicitud findOne(Long id) {
		return solicitudDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		solicitudDao.deleteById(id);
		
	}

	@Override
	public Page<Solicitud> findAll(Pageable pageable) {
		
		return solicitudDao.findAll(pageable);
	}



}
