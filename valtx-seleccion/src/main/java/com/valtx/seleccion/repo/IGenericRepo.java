package com.valtx.seleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T, COD>  extends JpaRepository<T, COD> {

}
