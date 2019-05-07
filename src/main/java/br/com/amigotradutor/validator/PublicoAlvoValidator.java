package br.com.amigotradutor.validator;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.model.PublicoAlvo;
import br.com.amigotradutor.repository.interfaces.PublicoAlvoRepository;

public class PublicoAlvoValidator implements BaseValidator<PublicoAlvo, Long> {

	private PublicoAlvoRepository repository;
	
	public PublicoAlvoValidator(PublicoAlvoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(PublicoAlvo obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().trim().isEmpty() || obj.getDescricao() == null || obj.getDescricao().trim().isEmpty())
			throw new ValidacaoNegocioException("Os dados obrigatórios do público-alvo não foram preenchidos.");
	}

	@Override
	public void duplicated(PublicoAlvo obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		PublicoAlvo objBD = repository.findByNome(obj.getNome());
		
		if (objBD != null && objBD.getId() != obj.getId()) {
			throw new EntidadeUnicaExistenteException("Já existe um público-alvo cadastrado com o mesmo nome.");
		}
	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O público-alvo informado não foi encontrado na base de dados.");
	}

}
