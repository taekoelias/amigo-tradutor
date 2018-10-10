package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return service.getAll();
	}
	
	@RequestMapping("/usuarios/{id}")
	public Usuario getUsuarios(@PathVariable long id){
		return service.getUsuario(id);
	}
	
	@RequestMapping(value="/usuarios",method=RequestMethod.POST)
	public void novoUsuario(@RequestBody Usuario u){
		service.addUsuario(u);
	}
	
	@RequestMapping("/usuarios/admin")
	public List<Usuario> getUsuariosAdmin(){
		return service.getAllAdmin();
	}
	
	@RequestMapping(value="/usuarios/admin",method=RequestMethod.POST)
	public void novoAdmin(@RequestBody Usuario u){
		service.addAdmin(u);
	}
	
}
