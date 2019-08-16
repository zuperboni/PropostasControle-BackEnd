package com.accenture.propostaBackEnd.repository;

import org.springframework.stereotype.Repository;

import com.accenture.propostaBackEnd.dominio.Proposta;

@Repository
public interface PropostaRepository extends ResourceRepository<Proposta, String> {
}
