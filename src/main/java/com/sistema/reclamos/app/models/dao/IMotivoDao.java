package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.reclamos.app.models.entity.Motivo;

public interface IMotivoDao extends CrudRepository<Motivo, Long> {

}
