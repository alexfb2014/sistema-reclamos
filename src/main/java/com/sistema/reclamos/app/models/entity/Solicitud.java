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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

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
	public TipoSolicitud tipoSolicitud;

	@NotEmpty
	public String notificacion;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date fechaRespuesta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	public Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estadoEvalu")
	public Estado estadoEvalua;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Cliente cliente;

	@OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL )
	public Detalle detalle;

	public Solicitud() {

	}

	
	@PrePersist
	  protected void onCreate() {
	    fechaRegistro = new Date();
	   
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

	

	public Estado getEstado() {
		return estado;
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

	

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}


	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}


	public Estado getEstadoEvalua() {
		return estadoEvalua;
	}


	public void setEstadoEvalua(Estado estadoEvalua) {
		this.estadoEvalua = estadoEvalua;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	

}
