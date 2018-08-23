package br.com.meta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import br.com.meta.model.Pedido;
import br.com.meta.repository.PedidoRepository;

@Service
@ComponentScan(basePackages= {"br.com.meta.service"})
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public ArrayList<Pedido> findAll() {
	    return (ArrayList<Pedido>) repository.findAll();
    }

    @Override
	public Pedido findById(Integer id) {
    	return repository.findOne(id);
	}

    @Override
	public Pedido save(Pedido entity) {
		return repository.save(entity);
	}
	
    @Override
	public Pedido update(Pedido entity) {
		repository.save(entity);
		return entity;
	}
	
    @Override
	public void delete(Integer id){
		Pedido entity = repository.findOne(id);
		if (entity != null)
			repository.delete(entity);
	}

}
