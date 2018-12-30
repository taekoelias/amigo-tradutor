package br.com.amigotradutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.service.CapituloService;

@RestController
public class CapituloController {

	@Autowired
	private CapituloService service;
	
	@GetMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos")
	public List<Capitulo> getCapitulos(@PathVariable long idVolume){
		return service.getAll(idVolume);
	}
	
	@GetMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public Capitulo getCapitulo(@PathVariable long idCapitulo) throws ValidacaoNegocioException{
		return service.getOne(idCapitulo);
	}
	
	@PostMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos")
	public Capitulo addCapitulo(@PathVariable long idVolume, @RequestBody Capitulo capitulo) throws ValidacaoNegocioException{
		
		capitulo.setVolume(new Volume(idVolume));
		service.add(capitulo);
		return capitulo;
	}
	
	@PutMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public Capitulo updateCapitulo(@PathVariable long idCapitulo, @PathVariable long idVolume, @RequestBody Capitulo capitulo) throws ValidacaoNegocioException{
		
		capitulo.setVolume(new Volume(idVolume));
		service.update(idCapitulo, capitulo);
		return capitulo;
	}
	
	@DeleteMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public void deleteCapitulo(@PathVariable long idCapitulo) throws ValidacaoNegocioException{
		
		service.delete(idCapitulo);
	}
}
