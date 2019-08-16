package com.accenture.propostaBackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.accenture.propostaBackEnd.dominio.Usuario;

/**
 * Classe de repositório para acesso aos dados dos Usuários. 
 * @author Elias
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
