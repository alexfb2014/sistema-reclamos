package com.sistema.reclamos.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "detalle")
public class Detalle implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	
	@NotEmpty
	public String detalle;
	@NotEmpty
	public String pedido;
	
	public String opinionArea;
	
	public String respuesta;
	
	public String archivo;

	@OneToOne
	@JoinColumn(name = "id_solicitud")
	public Solicitud solicitud;
	
	public Detalle() {
		
	}

	public Detalle(Long id, @NotEmpty String detalle, @NotEmpty String pedido, String opinionArea, String respuesta,
			String archivo) {
		super();
		this.id = id;
		this.detalle = detalle;
		this.pedido = pedido;
		this.opinionArea = opinionArea;
		this.respuesta = respuesta;
		this.archivo = archivo;
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

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getOpinionArea() {
		return opinionArea;
	}

	public void setOpinionArea(String opinionArea) {
		this.opinionArea = opinionArea;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	
	
}
