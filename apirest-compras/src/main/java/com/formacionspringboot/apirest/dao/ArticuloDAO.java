package com.formacionspringboot.apirest.dao;

import org.springframework.stereotype.Repository;

import com.formacionspringboot.apirest.entity.Articulo;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ArticuloDAO  extends CrudRepository<Articulo,Long> {
	
	public Articulo findByNombre(String nombre);

}
