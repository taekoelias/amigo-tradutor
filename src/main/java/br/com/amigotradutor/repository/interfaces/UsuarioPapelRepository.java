package br.com.amigotradutor.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelPK;

public interface UsuarioPapelRepository extends CrudRepository<UsuarioPapel,UsuarioPapelPK> {
	
}
