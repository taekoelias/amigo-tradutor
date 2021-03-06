package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Artigo;
import java.util.List;

public interface ArtigoRepository extends CrudRepository<Artigo, Long>, JpaSpecificationExecutor<Artigo> {

	Artigo findByTituloAndAutorIdAndRevistaId(String titulo, long idAutor, long idRevista);
        
    List<Artigo> findByTituloIgnoreCaseContaining(String titulo);

}
