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
import com.valtx.seleccion.model.Sucursal;
import com.valtx.seleccion.service.ISucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

	@Autowired
	ISucursalService service;
	
	@GetMapping()
	public ResponseEntity<List<Sucursal>> listar() throws Exception{
		List<Sucursal> lista = service.listar();
		return new ResponseEntity<List<Sucursal>>(lista, HttpStatus.OK);
	} 
	
	
	@GetMapping("/{cod}")
	public ResponseEntity<Sucursal> listarPorId(@PathVariable("cod") String cod) throws Exception {
		
		Sucursal sucursal = service.listarPorId(cod);
		
		if(sucursal == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO: " + cod);
		}
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Sucursal> registrar(@Valid @RequestBody Sucursal p) throws Exception {
		
		Sucursal sucursal = service.listarPorId(p.getCodSucursal());
		
		if(sucursal != null) {
			throw new ModeloNotFoundException("SUCURSAL YA REGISTRADA: " + sucursal.getCodSucursal() + " - " + sucursal.getNombre());
		}
		
	
		sucursal =  service.registrar(p);
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Sucursal> modificar(@Valid @RequestBody Sucursal p) throws Exception {
		Sucursal sucursal = service.modificar(p);
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> eliminar (@PathVariable String cod)  throws Exception{

		Sucursal sucursal = service.listarPorId(cod);
		
		if(sucursal == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO " + cod);
		}
		
		service.eliminar(cod);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
