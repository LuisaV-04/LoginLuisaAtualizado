package com.projetoLoginLuisa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLoginLuisa.Entity.Login;
import com.projetoLoginLuisa.Service.LoginService;

@RestController
@RequestMapping("/users")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Login> buscarLoginId(@PathVariable Long id) {
		Login login = loginService.buscarLoginPorId(id);
		if (login != null) {
			return ResponseEntity.ok(login);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Login>> buscarTodosLogin() {
		List<Login> produtos = loginService.buscarTodosLogin();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping("/")
	public ResponseEntity<Login> salvaProduto(@RequestBody Login login) {
		Login saveLogin = loginService.salvarLogin(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveLogin);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Login> alteraProdutos(@PathVariable Long id, @RequestBody Login login) {
		Login atualizaLogin = loginService.atualizarLogin(id, login);
		if (atualizaLogin != null) {
			return ResponseEntity.ok(atualizaLogin); 
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Login> apagaLogin(@PathVariable Long id) {
		boolean apagaLogin = loginService.apagarLogin(id);
		if (apagaLogin) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	@PostMapping("/auth") 
	public ResponseEntity<Login> authenticate(@RequestBody Login loginDetails) {
		Login authenticatedUser = loginService.authenticate(loginDetails.getUsername(), loginDetails.getPassword());
		
		if (authenticatedUser != null) {
			// Retorna 200 OK com os dados do usuário (sem a senha se a autenticação for bem-sucedida
		authenticatedUser.setPassword(null); //Nunca retorne a senha para o front-end
		return ResponseEntity.ok(authenticatedUser);
		}
		//Retorna 401 Unauthorizated se as credenciais estiverem incorretas
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}