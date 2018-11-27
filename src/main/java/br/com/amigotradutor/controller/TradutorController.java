package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.model.Tradutor;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.service.TradutorService;

@RestController
public class TradutorController {

	@Autowired
	private TradutorService service;
	
	@RequestMapping("/tradutores")
	public List<Tradutor> getAllTradutoresUsuario(){
		return service.getAllTradutores();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/usuarios/{usuarioId}/tradutores")
	public List<Tradutor> getAllTradutoresUsuario(@PathVariable long usuarioId){
		return service.getAllTradutoresAtivosUsuario(usuarioId);
	}

	@RequestMapping(method = RequestMethod.GET, value="/tradutores/idiomaOrigem/{idiomaId}")
	public List<Tradutor> getAllTradutoresPorIdiomaOrigem(@PathVariable long idiomaId){
		return service.getAllTradutoresIdiomaOrigem(idiomaId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/tradutores/idiomaDestino/{idiomaId}")
	public List<Tradutor> getAllTradutoresPorIdiomaDestino(@PathVariable long idiomaId){
		return service.getAllTradutoresIdiomaDestino(idiomaId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/tradutores/idiomaOrigem/{idiomaOrigemId}/idiomaDestino/{idiomaDestinoId}")
	public List<Tradutor> getAllTradutoresPorIdiomaOrigemIdiomaDestino(@PathVariable long idiomaOrigemId, @PathVariable long idiomaDestinoId){
		return service.getAllTradutoresIdiomaOrigemIdiomaDestino(idiomaOrigemId, idiomaDestinoId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/usuarios/{usuarioId}/tradutores")
	public void addTradutor(@PathVariable long usuarioId, @RequestBody Tradutor tradutor){
		if (tradutor.getOrigem().equals(tradutor.getDestino()))
			throw new IllegalArgumentException("Não é possível cadastrar um tradutor com o mesmo idioma de origem e destino.");
		
		tradutor.setUsuarioPapel(new UsuarioPapel(usuarioId, 0));
		service.add(tradutor);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/usuarios/{usuarioId}/tradutores/{id}")
	public void updateTradutor(@PathVariable long usuarioId, @PathVariable long id, @RequestBody Tradutor tradutor){
		if (tradutor.getOrigem().equals(tradutor.getDestino()))
			throw new IllegalArgumentException("Não é possível cadastrar um tradutor com o mesmo idioma de origem e destino.");
		
		tradutor.setId(id);
		tradutor.setUsuarioPapel(new UsuarioPapel(usuarioId, 0));
		service.update(tradutor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/tradutores/{id}")
	public void removeTradutor(@PathVariable long id){
		service.delete(id);
	}
}
