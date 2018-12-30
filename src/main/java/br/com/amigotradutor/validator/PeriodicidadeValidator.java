package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.GeneroArtigo;
import br.com.amigotradutor.model.PeriodicidadePublicacao;
import br.com.amigotradutor.repository.interfaces.GeneroArtigoRepository;
import br.com.amigotradutor.repository.interfaces.PeriodicidadeRepository;

public class PeriodicidadeValidator implements BaseValidator<PeriodicidadePublicacao, Long> {

	private PeriodicidadeRepository repository;
	
	public PeriodicidadeValidator(PeriodicidadeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(PeriodicidadePublicacao obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().trim().isEmpty() || obj.getDescricao() == null || obj.getDescricao().trim().isEmpty())
			throw new ValidacaoNegocioException("Os dados obrigatórios do período de publicação não foram preenchidos.");
	}

	@Override
	public void duplicated(PeriodicidadePublicacao obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		PeriodicidadePublicacao objBD = repository.findByNome(obj.getNome());
		
		if (objBD != null && objBD.getId() != obj.getId()) {
			throw new EntidadeUnicaExistenteException("Já existe um período de publicação cadastrado com o mesmo nome.");
		}
	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O período de publicação informado não foi encontrado na base de dados.");
	}

}
