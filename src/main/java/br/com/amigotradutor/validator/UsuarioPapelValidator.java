package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelId;
import br.com.amigotradutor.repository.interfaces.UsuarioPapelRepository;

public class UsuarioPapelValidator implements BaseValidator<UsuarioPapel>{

	UsuarioPapelRepository repository;
	
	public UsuarioPapelValidator(UsuarioPapelRepository repository) {
		this.repository = repository;
	}

	@Override
	public void requiredField(UsuarioPapel obj) throws ValidacaoNegocioException {
		
		if (obj == null || obj.getUsuarioPapelId() == null 
				|| (obj.getUsuarioPapelId().getUsuarioId() == 0 && obj.getUsuarioPapelId().getPapelId() == 0))
			throw new ValidacaoNegocioException("Os dados da vinculação do usuário com o papel não foram preenchidos.");
	}
	
	public void notExists(UsuarioPapelId id) throws ValidacaoNegocioException {
		
		if (id == null)
			throw new ValidacaoNegocioException("Os dados da vinculação do usuário com o papel não foram preenchidos.");
		
		if (repository.findOne(id) == null)
			throw new EntidadeNaoExistenteException("O vinculação do usuário com o papel informado não foi encontrado na base de dados.");
			
	}
}
