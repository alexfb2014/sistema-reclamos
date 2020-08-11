package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.reclamos.app.models.dao.IMotivoDao;
import com.sistema.reclamos.app.models.entity.Motivo;

@Service
public class MotivoServiceImp implements IMotivoService{

	@Autowired
	IMotivoDao servicioDao;
	
	
	@Override
	@Transactional(readOnly = true) //Indicar que es solo lectura
	public List<Motivo> findAll() {
		
		return (List<Motivo>) servicioDao.findAll();
	}

	@Override
	public void save(Motivo servicio) {
		servicioDao.save(servicio);
		
	}

	@Override
	@Transactional(readOnly = true) //Indicar que es solo lectura
	public Motivo findOne(Long id) {
		
		return servicioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {

		servicioDao.deleteById(id);
		
	}

	
	
}
