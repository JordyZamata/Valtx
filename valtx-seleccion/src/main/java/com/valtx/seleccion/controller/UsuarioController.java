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
import com.valtx.seleccion.model.Sucursal;
import com.valtx.seleccion.model.Usuario;
import com.valtx.seleccion.service.IUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService service;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> listar() throws Exception{
		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	} 
	
	
	@GetMapping("/{cod}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("cod") String cod) throws Exception {
		
		Usuario usuario = service.listarPorId(cod);
		
		if(usuario == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO " + cod);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario p) throws Exception {
		
		Usuario usuario = service.listarPorId(p.getCodUsuario());
		
		if(usuario != null) {
			throw new ModeloNotFoundException("USUARIO YA REGISTRADO: " + usuario.getCodUsuario() + " - " + usuario.getNombre());
		}
		
		usuario =  service.registrar(p);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario p) throws Exception {
		Usuario usuario = service.modificar(p);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> eliminar (@PathVariable String cod)  throws Exception{

		Usuario usuario = service.listarPorId(cod);
		
		if(usuario == null) {
			throw new ModeloNotFoundException("CODIGO NO ENCONTRADO: " + cod);
		}
		
		service.eliminar(cod);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
