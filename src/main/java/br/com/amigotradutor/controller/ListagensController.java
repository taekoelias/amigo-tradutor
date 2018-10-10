package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.service.ListagensService;
import br.com.amigotradutor.types.EGeneroManga;
import br.com.amigotradutor.types.EPeriodicidade;

@RestController
public class ListagensController {

	@Autowired
	private ListagensService service;
	
	@RequestMapping("/listagens/idiomas")
	public List<Idioma> getAllIdiomas(){
		return service.getAllIdiomas();
	}
	
	@RequestMapping("/listagens/generosManga")
	public List<EGeneroManga> getAllGenerosManga(){
		return service.getAllGenerosManga();
	}
	
	@RequestMapping("/listagens/periodicidades")
	public List<EPeriodicidade> getAllPeriodicidades(){
		return service.getAllPeriodicidades();
	}
}
