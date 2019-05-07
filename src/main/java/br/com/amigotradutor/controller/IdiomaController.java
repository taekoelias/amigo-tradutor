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

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.service.IdiomaService;

@RestController
public class IdiomaController {

	@Autowired
	private IdiomaService service;
	
	@GetMapping("/idiomas")
	public List<Idioma> getIdiomas(@RequestParam(required=false) String nome,@RequestParam(required=false) String sigla){
		return service.getByParams(nome, sigla);
	}

	@GetMapping("/idiomas/{id}")
	public Idioma getIdioma(@PathVariable long id) {
		return service.getOne(id);
	}
	
	@PostMapping("/idiomas")
	public Idioma addIdioma(@RequestBody Idioma idioma) throws ValidacaoNegocioException {
		service.add(idioma);
		return idioma;
	}
	
	@PutMapping("/idiomas/{id}")
	public Idioma updateIdioma(@PathVariable long id, @RequestBody Idioma idioma) throws ValidacaoNegocioException {
		service.update(id, idioma);
		return idioma;
	}
	
	@DeleteMapping("/idiomas/{id}")
	public void deleteIdioma(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
}
