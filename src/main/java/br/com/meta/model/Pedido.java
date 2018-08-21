package br.com.meta.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Usuario vendedor;
	private Date dtCadastro;
	private Date dtEmissao;
	private Date dtFaturamento;
    private BigDecimal valorTotal;
    @OneToMany(
    	mappedBy = "pedido", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
	private List<PedidoProduto> itens = new ArrayList<PedidoProduto>();

	public Pedido() {
		this(0, new Usuario(), new Date(), new Date(), new Date(), new BigDecimal(0));
	}

	public Pedido(int id, Usuario vendedor, Date dtCadastro, Date dtEmissao, Date dtFaturamento, BigDecimal valorTotal) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.dtCadastro = dtCadastro;
		this.dtEmissao = dtEmissao;
		this.dtFaturamento = dtFaturamento;
		this.valorTotal = valorTotal;
	}

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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<PedidoProduto> getItens() {
		return itens;
	}

	public void setItens(List<PedidoProduto> itens) {
		this.itens = itens;
	}

}
