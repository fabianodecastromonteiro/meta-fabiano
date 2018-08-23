package br.com.meta.service;

import java.util.ArrayList;

import br.com.meta.model.TipoUsuario;

public interface TipoUsuarioService {

    ArrayList<TipoUsuario> findAll();

    TipoUsuario findById(Integer id);

    TipoUsuario save(TipoUsuario entity);

    TipoUsuario update(TipoUsuario entity);

	void delete(Integer id);

}
