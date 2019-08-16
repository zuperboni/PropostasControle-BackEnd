/**
 * 
 */
package com.accenture.propostaBackEnd.resources;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.propostaBackEnd.dominio.Papel;
import com.accenture.propostaBackEnd.dominio.Solicitante;
import com.accenture.propostaBackEnd.services.PapelService;

/**
 * @author monica.dos.santos
 *
 */
@RestController
@RequestMapping("/papeis")
public class PapelResource {

	@Autowired
	private PapelService service;
	@GetMapping
	public ResponseEntity<Object[]> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:8080/spring-rest/foos";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		//System.out.println(objects.toString());
		//List<Papel> list = service.findAll();
		return null;
	}
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Papel papel) {
		service.save(papel);
	}
}
