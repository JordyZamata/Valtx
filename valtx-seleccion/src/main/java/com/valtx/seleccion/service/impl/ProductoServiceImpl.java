package com.valtx.seleccion.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtx.seleccion.model.Producto;
import com.valtx.seleccion.repo.IGenericRepo;
import com.valtx.seleccion.repo.IProductoRepo;
import com.valtx.seleccion.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, String> implements IProductoService{

	@Autowired
	private IProductoRepo repo;
	
	@Override
	protected IGenericRepo<Producto, String> getRepo() {
		return repo;
	}
	
	
}
