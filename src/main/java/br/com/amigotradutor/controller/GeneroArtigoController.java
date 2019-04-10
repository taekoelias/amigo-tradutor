package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.GeneroArtigo;
import br.com.amigotradutor.service.GeneroArtigoService;

@RestController
public class GeneroArtigoController {

	@Autowired
	private GeneroArtigoService service;
	
	@GetMapping("/generosArtigo")
	public List<GeneroArtigo> getGenerosArtigo(@RequestParam(required=false) String nome){
		return service.getByParams(nome);
	}
	
	@GetMapping("/generosArtigo/{id}")
	public GeneroArtigo getOne(@PathVariable long id) throws ValidacaoNegocioException {
		return service.getOne(id);
	}
	
	@PostMapping("/generosArtigo")
	public GeneroArtigo addGeneroArtigo(@RequestBody GeneroArtigo generoArtigo) throws ValidacaoNegocioException {
		service.add(generoArtigo);
		return generoArtigo;
	}
	
	@PutMapping("/generosArtigo/{id}")
	public GeneroArtigo updateGeneroArtigo(@PathVariable long id, @RequestBody GeneroArtigo generoArtigo) throws ValidacaoNegocioException {
		service.update(id,generoArtigo);
		return generoArtigo;
	}
	
	@DeleteMapping("/generosArtigo/{id}")
	public void deleteGeneroArtigo(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
