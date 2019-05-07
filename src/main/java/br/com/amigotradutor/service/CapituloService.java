package br.com.amigotradutor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.repository.interfaces.CapituloRepository;
import br.com.amigotradutor.repository.interfaces.VolumeRepository;
import br.com.amigotradutor.repository.specification.CapituloSpecification;
import br.com.amigotradutor.validator.CapituloValidator;

@Service
public class CapituloService {

	@Autowired
	private CapituloRepository repository;
        
        @Autowired
        private VolumeRepository volumeRepository;
	
	public List<Capitulo> getAll(long idArtigo) {
		return (List<Capitulo>) repository.findByVolumeId(idArtigo);
	}

	public Capitulo getOne(long idCapitulo) throws ValidacaoNegocioException {
		return repository.findById(idCapitulo).get();
	}

	public void add(Capitulo t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository,volumeRepository);
		validator.requiredField(t);
		validator.duplicated(t);
                validator.FromTheSameArtigo(t);
		
		repository.save(t);
	}

	public void update(long v, Capitulo t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository,volumeRepository);
		validator.notExists(v);
		validator.requiredField(t);
		validator.duplicated(t);
                validator.FromTheSameArtigo(t);
		
		t.setId(v);
		repository.save(t);
	}

	public void delete(long t) throws ValidacaoNegocioException {
		CapituloValidator validator = new CapituloValidator(repository,volumeRepository);
		validator.notExists(t);
		
		repository.deleteById(t);
	}

	public List<Capitulo> getByParams(Long artigo,Long volume,String numero, String titulo, Date publicacao) {
        return repository.findAll(CapituloSpecification.filterByArtidoVolumeNumeroTituloPublicacao(artigo, volume, numero, titulo, publicacao));
    }

    public List<Capitulo> getAllByArtigoVolume(long idArtigo,long idVolume) {
        return repository.findAll(CapituloSpecification.filterByArtidoVolumeNumeroTituloPublicacao(idArtigo, idVolume,null,null,null),Sort.by("numero"));
    }

}
