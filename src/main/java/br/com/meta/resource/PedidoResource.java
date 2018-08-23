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

import br.com.meta.service.PedidoService;
import br.com.meta.model.Pedido;

@Component
@RestController
public class PedidoResource {
	
	@Autowired
	private PedidoService service;

	@GetMapping("/orders")
	public List<Pedido> getAll() {
		List<Pedido> lista = service.findAll();
	    return lista;
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Void> getById(@PathVariable int id) {
		Pedido entity = service.findById(id);
		if (entity == null) 	
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/order")
	public Pedido create(@Valid @RequestBody Pedido entity) {
	    return service.save(entity);
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<Void> update(@RequestBody Pedido entity) {
		Pedido entityAlterado = service.update(entity);
		if (entityAlterado == null)
	        return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/order/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		service.delete(id);
	}
	
}