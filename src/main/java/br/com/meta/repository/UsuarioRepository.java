package br.com.meta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.meta.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario findById(@Param("id") int id);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Usuario logon(@Param("email") String email, @Param("senha") String senha);

}
