package com.sistema.reclamos.app.models.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.reclamos.app.models.dao.IUsuarioDao;
import com.sistema.reclamos.app.models.entity.Rol;
import com.sistema.reclamos.app.models.entity.Usuario;


@Service("JpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if (usuario == null) {
			logger.error("Error Login: no existe el usuario '"+username +"'");
			throw new UsernameNotFoundException("Username '"+username + "no existe en el sistema");
		}
		
		
		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Rol role : usuario.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		if (authorities.isEmpty()) {
			logger.error("Error Login: no existe el usuario '"+username +"' no tiene roles asignados!");
			throw new UsernameNotFoundException("Username '"+username + "' no tiene roles asignados!");
		}

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(),true, true, true, authorities);
	}

	
	@Transactional(readOnly = true)
	public Usuario ObtenerUsuario(String username) throws UsernameNotFoundException {
		
		
			logger.info("El usuario que llega es "+ username);

		Usuario usuario = usuarioDao.findByUsername(username);
		if (usuario == null) {
			logger.error("Error Login: no existe el usuario '"+username +"'");
			throw new UsernameNotFoundException("Username '"+username + "no existe en el sistema");
			
		}
		
		return usuario;
	}
	
	
}
