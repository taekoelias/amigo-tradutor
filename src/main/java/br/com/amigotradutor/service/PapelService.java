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
	
	public Papel get(long id) {
		return repositorio.findOne(id);
	}

	public void add(Papel p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);
		
		validator.duplicated(p);
		
		long id = repositorio.nextId();
		p.setId(id);
		
		p = repositorio.save(p);
		
	}

	public void update(Papel p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);

		validator.notExists(p.getId());
		validator.duplicated(p);
		
		repositorio.save(p);
	}

	public void delete(Long p) throws ValidacaoNegocioException {
		
		PapelValidator validator = new PapelValidator(repositorio);
		
		validator.notExists(p);
		
		repositorio.delete(p);
	}

}
