package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Editora;
import br.com.amigotradutor.repository.interfaces.EditoraRepository;
import br.com.amigotradutor.repository.specification.EditoraSpecification;
import br.com.amigotradutor.validator.EditoraValidator;

@Service
public class EditoraService implements CrudService<Editora, Long> {

	@Autowired
	private EditoraRepository repository;
	
	@Override
	public List<Editora> getAll() {
		return (List<Editora>) repository.findAll();
	}
	
	public List<Editora> getByParams(String nome) {
		return (List<Editora>) repository.findAll(EditoraSpecification.filterByNome(nome));
	}
	
	public Editora getOne(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void add(Editora t) throws ValidacaoNegocioException {
		EditoraValidator validador = new EditoraValidator(repository);
		validador.requiredField(t);
		validador.duplicated(t);
		
		repository.save(t);
	}

	@Override
	public void update(Long v, Editora t) throws ValidacaoNegocioException {
		EditoraValidator validador = new EditoraValidator(repository);
		validador.requiredField(t);
		validador.duplicated(t);
		validador.notExists(v);
		
		repository.save(t);
	}

	@Override
	public void delete(Long t) throws ValidacaoNegocioException {
		EditoraValidator validador = new EditoraValidator(repository);
		validador.notExists(t);
		
		repository.deleteById(t);
	}

}
