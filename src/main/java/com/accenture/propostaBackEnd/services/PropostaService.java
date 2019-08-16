package com.accenture.propostaBackEnd.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.accenture.propostaBackEnd.dominio.Proposta;
import com.accenture.propostaBackEnd.repository.PropostaRepository;
import com.accenture.propostaBackEnd.services.exception.ObjectNotFoundException;

@Service
public class PropostaService {
	@Autowired
	private PropostaRepository repo;

	private EntityManager entityManager;

	public List<Proposta> findAll(){
		return repo.findAll();
	}
	
	public Page<Proposta> findAll(final Query query, final Pageable pageable){
		return repo.findAll(query,pageable);
	}
	
	/*public List<Proposta> search(List<SearchCriteria> params){
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Proposta> query = builder.createQuery(Proposta.class);
		final Root r = query.from(Proposta.class);

		Predicate predicate = builder.conjunction();
		PropostaSearchQueryCriteriaConsumer searchConsumer = new PropostaSearchQueryCriteriaConsumer(predicate, builder, r);
		params.stream().forEach(searchConsumer);
		predicate = searchConsumer.getPredicate();
		query.where(predicate);

		return entityManager.createQuery(query).getResultList();
	}
	*/
	public Proposta findById(String id) {
		Optional<Proposta> proposta = repo.findById(id);
		return proposta.orElseThrow(() -> new ObjectNotFoundException());
	}
	
	public Proposta save(Proposta proposta) {
		try {
		return repo.save(proposta);
		}
		catch (RuntimeException erro) {
			throw new RuntimeException();
		}
	}		
	
	public Proposta update(Proposta proposta) {
		try {	
		return repo.save(proposta);
		}
		catch (RuntimeException erro) {
			throw new RuntimeException();
		}
	}
}
