package br.com.meta.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor")
    private Usuario vendedor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente")
    private Cliente cliente;
	private Date dtCadastro;
	private Date dtEmissao;
	private Date dtFaturamento;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoProduto> itens;
	private BigDecimal valorTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtFaturamento() {
		return dtFaturamento;
	}

	public void setDtFaturamento(Date dtFaturamento) {
		this.dtFaturamento = dtFaturamento;
	}

	public List<PedidoProduto> getItens() {
		return itens;
	}

	public void setItens(List<PedidoProduto> itens) {
		this.itens = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
