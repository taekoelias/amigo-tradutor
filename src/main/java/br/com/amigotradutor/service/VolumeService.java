package br.com.amigotradutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.model.VolumeId;
import br.com.amigotradutor.repository.interfaces.VolumeRepository;
import br.com.amigotradutor.repository.specification.VolumeSpecification;
import br.com.amigotradutor.validator.VolumeValidator;

@Service
public class VolumeService {

	@Autowired
	private VolumeRepository repository;
	
	public List<Volume> getAll(long idArtigo) {
		return (List<Volume>) repository.findByArtigoId(idArtigo);
	}

	public Volume getOne(long idVolume) throws ValidacaoNegocioException {
		return repository.findById(idVolume).get();
	}

	public void add(Volume t) throws ValidacaoNegocioException {
		VolumeValidator validator = new VolumeValidator(repository);
		validator.requiredField(t);
		validator.duplicated(t);
		
		repository.save(t);
	}

	public void update(long v, Volume t) throws ValidacaoNegocioException {
		VolumeValidator validator = new VolumeValidator(repository);
		validator.notExists(v);
		validator.requiredField(t);
		validator.duplicated(t);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(long t) throws ValidacaoNegocioException {
		VolumeValidator validator = new VolumeValidator(repository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

	public List<Volume> getByParams(String numero, String titulo, Long artigo) {
		return repository.findAll(VolumeSpecification.filterByArtidoVolumeNumeroTituloPublicacao(numero, titulo, artigo));
	}

}
