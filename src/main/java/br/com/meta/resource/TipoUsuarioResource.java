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

import br.com.meta.service.TipoUsuarioService;
import br.com.meta.model.TipoUsuario;

@Component
@RestController
public class TipoUsuarioResource {
	
	@Autowired
	private TipoUsuarioService service;

	@GetMapping("/usertypes")
	public List<TipoUsuario> getAll() {
	    return service.findAll();
	}
	
	@GetMapping("/usertype/{id}")
	public ResponseEntity<Void> getById(@PathVariable int id) {
		TipoUsuario tipoUsuario = service.findById(id);
		if (tipoUsuario == null) 	
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/usertype")
	public TipoUsuario create(@Valid @RequestBody TipoUsuario tipoUsuario) {
	    return service.save(tipoUsuario);
	}
	
	@PutMapping("/usertype/{id}")
	public ResponseEntity<Void> update(@RequestBody TipoUsuario tipoUsuario) {
		TipoUsuario tipoUsuarioAlterado = service.update(tipoUsuario);
		if (tipoUsuarioAlterado == null)
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/usertype/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		service.delete(id);
	}
	
}