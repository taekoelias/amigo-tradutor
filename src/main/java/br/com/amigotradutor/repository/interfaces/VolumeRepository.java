package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Volume;

public interface VolumeRepository extends CrudRepository<Volume, Long>, JpaSpecificationExecutor<Volume> {

	List<Volume> findByArtigoId(long idArtigo);

	List<Volume> findByNumeroAndArtigoId(long numero, long idArtigo);
        
}
