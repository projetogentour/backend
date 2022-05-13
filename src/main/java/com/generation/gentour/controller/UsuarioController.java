package com.generation.gentour.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gentour.model.Produto;
import com.generation.gentour.model.Usuario;
import com.generation.gentour.model.UsuarioLogin;
import com.generation.gentour.repository.UsuarioRepository;
import com.generation.gentour.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastraUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.cadastrarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> logaUsuario(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.autenticarUsuario(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(usuario).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

	/*
	 * @GetMapping CRUD feito antes do security/service public
	 * ResponseEntity<List<Usuario>>getALL(){ return
	 * ResponseEntity.ok(repository.findAll()); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Usuario> GetById(@PathVariable
	 * Long id){ return repository.findById(id).map(resp ->
	 * ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @GetMapping("/nomeCompleto/{nomeCompleto}") public
	 * ResponseEntity<List<Usuario>> getByTipo(@PathVariable String nomeCompleto){
	 * return
	 * ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(
	 * nomeCompleto)); }
	 * 
	 * @PostMapping public ResponseEntity<Usuario> post (@Valid @RequestBody Usuario
	 * usuario){ return
	 * ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario)); }
	 * 
	 * @PutMapping public ResponseEntity<Usuario> put (@RequestBody Usuario
	 * usuario){ return
	 * ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario)); }
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
	 * repository.deleteById(id); }
	 */

}
