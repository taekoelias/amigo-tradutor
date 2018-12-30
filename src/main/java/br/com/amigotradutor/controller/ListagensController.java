package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.service.ListagensService;

@RestController
public class ListagensController {

	@Autowired
	private ListagensService service;
	
	@RequestMapping("/listagens/idiomas")
	public List<Idioma> getAllIdiomas(){
		return service.getAllIdiomas();
	}
}
