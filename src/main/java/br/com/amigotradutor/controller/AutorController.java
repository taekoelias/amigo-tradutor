package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
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
	
	@RequestMapping("/autores/{id}")
	public Autor getAutor(@PathVariable long id) throws ValidacaoNegocioException{
		return service.getOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/autores")
	public void addAutor(@RequestBody Autor autor) throws ValidacaoNegocioException{
		service.add(autor);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/autores/{id}")
	public void updateAutor(@PathVariable long id, @RequestBody Autor autor) throws ValidacaoNegocioException{
		service.update(id, autor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/autores/{id}")
	public void removeAutor(@PathVariable long id) throws ValidacaoNegocioException{
		service.delete(id);
	}
}
