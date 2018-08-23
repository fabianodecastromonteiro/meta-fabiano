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

import br.com.meta.service.ProdutoService;
import br.com.meta.model.Produto;

@Component
@RestController
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	@GetMapping("/products")
	public List<Produto> getAll() {
	    return service.findAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Void> getById(@PathVariable int id) {
		Produto entity = service.findById(id);
		if (entity == null) 	
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/product")
	public Produto create(@Valid @RequestBody Produto entity) {
	    return service.save(entity);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Void> update(@RequestBody Produto entity) {
		Produto entityAlterado = service.update(entity);
		if (entityAlterado == null)
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		service.delete(id);
	}
	
}