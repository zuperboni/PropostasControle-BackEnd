package com.accenture.propostaBackEnd.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import com.accenture.propostaBackEnd.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DTO da classe Usuário para retorno de dados. 
 * @author Elias
 */
public class UsuarioDTO implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -3056586917010244656L;

	@Id
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String email;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	
	@JsonIgnore
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String senha;

	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario usr) {
		this.email = usr.getEmail();
		this.nome = usr.getNome();
		this.senha = usr.getSenha();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		UsuarioDTO other = (UsuarioDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
}
