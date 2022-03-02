package com.formacionspringboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionspringboot.apirest.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
