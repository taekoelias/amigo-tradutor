package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.service.RevistaService;

@RestController
public class RevistaController {

	@Autowired
	private RevistaService service;
	
	@RequestMapping("/revistas")
	public List<Revista> getAllRevistas(){
		return service.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/revistas")
	public void addRevista(@RequestBody Revista revista){
		service.add(revista);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/revistas/{id}")
	public void updateRevista(@PathVariable long id, @RequestBody Revista revista){
		service.update(id, revista);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/revistas/{id}")
	public void removeRevista(@PathVariable long id){
		service.delete(id);
	}
}
