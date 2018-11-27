package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Papel;

public interface PapelRepository extends CrudRepository<Papel, Long> {

	Papel findByNome(String nome);
	
	@Query("SELECT MAX(p.id)+1 FROM Papel p")
	long nextId();
	
}
