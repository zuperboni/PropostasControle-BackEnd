package com.accenture.propostaBackEnd.dominio;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Atividade implements Serializable{
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Usuario usuarioAutor;
	private String datRegistro;
	private String desDetalhamentoAtividade;
	
	
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Atividade(String desDetalhamentoAtividade) {
		super();
		//this.datRegistro= java.util.Calendar.getInstance().getTime();
		this.desDetalhamentoAtividade=desDetalhamentoAtividade;
	}
	
	
	public Atividade(Usuario usuarioAutor, String datRegistro, String desDetalhamentoAtividade) {
		super();
		this.usuarioAutor = usuarioAutor;
		this.datRegistro = datRegistro;
		this.desDetalhamentoAtividade = desDetalhamentoAtividade;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Usuario getUsuarioAutor() {
		return usuarioAutor;
	}
	public void setUsuarioAutor(Usuario usuarioAutor) {
		this.usuarioAutor = usuarioAutor;
	}
	public String getDatRegistro() {
		return datRegistro;
	}
	public void setDatRegistro(String datRegistro) {
		this.datRegistro = datRegistro;
	}
	public String getDesDetalhamentoAtividade() {
		return desDetalhamentoAtividade;
	}
	public void setDesDetalhamentoAtividade(String desDetalhamentoAtividade) {
		this.desDetalhamentoAtividade = desDetalhamentoAtividade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
