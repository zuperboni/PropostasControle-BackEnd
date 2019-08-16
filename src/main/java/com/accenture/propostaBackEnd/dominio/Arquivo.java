package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.accenture.propostaBackEnd.dto.UsuarioDTO;

@Document
public class Arquivo implements Serializable {

	/**
	 * @author monica.dos.santos
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nome;
	private String URLDownload;
	private String tipoArquivo;
	private String tamanho;
	private UsuarioDTO usuario;
	private String dataUpload;

	public Arquivo() {
		// TODO Auto-generated constructor stub
	}

	public Arquivo(String id, String nome, String uRLDownload, String tipoArquivo, String tamanho, UsuarioDTO usuario, String dataUpload) {
		super();
		this.id = id;
		this.nome = nome;
		this.URLDownload = uRLDownload;
		this.tipoArquivo = tipoArquivo;
		this.tamanho = tamanho;
		this.usuario = usuario;
		this.dataUpload = dataUpload;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getURLDownload() {
		return URLDownload;
	}

	public void setURLDownload(String uRLDownload) {
		URLDownload = uRLDownload;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(String dataUpload) {
		this.dataUpload = dataUpload;
	}

}
