package com.accenture.propostaBackEnd.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StandardResponse implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8206943041680561048L;

	private String timestamp;
	private String menssage;
	private String path;

	public StandardResponse(String menssage, String path) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		this.timestamp = dateFormat.format(new Date()); 
		this.menssage = menssage;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
