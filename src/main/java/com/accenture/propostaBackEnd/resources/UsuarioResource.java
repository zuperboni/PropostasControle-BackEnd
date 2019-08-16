package com.accenture.propostaBackEnd.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.propostaBackEnd.dominio.Usuario;
import com.accenture.propostaBackEnd.dto.UsuarioDTO;
import com.accenture.propostaBackEnd.services.UsuarioService;
import com.accenture.propostaBackEnd.utils.StandardResponse;;

/**
 * Classe de acesso aos recursos pertinentes ao Usuário.
 * @author Elias
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(x-> new UsuarioDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String email){
		Usuario usr = service.findById(email);
		return ResponseEntity.ok().body(new UsuarioDTO(usr));
		
	}
	
	@PostMapping
	public ResponseEntity<StandardResponse> insert(@Valid @RequestBody Usuario usr){
		UsuarioDTO obj = new UsuarioDTO(service.insert(usr));
		
		//Cria URL de acesso ao Usuário salvo na base, sendo exibido através da aba HEADERS.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").buildAndExpand(obj.getEmail()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}

}
