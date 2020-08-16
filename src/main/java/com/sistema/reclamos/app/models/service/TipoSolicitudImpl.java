package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.reclamos.app.models.dao.ITipoSolicitudDao;
import com.sistema.reclamos.app.models.entity.TipoSolicitud;

@Service
public class TipoSolicitudImpl implements ITipoSolicitudService{

	@Autowired
	ITipoSolicitudDao tipoDao;
	
	
	@Override
	public List<TipoSolicitud> findAll() {
		
		return (List<TipoSolicitud>) tipoDao.findAll();
	}

	@Override
	public void save(TipoSolicitud tipoSolicitud) {
		
		tipoDao.save(tipoSolicitud);
		
	}

	@Override
	public TipoSolicitud findOne(Long id) {
		
		return tipoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		tipoDao.deleteById(id);;
		
	}

	
	
	
}
