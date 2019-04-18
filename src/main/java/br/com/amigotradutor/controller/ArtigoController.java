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
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.service.ArtigoService;

@RestController
public class ArtigoController {

	@Autowired
	private ArtigoService service;
	
	@GetMapping("/artigos")
	public List<Artigo> getAllByParams(@RequestParam(required=false) String titulo,
			@RequestParam(required=false) Long autor, @RequestParam(required=false) Long revista,
			@RequestParam(required=false) List<Long> generos){
		return service.getByParams(titulo, autor, revista, generos);
	}
	
	@GetMapping("/artigos/{id}")
	public Artigo getOne(@PathVariable long id) throws ValidacaoNegocioException {
		return service.getOne(id);
	}
	
	@PostMapping("/artigos")
	public Artigo addArtigo(@RequestBody Artigo artigo) throws ValidacaoNegocioException {
		service.add(artigo);
		return artigo;
	}
	
	@PutMapping("/artigos/{id}")
	public Artigo updateArtigo(@PathVariable long id, @RequestBody Artigo artigo) throws ValidacaoNegocioException {
		service.update(id,artigo);
		return artigo;
	}
	
	@DeleteMapping("/artigos/{id}")
	public void deleteArtigo(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
