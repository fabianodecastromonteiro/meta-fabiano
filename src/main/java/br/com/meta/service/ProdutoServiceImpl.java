package br.com.meta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import br.com.meta.model.Produto;
import br.com.meta.repository.ProdutoRepository;

@Service
@ComponentScan(basePackages= {"br.com.meta.service"})
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ArrayList<Produto> findAll() {
	    return (ArrayList<Produto>) repository.findAll();
    }

    @Override
	public Produto findById(Integer id) {
    	return repository.findOne(id);
	}

    @Override
	public Produto save(Produto entity) {
		return repository.save(entity);
	}
	
    @Override
	public Produto update(Produto entity) {
		repository.save(entity);
		return entity;
	}
	
    @Override
	public void delete(Integer id){
		Produto entity = repository.findOne(id);
		if (entity != null)
			repository.delete(entity);
	}

}
