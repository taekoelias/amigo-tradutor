package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.service.RevistaService;

@RestController
public class RevistaController {

	@Autowired
	private RevistaService service;
	
	@RequestMapping("/revistas")
	public List<Revista> getAllRevistas(@RequestParam(required=false) String nome,
			@RequestParam(required=false) Long editora, @RequestParam(required=false) Long periodicidade,
			@RequestParam(required=false) List<Long> publicos){
		return service.getByParams(nome, editora,periodicidade, publicos);
	}
	
	@RequestMapping("/revistas/{id}")
	public Revista getRevista(@PathVariable long id) throws ValidacaoNegocioException{
		return service.getOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/revistas")
	public Revista addRevista(@RequestBody Revista revista) throws ValidacaoNegocioException{
		service.add(revista);
		return revista;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/revistas/{id}")
	public Revista updateRevista(@PathVariable long id, @RequestBody Revista revista) throws ValidacaoNegocioException{
		service.update(id, revista);
		return revista;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/revistas/{id}")
	public void removeRevista(@PathVariable long id) throws ValidacaoNegocioException{
		service.delete(id);
	}
}
