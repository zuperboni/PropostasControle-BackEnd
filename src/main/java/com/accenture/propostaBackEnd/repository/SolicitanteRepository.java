package com.accenture.propostaBackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.accenture.propostaBackEnd.dominio.Solicitante;


@Repository
public interface SolicitanteRepository extends MongoRepository<Solicitante, String>{

}
