package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.model.Revista;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	List<Autor> findByNome(String nome);
	
	List<Autor> findByNomeIgnoreCaseContaining(String nome);
}
