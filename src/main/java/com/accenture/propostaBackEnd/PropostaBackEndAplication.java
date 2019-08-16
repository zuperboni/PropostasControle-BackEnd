package com.accenture.propostaBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.accenture.propostaBackEnd.repository.repositoryimpl.ResourceRepositoryImpl;
import com.accenture.propostaBackEnd.resources.property.FileStorageProperties;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = ResourceRepositoryImpl.class)
@EnableConfigurationProperties({FileStorageProperties.class})
public class PropostaBackEndAplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PropostaBackEndAplication.class, args);
		
	}
}
