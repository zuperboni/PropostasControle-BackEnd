/**
 * 
 */
package com.accenture.propostaBackEnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.propostaBackEnd.dominio.Papel;
import com.accenture.propostaBackEnd.repository.PapelRepository;

/**
 * @author monica.dos.santos
 *
 */
@Service
public class PapelService {

@Autowired
private PapelRepository repo;

public List<Papel> findAll(){
	return repo.findAll();
}
public Papel save(Papel papel) {
	try {
	return repo.save(papel);
	}
	catch (RuntimeException erro) {
		throw new RuntimeException();
	}
}

}
