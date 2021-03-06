package com.valtx.seleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@Column(nullable = false, length = 2)
	@Size(min = 2, max = 2, message = "El código del Producto debe tener 2 caracteres")
	private String codProducto;

	@Size(min=1, message = "El nombre del Producto es requerido")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "precio", nullable = false)
	private double precio;

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	
}
