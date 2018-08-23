package br.com.meta;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.meta.model.TipoUsuario;
import br.com.meta.repository.TipoUsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TipoUsuarioTest {

	@Autowired
	private TipoUsuarioRepository repository;

	@Test
	public void tipoUsuarioList() {
		try {
			 List<TipoUsuario> lista = repository.findAll();
			for (TipoUsuario entity : lista) {
				System.out.println(entity.getId() + " - " + entity.getDescricao());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

