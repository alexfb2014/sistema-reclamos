package com.sistema.reclamos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.reclamos.app.models.entity.TipoDocumento;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Long>{

	
}
