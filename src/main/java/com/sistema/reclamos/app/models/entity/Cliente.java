package com.sistema.reclamos.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotEmpty
	public String nombre;
	
	@NotEmpty
	public String apellido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipodocumento")
	public TipoDocumento tipoDocumento;
	
	@NotEmpty
	public String numdoc;
	
	@NotEmpty
	@Email
	public String email;
	
	@NotEmpty
	public String telefono;
	
	@NotEmpty
	public String direccion;
	
	@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL ) //Carga perezosa(recomendado)
	@JsonManagedReference
	private List<Solicitud> solicitudes;
	
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL )
	private Usuario usuario;
	private static final long serialVersionUID = 1L;



	public Cliente(String nombre, String apellido, String numdoc, String email, String telefono,
			String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numdoc = numdoc;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public Cliente() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	public String getNumdoc() {
		return numdoc;
	}


	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}


	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String getNombreYApellido() {
		return nombre + " " + apellido ;
	}


	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	
}
