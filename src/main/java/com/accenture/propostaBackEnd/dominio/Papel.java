/**
 * 
 */
package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author monica.dos.santos
 *
 */
@Document
public class Papel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;	
	private String desPapel;	
	
	public Papel() {
		// TODO Auto-generated constructor stub
	}

	public String getDesPapel() {
		return desPapel;
	}

	public void setDesPapel(String desPapel) {
		this.desPapel = desPapel;
	}

}
