package com.accenture.propostaBackEnd.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.accenture.propostaBackEnd.security.JWTAuthenticationFilter;
import com.accenture.propostaBackEnd.security.JWTAuthorizationFilter;
import com.accenture.propostaBackEnd.security.JWTUtil;

/**
 * Classe de segurança dos recursos da API
 * @author Elias
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	/**
	 * Recursos públicos nos quais não será necessário autenticação
	 * TODO por enquanto foi definido que todas as URI poderão ser acessadas
	 * pois estamos em faze de desenvolvimento.
	 */
	private static final String[] PUBLIC_MATCHERS = {
		"/**"
		/*Exemplo de URL 
		 * "/usuarios/**",
		 * "/propostas/**"
		 */	
			
	};
	/* TODO Exemplo de Matchers específico por method da requisição
	private static final String[] PUBLIC_MATCHERS_GET = { "/**" };
	*/
	
	/**
	 * Método de configuração das permissões de acesso.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable();/*Habilita o CROSS-ORIGIN para as chamadas e desabilita os ataques csrf de Sessão*/
		
		//Autorização das requisições
		http.authorizeRequests()
			
			/* TODO Exemplo de permissão específico para métodos
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			*/
			
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();//TODO Definir quais métodos necessitara de autenticacao
		
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Define nossas requisições para não guardar dados de Sessão.
		
		   http
           .authorizeRequests()
               .antMatchers("/uploadFile", "/uploadMultipleFiles", "/downloadFile/**")
                   .permitAll()
               .anyRequest()
                   .authenticated();
	}
	
	/**
	 * Método responsável por configurar o serviço de autenticação e de criptografia
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	/**	
	 * Método que abilita as chamadas de CROSS-ORIGIN Default para podermos chamar no App.
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	/**
	 * Habilita a criptografia da senha dos Usuários 
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
