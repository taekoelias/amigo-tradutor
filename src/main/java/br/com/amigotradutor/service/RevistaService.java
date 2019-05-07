package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.service.CrudService;
import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.repository.interfaces.RevistaRepository;
import br.com.amigotradutor.repository.specification.RevistaSpecification;
import br.com.amigotradutor.validator.RevistaValidator;

@Service
public class RevistaService implements CrudService<Revista,Long>{

	@Autowired
	private RevistaRepository dao;

	public List<Revista> getByParams(String nome, Long editora, Long periodicidade,
			List<Long> publicos) {
		return dao.findAll(RevistaSpecification.filterByNomeEditoraPeriodicidadePublicos(nome, editora, periodicidade, publicos));
	}
	
	@Override
	public List<Revista> getAll() {
		return (List<Revista>) dao.findAll();
	}
	
	@Override
	public Revista getOne(Long v) throws ValidacaoNegocioException {
		RevistaValidator validator = new RevistaValidator(dao);
		validator.notExists(v);
		
		return dao.findById(v).get();
	}

	public void add(Revista a) throws ValidacaoNegocioException{
		RevistaValidator validator = new RevistaValidator(dao);
		validator.requiredField(a);
		validator.duplicated(a);
		
		dao.save(a);
	}
	
	public void update(Long id, Revista a) throws ValidacaoNegocioException{
		RevistaValidator validator = new RevistaValidator(dao);
		validator.notExists(id);
		validator.requiredField(a);
		validator.duplicated(a);
		
		a.setId(id);
		dao.save(a);
	}
	
	public void delete(Long revistaId) throws ValidacaoNegocioException{
		RevistaValidator validator = new RevistaValidator(dao);
		validator.notExists(revistaId);
		
		dao.deleteById(revistaId);
	}
	
}
