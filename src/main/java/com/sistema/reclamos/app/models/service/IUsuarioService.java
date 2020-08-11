package com.sistema.reclamos.app.models.service;


import com.sistema.reclamos.app.models.entity.Usuario;

public interface IUsuarioService {

	
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public Usuario findByUsername(String username);
	
}
