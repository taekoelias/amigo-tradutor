package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.model.Equipe;

public interface EquipeRepository extends CrudRepository<Equipe, Long> {

}
