package com.accenture.propostaBackEnd.resources;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.propostaBackEnd.dominio.Proposta;
import com.accenture.propostaBackEnd.services.PropostaService;

@RestController
@RequestMapping("/propostas")
public class PropostaResource {

	@Autowired
	private PropostaService service;


	@GetMapping
	public ResponseEntity<List<Proposta>> findAll() {
		List<Proposta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Proposta> findById(@PathVariable String id) {
		Proposta proposta = service.findById(id);
		return ResponseEntity.ok().body(proposta);
	}
	
	// Método para o mecanismo de busca
	@RequestMapping(method = RequestMethod.GET, value = "/buscar")
	@ResponseBody
	public Page<Proposta> findAllBySpecification(@RequestParam(value = "search") String search) {
	    //List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	    Pageable pageable = PageRequest.of(0, 3, Sort.by("codDemanda"));
	    Query query = new Query();
	   
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?.+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {           	
            	// Verifica se são campos de ID para fazer o cast para ObjectID
            	if(matcher.group(1).contains("id")) {
                    query.addCriteria(Criteria.where(matcher.group(1)).is(new ObjectId(matcher.group(3))));
            	}
            	else {
            		query.addCriteria(Criteria.where(matcher.group(1)).is(matcher.group(3)));
            	}
            }
        }

	    return service.findAll(query, pageable);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proposta> create(@RequestBody Proposta proposta) {
		service.save(proposta);
		return ResponseEntity.ok().body(proposta);

	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proposta> update(@RequestBody Proposta proposta) {
		service.update(proposta);
		return ResponseEntity.ok().body(proposta);
	}

}
