package com.sistema.reclamos.app.models.service;

import java.util.List;

import com.sistema.reclamos.app.models.entity.Motivo;

public interface IMotivoService {

	public List<Motivo> findAll();

	public void save(Motivo servicio);

	public Motivo findOne(Long id);

	public void delete(Long id);

}
