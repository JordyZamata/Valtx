package com.valtx.seleccion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtx.seleccion.exception.ModeloNotFoundException;
import com.valtx.seleccion.model.Producto;
import com.valtx.seleccion.service.IProductoService;




@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProductoService service;
	
	@GetMapping()
	public ResponseEntity<List<Producto>> listar() throws Exception{
		List<Producto> lista = service.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	} 
	
	
	
	@GetMapping("/{cod}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("cod") String cod) throws Exception {
		
		Producto producto = service.listarPorId(cod);
		
		if(producto == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO " + cod);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto p) throws Exception {
		
		Producto producto = service.listarPorId(p.getCodProducto());
		
		if(producto != null) {
			throw new ModeloNotFoundException("PRODUCTO YA REGISTRADO: " + producto.getCodProducto() + " - " + producto.getNombre());
		}
		
		producto =  service.registrar(p);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto p) throws Exception {
		Producto producto = service.modificar(p);
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> eliminar (@PathVariable String cod)  throws Exception{

		Producto producto = service.listarPorId(cod);
		
		if(producto == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO: " + cod);
		}
		
		service.eliminar(cod);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
