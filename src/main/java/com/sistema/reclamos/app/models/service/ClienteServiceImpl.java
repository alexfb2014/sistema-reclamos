package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.reclamos.app.models.dao.IClienteDao;
import com.sistema.reclamos.app.models.entity.Cliente;



@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	

	
	@Override
	@Transactional(readOnly = true) //Indicar que es solo lectura
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true) //Indicar que es solo lectura
	public Cliente findOne(Long id) {
		
		return clienteDao.findById(id).orElse(null);
	}

	
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		clienteDao.deleteById(id);
		
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {

		
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByNumdoc(String numdoc) {
		
		return clienteDao.findByNumdoc(numdoc).orElse(null);
	}










	

	

	
	
	
}
