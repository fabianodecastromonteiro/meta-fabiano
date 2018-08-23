package br.com.meta.service;

import java.util.ArrayList;

import br.com.meta.model.Usuario;

public interface UsuarioService {

    ArrayList<Usuario> findAll();

    Usuario findById(Integer id);

    Usuario login(String email, String senha);

    Usuario save(Usuario entity);

	Usuario update(Usuario entity);

	void delete(Integer id);

}
