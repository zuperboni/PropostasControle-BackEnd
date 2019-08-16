package com.accenture.propostaBackEnd.services.exception;

import com.accenture.propostaBackEnd.dominio.Usuario;

/**
 * Classe de erro para quando tentar cadastrar um usuário já existente. 
 * @author Elias
 */
public class UsuarioDuplicadoException extends RuntimeException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7973943125965639224L;
	
	private Usuario usuario;
	
	public UsuarioDuplicadoException(String msg, Usuario obj) {
		super(msg);
		this.usuario = obj;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
