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
import br.com.amigotradutor.model.Editora;
import br.com.amigotradutor.service.EditoraService;

@RestController
public class EditoraController {

	@Autowired
	private EditoraService service;
	
	@GetMapping("/editoras")
	public List<Editora> getEditoras(@RequestParam(required=false) String nome){
		return service.getByParams(nome);
	}
	
	@GetMapping("/editoras/{id}")
	public Editora getOne(@PathVariable long id) {
		return service.getOne(id);
	}
	
	@PostMapping("/editoras")
	public Editora addEditora(@RequestBody Editora editora) throws ValidacaoNegocioException {
		service.add(editora);
		return editora;
	}
	
	@PutMapping("/editoras/{id}")
	public Editora updateEditora(@PathVariable long id, @RequestBody Editora editora) throws ValidacaoNegocioException {
		service.update(id,editora);
		return editora;
	}
	
	@DeleteMapping("/editoras/{id}")
	public void deleteEditora(@PathVariable long id) throws ValidacaoNegocioException {
		service.delete(id);
	}
}
