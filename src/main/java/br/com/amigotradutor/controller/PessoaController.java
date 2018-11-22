package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Pessoa;
import br.com.amigotradutor.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@RequestMapping("/pessoas")
	public List<Pessoa> getAllPessoas(){
		return service.getAllPessoa();
	}
	
	@RequestMapping(value="/pessoas",method=RequestMethod.POST)
	public void addPessoa(@RequestBody Pessoa p){
		service.addPessoa(p);
	}
	
}
