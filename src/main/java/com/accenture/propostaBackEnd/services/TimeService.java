package com.accenture.propostaBackEnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.propostaBackEnd.dominio.Time;
import com.accenture.propostaBackEnd.repository.TimeRepository;


@Service
public class TimeService {
	@Autowired
	private TimeRepository repo;
	public List<Time> findAll(){
		return repo.findAll();
	}
	
	public Time save(Time time) {
		try {
		return repo.save(time);
		}
		catch (RuntimeException erro) {
			throw new RuntimeException();
		}
	}	
}
