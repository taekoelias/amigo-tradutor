package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Capitulo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CapituloRepository extends CrudRepository<Capitulo, Long>, JpaSpecificationExecutor<Capitulo> {

	List<Capitulo> findByNumeroAndVolumeId(long numero, long idVolume);

	List<Capitulo> findByVolumeId(long idVolume);
}
