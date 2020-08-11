package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.reclamos.app.models.entity.ProductoYServicio;

public interface IProductodao extends CrudRepository<ProductoYServicio, Long>{

}
