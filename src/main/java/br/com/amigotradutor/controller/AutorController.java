package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.service.AutorService;

@RestController
public class AutorController {

	@Autowired
	private AutorService service;
	
	@RequestMapping("/autores")
	public List<Autor> getAllAutores(){
		return service.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/autores")
	public void addAutor(@RequestBody Autor autor){
		service.add(autor);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/autores/{id}")
	public void addTradutor(@PathVariable long id, @RequestBody Autor autor){
		service.update(autor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/autores/{id}")
	public void addTradutor(@PathVariable long id){
		service.delete(id);
	}
}
