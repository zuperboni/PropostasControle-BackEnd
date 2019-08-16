package com.accenture.propostaBackEnd.resources.exception;

import static com.accenture.propostaBackEnd.utils.DefaultMessages.*;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.propostaBackEnd.services.exception.AuthorizationException;
import com.accenture.propostaBackEnd.services.exception.ObjectNotFoundException;
import com.accenture.propostaBackEnd.services.exception.UsuarioDuplicadoException;

/**
 * Classe manipuladora de Exceções dos Recursos da Aplicação.
 * @author Elias
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Manipula a exceção {@code ObjectNotFoundException} quando lançada
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		return ResponseEntity.status(status).build();
	}
	
	/**
	 * Manipula a exceção {@code UsuarioDuplicadoException} quando lançada
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UsuarioDuplicadoException.class)
	public ResponseEntity<StandardErro> usuarioDuplicado(UsuarioDuplicadoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").buildAndExpand(e.getUsuario().getEmail()).toUri();
		StandardErro err = new StandardErro(status.value(), status.getReasonPhrase(),
				USUARIO_DUPLICADO.format(e.getUsuario().getEmail()), 
				uri.getPath());
		
		return ResponseEntity.status(status).body(err);
	}
	
	/**
	 * Manipula a exceção {@code AuthorizationException} quando lançada
	 */
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardErro> notAuthorization(AuthorizationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.FORBIDDEN;
				
		StandardErro err = new StandardErro(status.value(), status.getReasonPhrase(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	/**
	 * Manipula a exceção {@code AuthorizationException} quando lançada
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErro> beanValidationRequest(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
				
		ValidationError err = new ValidationError(status.value(), status.getReasonPhrase(), ERRO_VALIDACAO.getMensagem(), request.getRequestURI());
		
		for(FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	
}
