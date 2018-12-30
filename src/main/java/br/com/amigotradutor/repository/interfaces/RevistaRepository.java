package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Revista;

public interface RevistaRepository extends CrudRepository<Revista, Long> {

	List<Revista> findByNomeAndEditoraId(String nome, long id);

}
