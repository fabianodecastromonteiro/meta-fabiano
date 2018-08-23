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

import br.com.meta.service.ClienteService;
import br.com.meta.model.Cliente;

@Component
@RestController
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	@GetMapping("/customers")
	public List<Cliente> getAll() {
	    return service.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Void> getById(@PathVariable int id) {
		Cliente entity = service.findById(id);
		if (entity == null) 	
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/customer")
	public Cliente create(@Valid @RequestBody Cliente entity) {
	    return service.save(entity);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Void> update(@RequestBody Cliente entity) {
		Cliente entityAlterado = service.update(entity);
		if (entityAlterado == null)
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/customer/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		service.delete(id);
	}
	
}