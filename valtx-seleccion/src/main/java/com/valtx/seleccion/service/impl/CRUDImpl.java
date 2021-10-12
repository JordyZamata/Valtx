package com.valtx.seleccion.service.impl;

import java.util.List;

import com.valtx.seleccion.repo.IGenericRepo;
import com.valtx.seleccion.service.ICRUD;

public abstract class CRUDImpl<T,COD> implements ICRUD<T,COD> {

	protected abstract IGenericRepo<T, COD> getRepo();

	@Override
	public T registrar(T t) throws Exception {
		
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(COD cod)  {
		return getRepo().findById(cod).orElse(null);
	}

	@Override
	public void eliminar(COD cod) throws Exception {
		getRepo().deleteById(cod);
	}
	
}
