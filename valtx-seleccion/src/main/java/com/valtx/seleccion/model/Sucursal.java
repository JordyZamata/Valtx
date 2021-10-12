package com.valtx.seleccion.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sucursal")
public class Sucursal {

	@Id
	@Column(nullable = false, length = 2)
	@Size(min = 2, max = 2, message = "El código de Sucursal debe tener 2 caracteres")
	private String codSucursal;
	
	@Size(min=1, message = "El nombre de la sucursal es requerido")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
