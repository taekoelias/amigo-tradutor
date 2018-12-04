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
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelId;
import br.com.amigotradutor.service.UsuarioPapelService;
import br.com.amigotradutor.service.UsuarioService;

@RestController
public class UsuarioPapelController {

	@Autowired
	private UsuarioPapelService usuarioPapelService;
	
	@GetMapping("/usuarios/{id}/papeis")
	public List<UsuarioPapel> getPapeisUsuario(@PathVariable long id) throws ValidacaoNegocioException{
		return usuarioPapelService.getAllPapelByUsuario(id);
	}
	
	@PostMapping("/usuarios/{id}/papeis")
	public UsuarioPapel addUsuarioPapel(@PathVariable long id, @RequestBody Papel p) throws ValidacaoNegocioException{
		
		UsuarioPapel up = new UsuarioPapel(id, p.getId());
		usuarioPapelService.add(up);
		
		return up;
	}
	
	@PutMapping("/usuarios/{id}/papeis/{idPapel}/ativa")
	public UsuarioPapel ativaPapeisUsuario(@PathVariable long id, @PathVariable long idPapel) throws ValidacaoNegocioException{
		
		UsuarioPapel up = new UsuarioPapel(id, idPapel);
		up.setAtivo(true);
		
		usuarioPapelService.update(new UsuarioPapelId(id, idPapel),up);
		
		return up;
	}
	
	@PutMapping("/usuarios/{id}/papeis/{idPapel}/desativa")
	public UsuarioPapel desativaPapeisUsuario(@PathVariable long id, @PathVariable long idPapel) throws ValidacaoNegocioException{
		
		UsuarioPapel up = new UsuarioPapel(id, idPapel);
		up.setAtivo(false);
		
		usuarioPapelService.update(new UsuarioPapelId(id, idPapel),up);
		
		return up;
	}
	
	@DeleteMapping("/usuarios/{id}/papeis/{idPapel}")
	public void deleteUsuarioPapel(@PathVariable long id, @PathVariable long idPapel) throws ValidacaoNegocioException{
		usuarioPapelService.delete(new UsuarioPapelId(id, idPapel));
	}
}
