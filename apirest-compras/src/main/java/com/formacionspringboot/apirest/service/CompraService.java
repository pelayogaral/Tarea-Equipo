package com.formacionspringboot.apirest.service;

import java.util.List;

import com.formacionspringboot.apirest.entity.Compra;
import com.formacionspringboot.apirest.entity.Articulo;
import com.formacionspringboot.apirest.entity.Cliente;

public interface CompraService 
{
	public List<Compra> findAll();
	public Compra findById(Long id);
	public Compra save(Compra compra);
	public void delete(Long id);
	
	public List<Articulo> findAllArticulos();
	public List<Cliente> findAllClientes();
}
