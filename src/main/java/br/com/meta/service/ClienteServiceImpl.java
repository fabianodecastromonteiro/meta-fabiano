package br.com.meta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import br.com.meta.model.Cliente;
import br.com.meta.repository.ClienteRepository;

@Service
@ComponentScan(basePackages= {"br.com.meta.service"})
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public ArrayList<Cliente> findAll() {
	    return (ArrayList<Cliente>) repository.findAll();
    }

    @Override
	public Cliente findById(Integer id) {
    	return repository.findOne(id);
	}

    @Override
	public Cliente save(Cliente entity) {
		return repository.save(entity);
	}
	
    @Override
	public Cliente update(Cliente entity) {
		repository.save(entity);
		return entity;
	}
	
    @Override
	public void delete(Integer id){
		Cliente Cliente= repository.findOne(id);
		if (Cliente != null)
			repository.delete(Cliente);
	}

}
