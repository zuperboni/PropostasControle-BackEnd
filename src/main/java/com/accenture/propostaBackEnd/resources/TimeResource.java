package com.accenture.propostaBackEnd.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.propostaBackEnd.dominio.Time;
import com.accenture.propostaBackEnd.services.TimeService;



@RestController
@RequestMapping("/times")
public class TimeResource {

	@Autowired
	private TimeService service;
	
	@GetMapping
	public ResponseEntity<List<Time>> findAll() {
		List<Time> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Time time) {
		service.save(time);
	}
}
