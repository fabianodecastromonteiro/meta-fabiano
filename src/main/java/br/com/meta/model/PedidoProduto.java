package br.com.meta.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class PedidoProduto {

    @JoinColumn(name = "pedido")
    private Pedido pedido;
    private int quantidade;
    private Produto produto;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
