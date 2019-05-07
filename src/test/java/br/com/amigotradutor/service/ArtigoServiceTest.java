package br.com.amigotradutor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.repository.interfaces.ArtigoRepository;

@RunWith(SpringRunner.class)
public class ArtigoServiceTest {

	@TestConfiguration
    static class ArtigoServiceTestContextConfiguration {
  
        @Bean
        public ArtigoService artigoService() {
            return new ArtigoService();
        }
    }
	
	@Autowired
    private ArtigoService artigoService;
 
    @MockBean
    private ArtigoRepository artigoRepository;
	
    @Before
    public void setUp() {
        Artigo artigo = new Artigo(1,"teste",1,1,null,null);
     
        Mockito.when(artigoRepository.existsById(artigo.getId()))
          .thenReturn(true);
        
        Mockito.when(artigoRepository.findById(artigo.getId()))
          .thenReturn(Optional.of(artigo));
    }
    
    @Test
    public void quandoIdValido_entaoArtigoDeveSerEncontrado() throws ValidacaoNegocioException {
        Artigo artigo = artigoService.getOne(1l);
      
         assertThat(artigo.getId()).isEqualTo(1l);
     }
}
