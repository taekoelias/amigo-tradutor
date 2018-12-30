package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Capitulo;
import br.com.amigotradutor.model.CapituloId;

public interface CapituloRepository extends CrudRepository<Capitulo, Long> {

	List<Capitulo> findByNumeroAndVolumeId(long numero, long idVolume);

	List<Capitulo> findByVolumeId(long idVolume);

}
