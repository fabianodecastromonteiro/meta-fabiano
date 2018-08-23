package br.com.meta;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.meta.model.Pedido;
import br.com.meta.model.PedidoProduto;
import br.com.meta.repository.PedidoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PedidoTest {

	@Autowired
	private PedidoRepository repository;

	//@Test
	public void list() {
		try {
			List<Pedido> lista = repository.findAll();
			for (Pedido entity : lista) {
				System.out.println(entity.getId() + " - " + entity.getVendedor().getNome() + " - " + entity.getCliente().getNome() + " - " + entity.getDtCadastro() + " - " + entity.getDtEmissao() + " - " + entity.getDtFaturamento() + " - " + entity.getValorTotal());
				for (PedidoProduto entityItem : entity.getItens()) {
					System.out.println(" -> " + entityItem.getProduto().getId() + " - " + entityItem.getProduto().getDescricao() + " - " + entityItem.getProduto().getValor());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void listItems() {
		try {
			Pedido entity = repository.findById(1);
			System.out.println(entity.getId() + " - " + entity.getVendedor().getNome() + " - " + entity.getCliente().getNome() + " - " + entity.getDtCadastro() + " - " + entity.getDtEmissao() + " - " + entity.getDtFaturamento() + " - " + entity.getValorTotal());
			//List<PedidoProduto> entityItens = repository.getItensByOrderId(entity.getId());
			for (PedidoProduto entityItem : entity.getItens()) {
				System.out.println(" -> " + entityItem.getProduto().getId() + " - " + entityItem.getProduto().getDescricao() + " - " + entityItem.getProduto().getValor());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

