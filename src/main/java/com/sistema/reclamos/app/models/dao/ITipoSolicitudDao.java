package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.reclamos.app.models.entity.TipoSolicitud;

public interface ITipoSolicitudDao extends CrudRepository<TipoSolicitud, Long> {

}
