package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.repository.interfaces.CapituloRepository;
import br.com.amigotradutor.validator.CapituloValidator;

@Service
public class CapituloService {

	@Autowired
	private CapituloRepository repository;
	
	public List<Capitulo> getAll(long idArtigo) {
		return (List<Capitulo>) repository.findByVolumeId(idArtigo);
	}

	public Capitulo getOne(long idCapitulo) throws ValidacaoNegocioException {
		return repository.findById(idCapitulo).get();
	}

	public void add(Capitulo t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(long v, Capitulo t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository);
		validator.notExists(v);
		validator.requiredField(t);
		validator.duplicated(t);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(long t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

}
