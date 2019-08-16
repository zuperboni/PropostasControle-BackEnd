/**
 * 
 */
package com.accenture.propostaBackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.propostaBackEnd.dominio.Papel;

/**
 * @author monica.dos.santos
 *
 */
public interface PapelRepository extends MongoRepository<Papel,String>{

}
