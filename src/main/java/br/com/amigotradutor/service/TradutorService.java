package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.model.Tradutor;
import br.com.amigotradutor.model.UsuarioPapelPK;
import br.com.amigotradutor.repository.interfaces.TradutorRepository;
import br.com.amigotradutor.repository.interfaces.UsuarioPapelRepository;

@Service
public class TradutorService {

	@Autowired
	private TradutorRepository repository;

	@Autowired
	private UsuarioService usuarioService;
	
	public List<Tradutor> getAllTradutores(){
		List<Tradutor> resultado = new ArrayList<>(); 
		repository.findAll().forEach(resultado::add);
		
		return resultado;
	}

	public List<Tradutor> getAllTradutoresAtivos(){
		return repository.findByAtivo(true);
	}
	
	public List<Tradutor> getAllTradutoresAtivosUsuario(long usuarioId){
		return repository.findByAtivoAndUsuarioId(true, usuarioId);
	}
	
	public List<Tradutor> getAllTradutoresIdiomaOrigemIdiomaDestino(long idiomaOrigem, long idiomaDestino){
		return repository.findByAtivoAndDestinoIdAndOrigemId(true, idiomaDestino, idiomaOrigem);
	}
	
	public List<Tradutor> getAllTradutoresIdiomaOrigem(long idiomaOrigem){
		return repository.findByAtivoAndOrigemId(true, idiomaOrigem);
	}
	
	public List<Tradutor> getAllTradutoresIdiomaDestino(long idiomaDestino){
		return repository.findByAtivoAndDestinoId(true, idiomaDestino);
	}
	
	public void add(Tradutor t){
		
		Tradutor tradutor = repository.findByUsuarioIdAndDestinoIdAndOrigemId(t.getUsuario().getId(), t.getDestino().getId(), t.getOrigem().getId());
		
		if (tradutor == null){
			usuarioService.addPapelTradutor(t.getUsuario());
			t.setAtivo(true);
			repository.save(t);
		} else if (!tradutor.isAtivo()){
			tradutor.setAtivo(true);
			repository.save(tradutor);
		}
	}
	
	public void update(Tradutor t){
		repository.save(t);
	}
	
	public void delete(long tradutorId){
		repository.delete(tradutorId);
	}
}
