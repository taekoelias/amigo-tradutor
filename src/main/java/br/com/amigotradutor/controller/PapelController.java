package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.service.PapelService;

@RestController
public class PapelController {

	@Autowired
	private PapelService service;
	
	@RequestMapping("/papeis")
	public List<Papel> getAllPapel(){
		return service.getAll();
	}
	
	@RequestMapping("/papeis/{id}")
	public Papel getAllPapel(@PathVariable long id){
		return service.get(id);
	}
	
	@PostMapping("/papeis")
	public Papel addPapel(@RequestBody Papel papel) throws ValidacaoNegocioException{
		service.add(papel);
		return papel;
	}
	
	@PutMapping("/papeis/{id}")
	public Papel updatePapel(@PathVariable long id, @RequestBody Papel papel) throws ValidacaoNegocioException{
		service.update(id,papel);
		return papel;
	}
	
	@DeleteMapping(value="/papeis/{id}")
	public void deletePapel(@PathVariable long id) throws ValidacaoNegocioException{
		service.delete(id);
	}
}
