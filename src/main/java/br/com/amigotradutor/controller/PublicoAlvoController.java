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
import br.com.amigotradutor.model.PublicoAlvo;
import br.com.amigotradutor.service.PublicoAlvoService;

@RestController
public class PublicoAlvoController {

	@Autowired
	private PublicoAlvoService service;
	
	@GetMapping("/publicosAlvo")
	public List<PublicoAlvo> getGenerosArtigo(){
		return service.getAll();
	}
	
	@GetMapping("/publicosAlvo/{id}")
	public PublicoAlvo getOne(@PathVariable long id) throws ValidacaoNegocioException {
		return service.getOne(id);
	}
	
	@PostMapping("/publicosAlvo")
	public PublicoAlvo addPublicoAlvo(@RequestBody PublicoAlvo publicoAlvo) throws ValidacaoNegocioException {
		service.add(publicoAlvo);
		return publicoAlvo;
	}
	
	@PutMapping("/publicosAlvo/{id}")
	public PublicoAlvo updatePublicoAlvo(@PathVariable long id, @RequestBody PublicoAlvo publicoAlvo) throws ValidacaoNegocioException {
		service.update(id,publicoAlvo);
		return publicoAlvo;
	}
	
	@DeleteMapping("/publicosAlvo/{id}")
	public void deletePublicoAlvo(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
