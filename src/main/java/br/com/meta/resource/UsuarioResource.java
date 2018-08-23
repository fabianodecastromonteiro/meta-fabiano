package br.com.meta.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.service.UsuarioService;
import br.com.meta.model.Usuario;

@Component
@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/users")
	public List<Usuario> getAll() {
	    return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Void> getById(@PathVariable int id) {
		Usuario usuario = service.findById(id);
		if (usuario == null) 	
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/user")
	public Usuario create(@Valid @RequestBody Usuario usuario) {
	    return service.save(usuario);
	}
	
	@PostMapping("/login")
	public Usuario login(@Valid @RequestBody Usuario usuario) {
	    return service.login(usuario.getEmail(), usuario.getSenha());
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Void> update(@RequestBody Usuario usuario) {
		Usuario usuarioAlterado = service.update(usuario);
		if (usuarioAlterado == null)
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		service.delete(id);
	}
	
}