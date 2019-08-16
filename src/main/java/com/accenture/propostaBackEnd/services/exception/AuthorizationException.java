package com.accenture.propostaBackEnd.services.exception;

/**
 * Classe de exceção de Autorização de Usuário.
 * @author Elias
 *
 */
public class AuthorizationException extends RuntimeException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8852247114088247700L;
	
	public AuthorizationException(String mensagem) {
		super(mensagem);
	}
	
	public AuthorizationException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
