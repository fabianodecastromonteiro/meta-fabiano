package br.com.meta;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.meta.model.Usuario;
import br.com.meta.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UsuarioTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	public void list() {
		try {
			List<Usuario> lista = repository.findAll();
			for (Usuario entity : lista) {
				System.out.println(entity.getId() + " - " + entity.getNome() + " - " + entity.getEmail() + " - " + entity.getTipo().getId() + " - " + entity.getTipo().getDescricao());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void login() {
		try {
			Usuario entity = repository.logon("admin@stling.com", "123");
			if (entity != null) {
				System.out.println(entity.getId() + " - " + entity.getNome() + " - " + entity.getEmail() + " - " + entity.getTipo().getId() + " - " + entity.getTipo().getDescricao());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

