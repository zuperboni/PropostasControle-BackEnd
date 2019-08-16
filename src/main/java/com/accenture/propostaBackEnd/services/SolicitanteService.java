package com.accenture.propostaBackEnd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.propostaBackEnd.dominio.Solicitante;
import com.accenture.propostaBackEnd.repository.SolicitanteRepository;

@Service
public class SolicitanteService {

	@Autowired
	private SolicitanteRepository repo;
	
	public List<Solicitante> findAll(){
		return repo.findAll();
	}
	
	public Solicitante save(Solicitante solicitante) {
		try {
		return repo.save(solicitante);
		}
		catch (RuntimeException erro) {
			throw new RuntimeException();
		}
	}	
}
