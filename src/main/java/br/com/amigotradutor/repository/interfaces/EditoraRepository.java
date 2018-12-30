package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Editora;

public interface EditoraRepository extends CrudRepository<Editora, Long> {

	List<Editora> findByNome(String upperCase);

}
