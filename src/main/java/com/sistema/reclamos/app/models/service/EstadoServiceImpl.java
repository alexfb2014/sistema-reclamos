package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.reclamos.app.models.dao.IEstadoDao;
import com.sistema.reclamos.app.models.entity.Estado;

@Service
public class EstadoServiceImpl implements IEstadoService{

	@Autowired
	IEstadoDao estadoDao;
	
	@Override
	public List<Estado> findAll() {
		
		return (List<Estado>) estadoDao.findAll();
	}

	@Override
	public void save(Estado estado) {
		
		estadoDao.save(estado);
		
	}

	@Override
	public Estado findOne(Long id) {
		
		return estadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		estadoDao.deleteById(id);
		
	}

	@Override
	public Estado findByDescripcion(String descripcion) {
		
		return estadoDao.findByDescripcion(descripcion);
	}
	
	

}
