package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Time implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer qtdProfissional;
	private Boolean isQtdPercentual;
	private String desPapelTime;
	
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Time(Integer qtdProfissional, Boolean isQtdPercentual, String desPapelTime) {
		super();
		this.qtdProfissional = qtdProfissional;
		this.isQtdPercentual = isQtdPercentual;
		this.desPapelTime = desPapelTime;
	}
	public Integer getQtdProfissional() {
		return qtdProfissional;
	}
	public void setQtdProfissional(Integer qtdProfissional) {
		this.qtdProfissional = qtdProfissional;
	}
	public Boolean getIsQtdPercentual() {
		return isQtdPercentual;
	}
	public void setIsQtdPercentual(Boolean isQtdPercentual) {
		this.isQtdPercentual = isQtdPercentual;
	}
	public String getDesPapelTime() {
		return desPapelTime;
	}
	public void setDesPapelTime(String desPapelTime) {
		this.desPapelTime = desPapelTime;
	}
	
	@Override
	public String toString() {
		return "Time [qtdProfissional=" + qtdProfissional + ", isQtdPercentual=" + isQtdPercentual + ", desPapelTime="
				+ desPapelTime + "]";
	}
}
