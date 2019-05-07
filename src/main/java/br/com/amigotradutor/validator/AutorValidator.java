package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.repository.interfaces.AutorRepository;

public class AutorValidator implements BaseValidator<Autor, Long> {

	private AutorRepository repository;
	
	public AutorValidator(AutorRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Autor obj) throws ValidacaoNegocioException {
		
		if (ValidatorUtil.isEmpty(obj) || ValidatorUtil.isEmpty(obj.getNome()))
			throw new ValidacaoNegocioException("Dados obrigatórios do autor não foram informados.");
	}

	@Override
	public void duplicated(Autor obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		List<Autor> objBD = repository.findByNome(obj.getNome());
		if (ValidatorUtil.isNotEmpty(objBD)) {
			for (Autor a : objBD)
				if (a.getId() != obj.getId()) 
					throw new EntidadeUnicaExistenteException("Já existe um autor cadastrado com o mesmo nome.");
		}

	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (!repository.existsById(id))
			throw new EntidadeNaoExistenteException("O autor solicitado não foi encontrado na base de dados.");

	}

}
