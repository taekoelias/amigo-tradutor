package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>, JpaSpecificationExecutor<Autor> {

	List<Autor> findByNome(String nome);
	
	List<Autor> findByNomeIgnoreCaseContaining(String nome);
}
