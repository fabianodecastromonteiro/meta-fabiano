package br.com.meta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.meta.model.Pedido;
import br.com.meta.model.PedidoProduto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("SELECT p FROM Pedido p WHERE p.id = :id")
    Pedido findById(@Param("id") int id);

	@Query("SELECT p.itens FROM Pedido p WHERE p.id = :id")
	List<PedidoProduto> getItensByOrderId(@Param("id") int id);
	
	//	@Query("SELECT p FROM Pedido p WHERE p.id = :id")
//    Pedido itensByOrderId(@Param("id") int id);

}
