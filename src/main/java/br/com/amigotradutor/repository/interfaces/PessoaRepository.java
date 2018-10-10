package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
