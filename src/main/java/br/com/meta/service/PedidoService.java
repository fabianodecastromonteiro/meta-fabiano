package br.com.meta.service;

import java.util.ArrayList;

import br.com.meta.model.Pedido;

public interface PedidoService {

    ArrayList<Pedido> findAll();

    Pedido findById(Integer id);

     Pedido save(Pedido entity);

	Pedido update(Pedido entity);

	void delete(Integer id);

}
