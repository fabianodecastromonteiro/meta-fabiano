package br.com.meta;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.meta.model.Produto;
import br.com.meta.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProdutoTest {

	@Autowired
	private ProdutoRepository repository;

	@Test
	public void tipoUsuarioList() {
		try {
			List<Produto> lista = repository.findAll();
			for (Produto entity : lista) {
				System.out.println(entity.getId() + " - " + entity.getDescricao() + " - " + entity.getValor());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

