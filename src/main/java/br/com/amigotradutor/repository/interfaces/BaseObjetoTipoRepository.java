package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.amigotradutor.model.BaseObjetoTipo;
import br.com.amigotradutor.model.Pessoa;

@NoRepositoryBean
public interface BaseObjetoTipoRepository<T extends BaseObjetoTipo> extends CrudRepository<T, Long>, JpaSpecificationExecutor<T> {
	T findByNome(String nome);
}
