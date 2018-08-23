package br.com.meta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import br.com.meta.model.TipoUsuario;
import br.com.meta.repository.TipoUsuarioRepository;

@Service
@ComponentScan(basePackages= {"br.com.meta.service"})
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository repository;

    @Override
    public ArrayList<TipoUsuario> findAll() {
	    return (ArrayList<TipoUsuario>) repository.findAll();
    }

    @Override
	public TipoUsuario findById(Integer id) {
    	return repository.findOne(id);
	}

    @Override
	public TipoUsuario save(TipoUsuario entity) {
		return repository.save(entity);
	}
	
    @Override
	public TipoUsuario update(TipoUsuario entity) {
		repository.save(entity);
		return entity;
	}
	
    @Override
	public void delete(Integer id){
		TipoUsuario entity = repository.findOne(id);
		if (entity != null)
			repository.delete(entity);
	}

}
