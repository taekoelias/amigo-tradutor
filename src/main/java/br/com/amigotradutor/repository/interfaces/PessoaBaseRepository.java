package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.amigotradutor.model.Pessoa;

@NoRepositoryBean
public interface PessoaBaseRepository<T extends Pessoa> extends CrudRepository<T, Long> {

}
