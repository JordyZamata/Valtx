package com.valtx.seleccion.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtx.seleccion.model.Producto;
import com.valtx.seleccion.model.Sucursal;
import com.valtx.seleccion.repo.IGenericRepo;
import com.valtx.seleccion.repo.IProductoRepo;
import com.valtx.seleccion.repo.ISucursalRepo;
import com.valtx.seleccion.service.ISucursalService;

@Service
public class SucursalServiceImpl extends CRUDImpl<Sucursal, String> implements ISucursalService {

	@Autowired
	private ISucursalRepo repo;
	
	@Override
	protected IGenericRepo<Sucursal, String> getRepo() {
		return repo;
	}
	

	
	
}
