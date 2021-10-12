package com.valtx.seleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id()
	@Column(nullable = false, length = 2)
	@Size(min = 2, max = 2, message = "El código de usuario debe tener 2 caracteres")
	private String codUsuario;

	@ManyToOne
	@JoinColumn(name = "cod_sucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_sucursal"))
	private Sucursal sucursal;
	
	@Size(min=1, message = "El nombre del Usuario es requerido")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Size(min=1, message = "El usuario es requerido")
	@Column(nullable = false, length = 50)
	private String userr;
	
	
	@Size(min=1, message = "La contraseña del Usuario es requerida")
	@Column(name = "password", nullable = false, length = 50)
	private String password;


	public String getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}


	public Sucursal getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUserr() {
		return userr;
	}


	public void setUserr(String userr) {
		this.userr = userr;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
