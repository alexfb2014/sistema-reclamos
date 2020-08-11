package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistema.reclamos.app.models.entity.Cliente;



public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	
}
