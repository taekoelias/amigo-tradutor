package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Idioma;

public interface IdiomaRepository extends CrudRepository<Idioma, Long> {

	List<Idioma> findByNomeOrSigla(String nome, String sigla);
	
	@Query("SELECT MAX(i.id) FROM Idioma i")
	Long nextId();
	
}
