package com.sistema.reclamos.app.models.service;

import java.util.List;

import com.sistema.reclamos.app.models.entity.ProductoYServicio;

public interface IProductoService {

	
	
	public List<ProductoYServicio> findAll();

	public void save(ProductoYServicio producto);

	public ProductoYServicio findOne(Long id);

	public void delete(Long id);
}
