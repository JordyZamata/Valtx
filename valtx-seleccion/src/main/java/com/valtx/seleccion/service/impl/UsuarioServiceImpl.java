package com.valtx.seleccion.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtx.seleccion.model.Producto;
import com.valtx.seleccion.model.Sucursal;
import com.valtx.seleccion.model.Usuario;
import com.valtx.seleccion.repo.IGenericRepo;
import com.valtx.seleccion.repo.IUsuarioRepo;
import com.valtx.seleccion.service.IUsuarioService;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, String> implements IUsuarioService{

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, String> getRepo() {
		return repo;
	}
	

	
	
}
