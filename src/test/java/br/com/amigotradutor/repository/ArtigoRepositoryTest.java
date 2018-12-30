package br.com.amigotradutor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.repository.interfaces.ArtigoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtigoRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ArtigoRepository artigoRepository;
	
    @Test
    public void quandoFindByTituloAndAutorIdAndRevistaId_entaoRetorneArtigo() {
        
    	// given
    	Autor autor = new Autor(0, "teste");
    	autor = entityManager.persist(autor);
        entityManager.flush();
    	
        Revista revista = new Revista(0, "teste", null, null, null);
        revista = entityManager.persist(revista);
        entityManager.flush();
        
        Artigo artigo = new Artigo(0,"teste",autor.getId(),revista.getId(),null,null);
        entityManager.persist(artigo);
        entityManager.flush();
     
        // when
        Artigo found = artigoRepository.findByTituloAndAutorIdAndRevistaId(artigo.getTitulo(), artigo.getAutor().getId(), artigo.getRevista().getId());
     
        // then
        assertThat(found.getTitulo()).isEqualTo(artigo.getTitulo());
    }
    
}
