package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.GeneroArtigo;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.repository.interfaces.GeneroArtigoRepository;

public class GeneroArtigoValidator implements BaseValidator<GeneroArtigo, Long> {

	private GeneroArtigoRepository repository;
	
	public GeneroArtigoValidator(GeneroArtigoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(GeneroArtigo obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().trim().isEmpty() || obj.getDescricao() == null || obj.getDescricao().trim().isEmpty())
			throw new ValidacaoNegocioException("Os dados obrigatórios do gênero não foram preenchidos.");
	}

	@Override
	public void duplicated(GeneroArtigo obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		GeneroArtigo generoBD = repository.findByNome(obj.getNome());
		
		if (generoBD != null && generoBD.getId() != obj.getId()) {
			throw new EntidadeUnicaExistenteException("Já existe um gênero cadastrado com o mesmo nome.");
		}
	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O gênero informado não foi encontrado na base de dados.");
	}

}
