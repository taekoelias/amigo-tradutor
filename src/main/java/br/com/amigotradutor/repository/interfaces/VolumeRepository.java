package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Volume;
import br.com.amigotradutor.model.VolumeId;

public interface VolumeRepository extends CrudRepository<Volume, Long> {

	List<Volume> findByArtigoId(long idArtigo);

	List<Volume> findByNumeroAndArtigoId(long numero, long idArtigo);

}
