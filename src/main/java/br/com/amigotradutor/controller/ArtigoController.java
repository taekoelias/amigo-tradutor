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
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.service.ArtigoService;
import br.com.amigotradutor.util.ValidatorUtil;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ArtigoController {

	@Autowired
	private ArtigoService service;
	
	@GetMapping("/artigos")
	public List<Artigo> getAll(@RequestParam(name="titulo",required=false) String titulo){
		if (ValidatorUtil.isNotEmpty(titulo))
			return service.getAll(titulo);
		
		return service.getAll();
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
