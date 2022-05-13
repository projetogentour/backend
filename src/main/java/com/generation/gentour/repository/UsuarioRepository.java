package com.generation.gentour.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gentour.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//public List<Usuario> findAllByNomeCompletoContainingIgnoreCase(String nomeCompleto);
	public Optional<Usuario> findByUsuario(String usuario); //security 

}

