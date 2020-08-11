package com.sistema.reclamos.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "motivos")
public class Motivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@NotEmpty
	public String detalle;
	@Column(columnDefinition="char default 'S'")
	public char estadoreg;
	
	public Motivo() {
	}

	
	public Motivo(Long id, String detalle) {
		
		this.id = id;
		this.detalle = detalle;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public char getEstadoreg() {
		return estadoreg;
	}


	public void setEstadoreg(char estadoreg) {
		this.estadoreg = estadoreg;
	}
	
	
	
	
}
