package br.com.amigotradutor.repository.interfaces;

import java.util.List;

import br.com.amigotradutor.model.Usuario;

public interface UsuarioRepository extends PessoaBaseRepository<Usuario> {
	
	List<Usuario> findByPapeisId(long papelId);
	
}
