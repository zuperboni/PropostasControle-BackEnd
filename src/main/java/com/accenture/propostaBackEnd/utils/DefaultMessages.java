package com.accenture.propostaBackEnd.utils;

import java.io.Serializable;

/**
 * Classe de Mensagens padrão para todo o sistema.
 * @author Elias
 */
public enum DefaultMessages implements Serializable {
	
	USUARIO_DUPLICADO("Usuário %s já cadastrado."),
	ACESSO_NEGADO("Acesso Negado."),
	ERRO_VALIDACAO("Erro ao validar os dados da requisição."),
	NOT_NULL("O campo não pode ser null."),
	NOT_EMPTY("O campo não pode ser vazio.");
	
	private String mensagem;
	
	DefaultMessages(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public String format(Object... parametros) {
		return String.format(this.getMensagem(), parametros);
	}
	
	
}
