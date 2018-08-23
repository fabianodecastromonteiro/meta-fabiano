package br.com.meta;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.meta.model.Cliente;
import br.com.meta.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ClienteTest {

	@Autowired
	private ClienteRepository repository;

	@Test
	public void tipoUsuarioList() {
		try {
			List<Cliente> lista = repository.findAll();
			for (Cliente entity : lista) {
				System.out.println(entity.getId() + " - " + entity.getNome() + " - " + entity.getCpfCnpj() + " - " + entity.getEndereco());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

