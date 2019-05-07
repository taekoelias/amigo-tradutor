package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.service.CrudService;
import br.com.amigotradutor.model.GeneroArtigo;
import br.com.amigotradutor.repository.interfaces.GeneroArtigoRepository;
import br.com.amigotradutor.repository.specification.BaseObjetoTipoSpecification;
import br.com.amigotradutor.validator.GeneroArtigoValidator;

@Service
public class GeneroArtigoService implements CrudService<GeneroArtigo, Long> {

	@Autowired
	private GeneroArtigoRepository repository;
	
	public List<GeneroArtigo> getAll() {
		return (List<GeneroArtigo>) repository.findAll();
	}
	
	public List<GeneroArtigo> getByParams(String nome) {
		return repository.findAll(BaseObjetoTipoSpecification.filterByNome(GeneroArtigo.class,nome));
	}
	
	public GeneroArtigo getOne(Long v) throws ValidacaoNegocioException {
		GeneroArtigoValidator validator = new GeneroArtigoValidator(repository);
		validator.notExists(v);
		
		return repository.findById(v).get();
	}

	public void add(GeneroArtigo t) throws ValidacaoNegocioException {
		GeneroArtigoValidator validator = new GeneroArtigoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(Long v, GeneroArtigo t) throws ValidacaoNegocioException {
		GeneroArtigoValidator validator = new GeneroArtigoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		validator.notExists(v);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(Long t) throws ValidacaoNegocioException {
		GeneroArtigoValidator validator = new GeneroArtigoValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

}
