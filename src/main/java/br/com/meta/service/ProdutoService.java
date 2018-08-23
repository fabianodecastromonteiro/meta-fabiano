package br.com.meta.service;

import java.util.ArrayList;

import br.com.meta.model.Produto;

public interface ProdutoService {

    ArrayList<Produto> findAll();

    Produto findById(Integer id);

     Produto save(Produto entity);

	Produto update(Produto entity);

	void delete(Integer id);

}
