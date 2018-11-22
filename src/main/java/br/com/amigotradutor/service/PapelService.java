package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.repository.interfaces.PapelRepository;

@Service
public class PapelService implements CrudService<Papel, Long> {

	@Autowired
	private PapelRepository repositorio;
	
	public List<Papel> getAll() {
		List<Papel> papeis = new ArrayList<Papel>();
		repositorio.findAll().forEach(papeis::add);
		return papeis;
	}
	
	public Papel get(long id) {
		return repositorio.findOne(id);
	}

	public void add(Papel t) {
		
	}

	public void update(Papel t) {
		
	}

	public void delete(Long t) {
		
	}

}
