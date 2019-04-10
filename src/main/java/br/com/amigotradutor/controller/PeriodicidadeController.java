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
import br.com.amigotradutor.model.PeriodicidadePublicacao;
import br.com.amigotradutor.service.PeriodicidadeService;

@RestController
public class PeriodicidadeController {

	@Autowired
	private PeriodicidadeService service;
	
	@GetMapping("/periodicidadesPublicacao")
	public List<PeriodicidadePublicacao> getGenerosArtigo(@RequestParam(required=false) String nome){
		return service.getByParams(nome);
	}
	
	@GetMapping("/periodicidadesPublicacao/{id}")
	public PeriodicidadePublicacao getOne(@PathVariable long id) throws ValidacaoNegocioException {
		return service.getOne(id);
	}
	
	@PostMapping("/periodicidadesPublicacao")
	public PeriodicidadePublicacao addPeriodicidadePublicacao(@RequestBody PeriodicidadePublicacao Periodicidade) throws ValidacaoNegocioException {
		service.add(Periodicidade);
		return Periodicidade;
	}
	
	@PutMapping("/periodicidadesPublicacao/{id}")
	public PeriodicidadePublicacao updatePeriodicidadePublicacao(@PathVariable long id, @RequestBody PeriodicidadePublicacao Periodicidade) throws ValidacaoNegocioException {
		service.update(id,Periodicidade);
		return Periodicidade;
	}
	
	@DeleteMapping("/periodicidadesPublicacao/{id}")
	public void deletePeriodicidadePublicacao(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
	
}
