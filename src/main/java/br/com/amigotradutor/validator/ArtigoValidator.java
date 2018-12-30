package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Artigo;
import br.com.amigotradutor.repository.interfaces.ArtigoRepository;
import br.com.amigotradutor.util.ValidatorUtil;

public class ArtigoValidator implements BaseValidator<Artigo, Long> {

	private ArtigoRepository repository;
	
	public ArtigoValidator(ArtigoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Artigo obj) throws ValidacaoNegocioException {
		
		if (ValidatorUtil.isEmpty(obj) || ValidatorUtil.isEmpty(obj.getTitulo()) 
				|| ValidatorUtil.isEmpty(obj.getAutor()) || ValidatorUtil.isEmpty(obj.getAutor().getId())
				|| ValidatorUtil.isEmpty(obj.getGeneros()))
			throw new ValidacaoNegocioException("Dados obrigatórios do Artigo não foram informados.");
	}

	@Override
	public void duplicated(Artigo obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		Artigo artigosBD = repository.findByTituloAndAutorIdAndRevistaId(obj.getTitulo(),obj.getAutor().getId(),obj.getRevista().getId());
		if (ValidatorUtil.isNotEmpty(artigosBD) && artigosBD.getId() != obj.getId()) 
			throw new EntidadeUnicaExistenteException("Já existe um artigo cadastrado com o mesmo título, autor e revista.");

	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O artigo solicitado não foi encontrado na base de dados.");

	}

}
