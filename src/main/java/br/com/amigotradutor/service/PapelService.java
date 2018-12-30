package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.repository.interfaces.PapelRepository;
import br.com.amigotradutor.validator.PapelValidator;

@Service
public class PapelService implements CrudService<Papel, Long> {

	@Autowired
	private PapelRepository repositorio;
	
	public List<Papel> getAll() {
		List<Papel> papeis = new ArrayList<Papel>();
		repositorio.findAll().forEach(papeis::add);
		return papeis;
	}
	
	public Papel getOne(Long id) {
		return repositorio.findById(id).get();
	}

	public void add(Papel p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);
		
		validator.duplicated(p);
		
		long id = repositorio.nextId();
		p.setId(id);
		
		p = repositorio.save(p);
		
	}

	public void update(Long id, Papel p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);

		validator.notExists(id);
		validator.duplicated(p);
		
		p.setId(id);
		
		repositorio.save(p);
	}

	public void delete(Long p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);
		
		validator.notExists(p);
		
		repositorio.deleteById(p);
	}

}
