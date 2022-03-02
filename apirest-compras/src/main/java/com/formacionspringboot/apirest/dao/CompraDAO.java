package com.formacionspringboot.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.formacionspringboot.apirest.entity.Compra;
import com.formacionspringboot.apirest.entity.Articulo;
import com.formacionspringboot.apirest.entity.Cliente;

public interface CompraDAO extends CrudRepository<Compra, Long>{

	@Query("from Articulo")
	public List<Articulo> findAllArticulos();
	@Query("from Cliente")
	public List<Cliente> findAllClientes();
}
