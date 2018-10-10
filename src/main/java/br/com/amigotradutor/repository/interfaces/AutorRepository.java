package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	Autor findByNome(String nome);
	
}
