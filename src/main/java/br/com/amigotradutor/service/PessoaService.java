package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Pessoa;
import br.com.amigotradutor.repository.interfaces.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> getAllPessoa(){
		
		List<Pessoa> pessoas = new ArrayList<>();
		repository.findAll().forEach(pessoas::add);
		
		return pessoas;
	}
	
	public void addPessoa(Pessoa p){
		repository.save(p);
	}
	
}
