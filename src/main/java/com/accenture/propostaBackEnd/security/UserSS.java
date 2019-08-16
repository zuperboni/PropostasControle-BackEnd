package com.accenture.propostaBackEnd.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe que representa o Login de um usuário no sistema, implementando a interface do Spring Security. 
 * @author Elias
 */
public class UserSS implements UserDetails {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -7218923343243723405L;
	
	private String email;
	private String senha;
	
	public UserSS() {
	}
	
	public UserSS(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Criar depois os perfis de usuários com as permissões.
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
