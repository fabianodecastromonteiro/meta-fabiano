package br.com.meta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import br.com.meta.model.Usuario;
import br.com.meta.repository.UsuarioRepository;

@Service
@ComponentScan(basePackages= {"br.com.meta.service"})
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public ArrayList<Usuario> findAll() {
	    return (ArrayList<Usuario>) repository.findAll();
    }

    @Override
	public Usuario findById(Integer id) {
    	return repository.findOne(id);
	}

    @Override
	public Usuario login(String email, String senha) {
    	return repository.logon(email, senha);
	}

    @Override
	public Usuario save(Usuario entity) {
		return repository.save(entity);
	}
	
    @Override
	public Usuario update(Usuario entity) {
		repository.save(entity);
		return entity;
	}
	
    @Override
	public void delete(Integer id){
		Usuario entity = repository.findOne(id);
		if (entity != null)
			repository.delete(entity);
	}

}
