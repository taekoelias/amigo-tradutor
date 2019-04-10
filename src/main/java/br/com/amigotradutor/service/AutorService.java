package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.repository.interfaces.AutorRepository;
import br.com.amigotradutor.repository.specification.AutorSpecification;
import br.com.amigotradutor.validator.AutorValidator;

@Service
public class AutorService implements CrudService<Autor,Long>{

	@Autowired
	private AutorRepository dao;

	@Override
	public List<Autor> getAll() {
		List<Autor> autores = new ArrayList<Autor>();
		dao.findAll().forEach(autores::add);
		return autores;
	}
	
	public List<Autor> getByParams(String nome) {
		return dao.findAll(AutorSpecification.filterByNome(nome));
	}
	
	@Override
	public Autor getOne(Long v) throws ValidacaoNegocioException {
		AutorValidator validador = new AutorValidator(dao);
		validador.notExists(v);
		
		return dao.findById(v).get();
	}

	public void add(Autor a) throws ValidacaoNegocioException{
		AutorValidator validador = new AutorValidator(dao);
		validador.requiredField(a);
		validador.duplicated(a);
		
		dao.save(a);
	}
	
	public void update(Long id,Autor a) throws ValidacaoNegocioException{
		AutorValidator validador = new AutorValidator(dao);
		validador.notExists(id);
		validador.requiredField(a);
		validador.duplicated(a);
		
		a.setId(id);
		dao.save(a);
	}
	
	public void delete(Long autorId) throws ValidacaoNegocioException{
		AutorValidator validador = new AutorValidator(dao);
		validador.notExists(autorId);
		
		dao.deleteById(autorId);
	}
	
}
