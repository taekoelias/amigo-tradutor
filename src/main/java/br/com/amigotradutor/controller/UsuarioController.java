package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelId;
import br.com.amigotradutor.service.UsuarioPapelService;
import br.com.amigotradutor.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return service.getAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable long id) throws ValidacaoNegocioException{
		return service.getUsuario(id);
	}
	
	@PostMapping("/usuarios")
	public Usuario novoUsuario(@RequestBody Usuario u) throws ValidacaoNegocioException{
		service.add(u);
		return u;
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario updateUsuario(@PathVariable long id, @RequestBody Usuario u) throws ValidacaoNegocioException {
		service.update(id, u);
		return u;
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void deleteUsuario(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
