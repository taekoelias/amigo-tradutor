package br.com.amigotradutor.validator;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.repository.interfaces.ArtigoRepository;

public class ArtigoValidator implements BaseValidator<Artigo, Long> {

	private ArtigoRepository repository;
	
	public ArtigoValidator(ArtigoRepository repository) {
		this.repository = repository;
	}
	
	public void requiredField(Artigo obj) throws ValidacaoNegocioException {
		
		if (ValidatorUtil.isEmpty(obj) || ValidatorUtil.isEmpty(obj.getTitulo()) 
				|| ValidatorUtil.isEmpty(obj.getAutor()) || ValidatorUtil.isEmpty(obj.getAutor().getId())
				|| ValidatorUtil.isEmpty(obj.getGeneros()))
			throw new ValidacaoNegocioException("Dados obrigatórios do Artigo não foram informados.");
	}

	public void duplicated(Artigo obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		Artigo artigosBD = repository.findByTituloAndAutorIdAndRevistaId(obj.getTitulo(),obj.getAutor().getId(),obj.getRevista().getId());
		if (ValidatorUtil.isNotEmpty(artigosBD) && artigosBD.getId() != obj.getId()) 
			throw new EntidadeUnicaExistenteException("Já existe um artigo cadastrado com o mesmo título, autor e revista.");

	}

	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O artigo solicitado não foi encontrado na base de dados.");

	}

}
