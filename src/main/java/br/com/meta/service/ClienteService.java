package br.com.meta.service;

import java.util.ArrayList;

import br.com.meta.model.Cliente;

public interface ClienteService {

    ArrayList<Cliente> findAll();

    Cliente findById(Integer id);

     Cliente save(Cliente entity);

	Cliente update(Cliente entity);

	void delete(Integer id);

}
