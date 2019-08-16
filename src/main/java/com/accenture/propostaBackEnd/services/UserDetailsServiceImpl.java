package com.accenture.propostaBackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.accenture.propostaBackEnd.dominio.Usuario;
import com.accenture.propostaBackEnd.repository.UsuarioRepository;
import com.accenture.propostaBackEnd.security.UserSS;
import com.accenture.propostaBackEnd.services.exception.ObjectNotFoundException;

/**
 * Classe que disponibiliza o serviço de busca de usuário por email, implementando a interface do Spring Security. 
 * @author Elias
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email){
		Usuario usr = repo.findById(email).orElseThrow(() -> new ObjectNotFoundException());
		
		return new UserSS(usr.getEmail(), usr.getSenha());
	}

}
