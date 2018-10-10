package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Manga;

public interface MangaRepository extends CrudRepository<Manga, Long> {

}
