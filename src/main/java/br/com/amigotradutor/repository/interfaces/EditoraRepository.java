package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Editora;

public interface EditoraRepository extends CrudRepository<Editora, Long>, JpaSpecificationExecutor<Editora> {

	List<Editora> findByNome(String upperCase);

}
