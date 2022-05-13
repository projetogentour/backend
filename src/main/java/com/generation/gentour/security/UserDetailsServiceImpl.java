package com.generation.gentour.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.gentour.model.Usuario;
import com.generation.gentour.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByUsuario(userName);

		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + "Este usuário não foi encontrado."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}
