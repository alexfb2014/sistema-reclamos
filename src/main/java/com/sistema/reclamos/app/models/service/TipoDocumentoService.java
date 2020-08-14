package com.sistema.reclamos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.reclamos.app.models.dao.ITipoDocumentoDao;
import com.sistema.reclamos.app.models.entity.TipoDocumento;

@Service
public class TipoDocumentoService implements ITipoDocumento {

	@Autowired
	ITipoDocumentoDao docDao;
	
	@Override
	public List<TipoDocumento> findAll() {
		
		return (List<TipoDocumento>) docDao.findAll();
	}

	@Override
	public void save(TipoDocumento tipoDocumento) {
		
		docDao.save(tipoDocumento);
		
	}

	@Override
	public TipoDocumento findOne(Long id) {
		
		return docDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		docDao.deleteById(id);
		
	}

}
