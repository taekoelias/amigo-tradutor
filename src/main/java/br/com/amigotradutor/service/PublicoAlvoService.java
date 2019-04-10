package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.GeneroArtigo;
import br.com.amigotradutor.model.PublicoAlvo;
import br.com.amigotradutor.repository.interfaces.PublicoAlvoRepository;
import br.com.amigotradutor.repository.specification.BaseObjetoTipoSpecification;
import br.com.amigotradutor.validator.PublicoAlvoValidator;

@Service
public class PublicoAlvoService implements CrudService<PublicoAlvo, Long> {

	@Autowired
	private PublicoAlvoRepository repository;
	
	public List<PublicoAlvo> getAll() {
		return (List<PublicoAlvo>) repository.findAll();
	}
	
	public List<PublicoAlvo> getByParams(String nome) {
		return repository.findAll(BaseObjetoTipoSpecification.filterByNome(PublicoAlvo.class,nome));
	}
	
	public PublicoAlvo getOne(Long v) throws ValidacaoNegocioException {
		PublicoAlvoValidator validator = new PublicoAlvoValidator(repository);
		validator.notExists(v);
		
		return repository.findById(v).get();
	}

	public void add(PublicoAlvo t) throws ValidacaoNegocioException {
		PublicoAlvoValidator validator = new PublicoAlvoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(Long v, PublicoAlvo t) throws ValidacaoNegocioException {
		PublicoAlvoValidator validator = new PublicoAlvoValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		validator.notExists(v);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(Long t) throws ValidacaoNegocioException {
		PublicoAlvoValidator validator = new PublicoAlvoValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

}
