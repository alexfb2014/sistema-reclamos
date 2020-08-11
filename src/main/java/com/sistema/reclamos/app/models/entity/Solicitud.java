package com.sistema.reclamos.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	public ProductoYServicio producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_motivo")
	public Motivo motivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo")
	public Motivo tipoSolicitud;

	@NotEmpty
	public String notificacion;

	public Date fechaRegistro;

	public Date fechaRespuesta;

	public String estado;

	public String estadoEvalua;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Cliente cliente;

	@OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL )
	public Detalle detalle;

	public Solicitud() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductoYServicio getProducto() {
		return producto;
	}

	public void setProducto(ProductoYServicio producto) {
		this.producto = producto;
	}

	

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Motivo getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Motivo tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getEstadoEvalua() {
		return estadoEvalua;
	}

	public void setEstadoEvalua(String estadoEvalua) {
		this.estadoEvalua = estadoEvalua;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	

}
