package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.service.CrudService;
import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.repository.interfaces.IdiomaRepository;
import br.com.amigotradutor.repository.specification.IdiomaSpecification;
import br.com.amigotradutor.validator.IdiomaValidator;

@Service
public class IdiomaService implements CrudService<Idioma, Long>{

	@Autowired
	private IdiomaRepository repository;
	
	public List<Idioma> getByParams(String nome, String sigla){
		return repository.findAll(IdiomaSpecification.filterByNomeAndSigla(nome, sigla));
	}
	
	@Override
	public List<Idioma> getAll() {
		List<Idioma> idiomas = new ArrayList<>();
		
		repository.findAll().forEach(idiomas::add);
		
		return idiomas;
	}
	
	public Idioma getOne(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void add(Idioma t) throws ValidacaoNegocioException {
		
		IdiomaValidator validator = new IdiomaValidator(repository);
		
		validator.requiredField(t);
		validator.duplicated(t);
		
		t.setId(repository.nextId()+1);
		t.setNome(t.getNome().toUpperCase());
		t.setSigla(t.getSigla().toUpperCase());
		t = repository.save(t);
	}

	@Override
	public void update(Long id, Idioma t) throws ValidacaoNegocioException {
		t.setId(id);

		IdiomaValidator validator = new IdiomaValidator(repository);
		
		validator.notExists(id);
		validator.requiredField(t);
		validator.duplicated(t);
		
		t.setNome(t.getNome().toUpperCase());
		t.setSigla(t.getSigla().toUpperCase());
		t = repository.save(t);
	}

	@Override
	public void delete(Long id) throws ValidacaoNegocioException {
		IdiomaValidator validator = new IdiomaValidator(repository);
		
		validator.notExists(id);
		
		repository.deleteById(id);
	}

}
