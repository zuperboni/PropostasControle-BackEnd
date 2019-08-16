package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Solicitante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;	
	private String desCliente;	
	private String desProjeto;
	private String desNomeSolicitante;	
	private String desArea;	
	private String desCargo;
	
	
	public Solicitante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitante(String desNomeSolicitante) {
		super();
		this.desNomeSolicitante = desNomeSolicitante;
	}

	public Solicitante(String id, String desCliente, String desProjeto, String desNomeSolicitante, String desArea,
			String desCargo) {
		super();
		this.id = id;
		this.desCliente = desCliente;
		this.desProjeto = desProjeto;
		this.desNomeSolicitante = desNomeSolicitante;
		this.desArea = desArea;
		this.desCargo = desCargo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesCliente() {
		return desCliente;
	}

	public void setDesCliente(String desCliente) {
		this.desCliente = desCliente;
	}

	public String getDesProjeto() {
		return desProjeto;
	}

	public void setDesProjeto(String desProjeto) {
		this.desProjeto = desProjeto;
	}

	public String getDesNomeSolicitante() {
		return desNomeSolicitante;
	}

	public void setDesNomeSolicitante(String desNomeSolicitante) {
		this.desNomeSolicitante = desNomeSolicitante;
	}

	public String getDesArea() {
		return desArea;
	}

	public void setDesArea(String desArea) {
		this.desArea = desArea;
	}

	public String getDesCargo() {
		return desCargo;
	}

	public void setDesCargo(String desCargo) {
		this.desCargo = desCargo;
	}


}
