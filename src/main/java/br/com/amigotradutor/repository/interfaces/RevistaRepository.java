package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Revista;

public interface RevistaRepository extends CrudRepository<Revista, Long>, JpaSpecificationExecutor<Revista> {

	List<Revista> findByNomeAndEditoraId(String nome, long id);

	List<Revista> findByNomeIgnoreCaseContaining(String nome);
	
}
