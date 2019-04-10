package br.com.amigotradutor.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/capitulos")
	public List<Capitulo> getAllCapitulos(@RequestParam(required=false) Long artigo,@RequestParam(required=false) Long volume,
			@RequestParam(required=false) String numero, @RequestParam(required=false) String titulo, 
			@RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date publicacao){
		return service.getByParams(artigo, volume, numero, titulo, publicacao);
	}
        
	@GetMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos")
	public List<Capitulo> getCapitulosByArtigoVolume(@PathVariable long idArtigo, @PathVariable long idVolume){
		return service.getAllByArtigoVolume(idArtigo, idVolume);
	}
	
	@GetMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public Capitulo getCapitulo(@PathVariable long idCapitulo) throws ValidacaoNegocioException{
		return service.getOne(idCapitulo);
	}
	
	@PostMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos")
	public Capitulo addCapitulo(@PathVariable long idArtigo, @PathVariable long idVolume, @RequestBody Capitulo capitulo) throws ValidacaoNegocioException{
		capitulo.setArtigo(new Artigo(idArtigo));
		capitulo.setVolume(new Volume(idVolume));
		service.add(capitulo);
		return capitulo;
	}
	
	@PutMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public Capitulo updateCapitulo(@PathVariable long idArtigo, @PathVariable long idCapitulo, @PathVariable long idVolume, @RequestBody Capitulo capitulo) throws ValidacaoNegocioException{
		capitulo.setArtigo(new Artigo(idArtigo));
		capitulo.setVolume(new Volume(idVolume));
		service.update(idCapitulo, capitulo);
		return capitulo;
	}
	
	@DeleteMapping("/artigos/{idArtigo}/volumes/{idVolume}/capitulos/{idCapitulo}")
	public void deleteCapitulo(@PathVariable long idCapitulo) throws ValidacaoNegocioException{
		
		service.delete(idCapitulo);
	}
}
