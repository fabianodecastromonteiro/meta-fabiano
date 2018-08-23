package br.com.meta.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto implements Serializable {

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido")
    private Pedido pedido;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto")
    private Produto produto;
	private int quantidade;
	private static final long serialVersionUID = -1556237963815095581L;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}