package com.sistema.reclamos.app.models.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistema.reclamos.app.models.entity.Cliente;



public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	
	public Optional<Cliente> findByNumdoc(String numdoc);
	
}
