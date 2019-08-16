package com.accenture.propostaBackEnd.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Classe que inicia junto com o servidor, pode ser utilizada para testes. 
 * @author Elias
 */
@Configuration
public class Instantiation implements CommandLineRunner {

	/*@Autowired
	private UsuarioRepository UsuarioRepository;*/
	
	@Override
	public void run(String... args) throws Exception {
		/*UsuarioRepository.deleteAll();
		
		Usuario maria = new Usuario("maria@gmail.com","Maria Brown");
		Usuario alex = new Usuario("alex@gmail.com", "Alex Green");
		Usuario bob = new Usuario("bob@gmail.com", "Bob Grey");
		
		UsuarioRepository.saveAll(Arrays.asList(maria,alex,bob));*/
	}

}
