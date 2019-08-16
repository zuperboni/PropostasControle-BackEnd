package com.accenture.propostaBackEnd.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.propostaBackEnd.security.JWTUtil;
import com.accenture.propostaBackEnd.security.UserSS;
import com.accenture.propostaBackEnd.services.UsuarioService;
import com.accenture.propostaBackEnd.services.exception.AuthorizationException;
import static com.accenture.propostaBackEnd.utils.DefaultMessages.ACESSO_NEGADO;

/**
 * Classe de Mapeamento do recurso de atualização de Token.
 * @author Elias
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UsuarioService.authenticated();
		
		if(user == null) {
			throw new AuthorizationException(ACESSO_NEGADO.getMensagem());
		}
		
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

}
