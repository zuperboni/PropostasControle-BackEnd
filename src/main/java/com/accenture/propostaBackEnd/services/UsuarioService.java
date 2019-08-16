package com.accenture.propostaBackEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.propostaBackEnd.dominio.Usuario;
import com.accenture.propostaBackEnd.repository.UsuarioRepository;
import com.accenture.propostaBackEnd.security.UserSS;
import com.accenture.propostaBackEnd.services.exception.ObjectNotFoundException;
import com.accenture.propostaBackEnd.services.exception.UsuarioDuplicadoException;
import com.mongodb.MongoWriteException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnc;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

	public Usuario findById(String email) {
		Optional<Usuario> usr = repo.findById(email);
		return usr.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public Usuario insert(Usuario obj) {
		obj.setSenha(passwordEnc.encode(obj.getSenha()));
		obj.setEmail(obj.getEmail().toLowerCase());
		
		try {
			return repo.insert(obj);

		} catch (RuntimeException erro) {
			if(erro.getCause() instanceof MongoWriteException) {
				throw new UsuarioDuplicadoException(erro.getMessage(), obj);
			}else {
				throw new RuntimeException();
			}
			

		}
	}
	
	/**
	 * Método que recupera o usuário logado na aplicação.
	 * @return
	 */
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception erro) {
			return null;
		}
	}
	
	
}
