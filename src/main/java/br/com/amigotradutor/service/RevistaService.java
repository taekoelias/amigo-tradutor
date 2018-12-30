package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.repository.interfaces.RevistaRepository;
import br.com.amigotradutor.validator.RevistaValidator;

@Service
public class RevistaService implements CrudService<Revista,Long>{

	@Autowired
	private RevistaRepository dao;

	@Override
	public List<Revista> getAll() {
		List<Revista> revistas = new ArrayList<Revista>();
		dao.findAll().forEach(revistas::add);
		return revistas;
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
