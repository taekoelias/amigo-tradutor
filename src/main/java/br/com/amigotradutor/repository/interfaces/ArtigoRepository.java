package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Artigo;

public interface ArtigoRepository extends CrudRepository<Artigo, Long> {

	Artigo findByTituloAndAutorIdAndRevistaId(String titulo, long idAutor, long idRevista);

}