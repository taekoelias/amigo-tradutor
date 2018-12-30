package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.amigotradutor.model.BaseObjetoTipo;

@NoRepositoryBean
public interface CrudRepositoryTipo<T extends BaseObjetoTipo> extends CrudRepository<T,Long> {

	T findByNome(String nome);
	
}
