package com.valtx.seleccion.service;

import java.util.List;

public interface ICRUD<T, COD> {
	T registrar(T t) throws Exception;
	T modificar(T t) throws Exception;
	List<T> listar() throws Exception;
	T listarPorId(COD cod) throws Exception;
	void eliminar (COD cod) throws Exception;
}

