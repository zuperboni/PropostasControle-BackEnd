package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Orcamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean isOrcamentoDetalhado;
	private String prazoOrcamento;
	private Boolean flagPossuiDetalhamento;
	private String notaEntryCriteria;

	public Orcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orcamento(Boolean isOrcamentoDetalhado, String prazoOrcamento, Boolean flagPossuiDetalhamento,
			String notaEntryCriteria) {
		super();
		this.isOrcamentoDetalhado = isOrcamentoDetalhado;
		this.prazoOrcamento = prazoOrcamento;
		this.flagPossuiDetalhamento = flagPossuiDetalhamento;
		this.notaEntryCriteria = notaEntryCriteria;
	}

	public Boolean getIsOrcamentoDetalhado() {
		return isOrcamentoDetalhado;
	}

	public void setIsOrcamentoDetalhado(Boolean isOrcamentoDetalhado) {
		this.isOrcamentoDetalhado = isOrcamentoDetalhado;
	}

	public String getPrazoOrcamento() {
		return prazoOrcamento;
	}

	public void setPrazoOrcamento(String prazoOrcamento) {
		this.prazoOrcamento = prazoOrcamento;
	}

	public Boolean getFlagPossuiDetalhamento() {
		return flagPossuiDetalhamento;
	}

	public void setFlagPossuiDetalhamento(Boolean flagPossuiDetalhamento) {
		this.flagPossuiDetalhamento = flagPossuiDetalhamento;
	}

	public String getNotaEntryCriteria() {
		return notaEntryCriteria;
	}

	public void setNotaEntryCriteria(String notaEntryCriteria) {
		this.notaEntryCriteria = notaEntryCriteria;
	}

	@Override
	public String toString() {
		return "Orcamento [isOrcamentoDetalhado=" + isOrcamentoDetalhado + ", prazoOrcamento=" + prazoOrcamento
				+ ", flagPossuiDetalhamento=" + flagPossuiDetalhamento + ", notaEntryCriteria=" + notaEntryCriteria
				+ "]";
	}

}
