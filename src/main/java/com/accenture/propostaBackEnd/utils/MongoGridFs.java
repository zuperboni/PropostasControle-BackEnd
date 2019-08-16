package com.accenture.propostaBackEnd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration

public class MongoGridFs extends AbstractMongoConfiguration{

	@Value("${jsa.mongo.address}")
	private String mongoAddress; 
	
	@Value("${jsa.mongo.database}")
	private String mongoDatabase;
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
	    return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
	
	@Override
	protected String getDatabaseName() {
		return mongoDatabase;
	}
 
	public Mongo mongo() {
		return new MongoClient(mongoAddress);
	}

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		return new MongoClient(mongoAddress);
	}
}

