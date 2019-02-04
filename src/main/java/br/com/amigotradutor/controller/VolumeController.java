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
import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.service.VolumeService;

@RestController
public class VolumeController {

	@Autowired
	private VolumeService service;
	
	@GetMapping("/artigos/{idArtigo}/volumes")
	public List<Volume> getVolumes(@PathVariable long idArtigo){
		return service.getAll(idArtigo);
	}
	
	@GetMapping("/artigos/{idArtigo}/volumes/{idVolume}")
	public Volume getVolume(@PathVariable long idVolume) throws ValidacaoNegocioException{
		return service.getOne(idVolume);
	}
	
	@PostMapping("/artigos/{idArtigo}/volumes")
	public Volume addVolume(@PathVariable long idArtigo, @RequestBody Volume volume) throws ValidacaoNegocioException{
		
		volume.setArtigo(new Artigo(idArtigo));
		service.add(volume);
		return volume;
	}
	
	@PutMapping("/artigos/{idArtigo}/volumes/{idVolume}")
	public Volume updateVolume(@PathVariable long idArtigo, @PathVariable long idVolume, @RequestBody Volume volume) throws ValidacaoNegocioException{
		
		volume.setArtigo(new Artigo(idArtigo));
		service.update(idVolume, volume);
		return volume;
	}
	
	@DeleteMapping("/artigos/{idArtigo}/volumes/{idVolume}")
	public void deleteVolume(@PathVariable long idVolume) throws ValidacaoNegocioException{
		
		service.delete(idVolume);
	}
}
