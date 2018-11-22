package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
