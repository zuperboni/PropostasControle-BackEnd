package com.accenture.propostaBackEnd.resources.exception;

import java.io.Serializable;
import java.util.Date;

import com.accenture.propostaBackEnd.utils.DataUtil;

/**
 * Classe de padronização de erros na aplicação. 
 * @author Elias
 *
 */
public class StandardErro implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	private Integer status;
	private String error;
	private String menssage;
	private String path;
	
	public StandardErro(Integer status, String error, String menssage, String path) {
		this.timestamp = DataUtil.formatarTimestamp(new Date());
		this.status = status;
		this.error = error;
		this.menssage = menssage;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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
	
	@Override
	public String toString() {
		return "{\"timestamp\": \""+getTimestamp()+"\", "
                + "\"status\": \""+getStatus()+"\", "
                + "\"error\": \""+getError()+"\", "
                + "\"message\": \""+getMenssage()+"\", "
                + "\"path\": \"/"+getPath()+"\"}";
	}

}
