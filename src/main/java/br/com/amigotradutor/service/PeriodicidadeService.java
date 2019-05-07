package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.service.CrudService;
import br.com.amigotradutor.model.PeriodicidadePublicacao;
import br.com.amigotradutor.repository.interfaces.PeriodicidadeRepository;
import br.com.amigotradutor.repository.specification.BaseObjetoTipoSpecification;
import br.com.amigotradutor.validator.PeriodicidadeValidator;

@Service
public class PeriodicidadeService implements CrudService<PeriodicidadePublicacao, Long> {

	@Autowired
	private PeriodicidadeRepository repository;
	
	public List<PeriodicidadePublicacao> getAll() {
		return (List<PeriodicidadePublicacao>) repository.findAll();
	}
	
	public List<PeriodicidadePublicacao> getByParams(String nome) {
		return repository.findAll(BaseObjetoTipoSpecification.filterByNome(PeriodicidadePublicacao.class,nome));
	}
	
	public PeriodicidadePublicacao getOne(Long v) throws ValidacaoNegocioException {
		PeriodicidadeValidator validator = new PeriodicidadeValidator(repository);
		validator.notExists(v);
		
		return repository.findById(v).get();
	}

	public void add(PeriodicidadePublicacao t) throws ValidacaoNegocioException {
		PeriodicidadeValidator validator = new PeriodicidadeValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(Long v, PeriodicidadePublicacao t) throws ValidacaoNegocioException {
		PeriodicidadeValidator validator = new PeriodicidadeValidator(repository);
		validator.notExists(v);
		validator.requiredField(t);
		validator.duplicated(t);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(Long t) throws ValidacaoNegocioException {
		PeriodicidadeValidator validator = new PeriodicidadeValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

}
