package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	List<Autor> findByNome(String nome);
	
}
