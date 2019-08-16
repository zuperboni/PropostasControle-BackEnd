package com.accenture.propostaBackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.accenture.propostaBackEnd.dominio.Time;

@Repository
public interface TimeRepository extends MongoRepository<Time,String>{

}
