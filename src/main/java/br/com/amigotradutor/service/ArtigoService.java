package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.repository.interfaces.ArtigoRepository;
import br.com.amigotradutor.validator.ArtigoValidator;

@Service
public class ArtigoService implements CrudService<Artigo, Long> {

	@Autowired
	private ArtigoRepository repository;
	
	public List<Artigo> getAll() {
		return (List<Artigo>) repository.findAll();
	}
	
	public Artigo getOne(Long v) throws ValidacaoNegocioException {
		ArtigoValidator validator = new ArtigoValidator(repository);
		validator.notExists(v);
		
		return repository.findById(v).get();
	}

	public void add(Artigo t) throws ValidacaoNegocioException {
		ArtigoValidator validator = new ArtigoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(Long v, Artigo t) throws ValidacaoNegocioException {
		ArtigoValidator validator = new ArtigoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		validator.notExists(v);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(Long t) throws ValidacaoNegocioException {
		ArtigoValidator validator = new ArtigoValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

    public List<Artigo> getAll(String titulo) {
        return repository.findByTituloIgnoreCaseContaining(titulo);
    }

}
