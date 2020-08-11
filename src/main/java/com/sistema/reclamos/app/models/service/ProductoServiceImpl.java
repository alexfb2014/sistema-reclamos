package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.reclamos.app.models.dao.IProductodao;
import com.sistema.reclamos.app.models.entity.ProductoYServicio;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductodao productoDao;
	
	@Override
	public List<ProductoYServicio> findAll() {
		
		return (List<ProductoYServicio>) productoDao.findAll();
	}

	@Override
	public void save(ProductoYServicio producto) {
		
		productoDao.save(producto);
		
	}

	@Override
	public ProductoYServicio findOne(Long id) {
		
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		productoDao.deleteById(id);
		
	}

	
	
	
}
