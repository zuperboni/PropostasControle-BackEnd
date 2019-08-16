package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.accenture.propostaBackEnd.dto.UsuarioDTO;

@Document
@Entity
public class Proposta implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String codDemanda;
	private String desDemanda;
	private String desResumoEscopo;
	private Solicitante solicitante;
	private UsuarioDTO nomResponsavelAcc; 
	private Integer numPriorizacaoSolicitante;
	private Date datSolicitacao;
	private String desStatusProposta;
	private Orcamento orcamento;
	private List<Atividade> atividades;
	private List<Arquivo> arquivos;
	
	//Classificacao da demanda
	// Agil E MUM
	private Boolean isDemandaAgil;
	private String desTipoDemanda;
	private Integer numHorasEstimadas;	
	private Date datInicio;
	private Date datTermino;
	private String desObservacao;
	
	// quando for demanda agil
	private Integer numSprints;
	private String tempoPorSprint; // Em dias?
	private Integer numHorasProdSprint;
	private List<Time> time;

	// quando for MUM
	private Integer numPF;
	private Integer numIP;
	private Boolean flagConciliacao;
	private String desJustificativa;
	private Boolean flagConcilicacaoAceita;	

	public Proposta() {}
	
	public Proposta(String id, String codDemanda, String desDemanda, String desResumoEscopo, Solicitante solicitante,
			UsuarioDTO nomResponsavelAcc, Integer numPriorizacaoSolicitante, Date datSolicitacao, String desStatusProposta,
			Orcamento orcamento, List<Atividade> atividades, List<Arquivo> arquivos,Boolean isDemandaAgil, String desTipoDemanda,
			Integer numHorasEstimadas, Date datInicio, Date datTermino, String desObservacao, Integer numSprints,
			String tempoPorSprint, Integer numHorasProdSprint, List<Time> time, Integer numPF, Integer numIP,
			Boolean flagConciliacao, String desJustificativa, Boolean flagConcilicacaoAceita) {
		super();
		this.id = id;
		this.codDemanda = codDemanda;
		this.desDemanda = desDemanda;
		this.desResumoEscopo = desResumoEscopo;
		this.solicitante = solicitante;
		this.nomResponsavelAcc = nomResponsavelAcc;
		this.numPriorizacaoSolicitante = numPriorizacaoSolicitante;
		this.datSolicitacao = datSolicitacao;
		this.desStatusProposta = desStatusProposta;
		this.orcamento = orcamento;
		this.atividades = atividades;
		this.arquivos = arquivos;
		this.isDemandaAgil = isDemandaAgil;
		this.desTipoDemanda = desTipoDemanda;
		this.numHorasEstimadas = numHorasEstimadas;
		this.datInicio = datInicio;
		this.datTermino = datTermino;
		this.desObservacao = desObservacao;
		this.numSprints = numSprints;
		this.tempoPorSprint = tempoPorSprint;
		this.numHorasProdSprint = numHorasProdSprint;
		this.time = time;
		this.numPF = numPF;
		this.numIP = numIP;
		this.flagConciliacao = flagConciliacao;
		this.desJustificativa = desJustificativa;
		this.flagConcilicacaoAceita = flagConcilicacaoAceita;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodDemanda() {
		return codDemanda;
	}

	public void setCodDemanda(String codDemanda) {
		this.codDemanda = codDemanda;
	}

	public String getDesDemanda() {
		return desDemanda;
	}

	public void setDesDemanda(String desDemanda) {
		this.desDemanda = desDemanda;
	}

	public String getDesResumoEscopo() {
		return desResumoEscopo;
	}

	public void setDesResumoEscopo(String desResumoEscopo) {
		this.desResumoEscopo = desResumoEscopo;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public UsuarioDTO getNomResponsavelAcc() {
		return nomResponsavelAcc;
	}

	public void setNomResponsavelAcc(UsuarioDTO nomResponsavelAcc) {
		this.nomResponsavelAcc = nomResponsavelAcc;
	}

	public Integer getNumPriorizacaoSolicitante() {
		return numPriorizacaoSolicitante;
	}

	public void setNumPriorizacaoSolicitante(Integer numPriorizacaoSolicitante) {
		this.numPriorizacaoSolicitante = numPriorizacaoSolicitante;
	}

	public Date getDatSolicitacao() {
		return datSolicitacao;
	}

	public void setDatSolicitacao(Date datSolicitacao) {
		this.datSolicitacao = datSolicitacao;
	}

	public String getDesStatusProposta() {
		return desStatusProposta;
	}

	public void setDesStatusProposta(String desStatusProposta) {
		this.desStatusProposta = desStatusProposta;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public Boolean getIsDemandaAgil() {
		return isDemandaAgil;
	}

	public void setIsDemandaAgil(Boolean isDemandaAgil) {
		this.isDemandaAgil = isDemandaAgil;
	}

	public String getDesTipoDemanda() {
		return desTipoDemanda;
	}

	public void setDesTipoDemanda(String desTipoDemanda) {
		this.desTipoDemanda = desTipoDemanda;
	}

	public Integer getNumHorasEstimadas() {
		return numHorasEstimadas;
	}

	public void setNumHorasEstimadas(Integer numHorasEstimadas) {
		this.numHorasEstimadas = numHorasEstimadas;
	}

	public Date getDatInicio() {
		return datInicio;
	}

	public void setDatInicio(Date datInicio) {
		this.datInicio = datInicio;
	}

	public Date getDatTermino() {
		return datTermino;
	}

	public void setDatTermino(Date datTermino) {
		this.datTermino = datTermino;
	}

	public String getDesObservacao() {
		return desObservacao;
	}

	public void setDesObservacao(String desObservacao) {
		this.desObservacao = desObservacao;
	}

	public Integer getNumSprints() {
		return numSprints;
	}

	public void setNumSprints(Integer numSprints) {
		this.numSprints = numSprints;
	}

	public String getTempoPorSprint() {
		return tempoPorSprint;
	}

	public void setTempoPorSprint(String tempoPorSprint) {
		this.tempoPorSprint = tempoPorSprint;
	}

	public Integer getNumHorasProdSprint() {
		return numHorasProdSprint;
	}

	public void setNumHorasProdSprint(Integer numHorasProdSprint) {
		this.numHorasProdSprint = numHorasProdSprint;
	}

	public List<Time> getTime() {
		return time;
	}

	public void setTime(List<Time> time) {
		this.time = time;
	}

	public Integer getNumPF() {
		return numPF;
	}

	public void setNumPF(Integer numPF) {
		this.numPF = numPF;
	}

	public Integer getNumIP() {
		return numIP;
	}

	public void setNumIP(Integer numIP) {
		this.numIP = numIP;
	}

	public Boolean getFlagConciliacao() {
		return flagConciliacao;
	}

	public void setFlagConciliacao(Boolean flagConciliacao) {
		this.flagConciliacao = flagConciliacao;
	}

	public String getDesJustificativa() {
		return desJustificativa;
	}

	public void setDesJustificativa(String desJustificativa) {
		this.desJustificativa = desJustificativa;
	}

	public Boolean getFlagConcilicacaoAceita() {
		return flagConcilicacaoAceita;
	}

	public void setFlagConcilicacaoAceita(Boolean flagConcilicacaoAceita) {
		this.flagConcilicacaoAceita = flagConcilicacaoAceita;
	}
	
	
	
}
