package com.sistema.reclamos.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipossolicitud")
public class TipoSolicitud implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	
	public String descripcion;
	@Column(columnDefinition="char default 'S'")
	public char estadoreg;

	public TipoSolicitud(Long id, String descripcion, char estadoreg) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.estadoreg = estadoreg;
	}

	public TipoSolicitud() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getEstadoreg() {
		return estadoreg;
	}

	public void setEstadoreg(char estadoreg) {
		this.estadoreg = estadoreg;
	}
	
}
