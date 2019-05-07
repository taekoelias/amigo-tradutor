package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.util.ValidatorUtil;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.repository.interfaces.RevistaRepository;

public class RevistaValidator implements BaseValidator<Revista, Long> {

	private RevistaRepository repositorio;
	
	public RevistaValidator(RevistaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void requiredField(Revista obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().isEmpty() 
				|| ValidatorUtil.isEmpty(obj.getEditora()) || ValidatorUtil.isEmpty(obj.getEditora().getId()))
			throw new ValidacaoNegocioException("Dados obrigatório da revista não foram preenchidos.");

	}

	@Override
	public void duplicated(Revista obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		List<Revista> objBD = repositorio.findByNomeAndEditoraId(obj.getNome(),obj.getEditora().getId());
		if (objBD != null) {
			for (Revista i : objBD) {
				if (i.getId() != obj.getId())
					throw new EntidadeUnicaExistenteException("Já existe uma revista cadastrado com mesmo nome na editora informada.");
			}
		}

	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		if (!repositorio.existsById(id))
			throw new EntidadeNaoExistenteException("A revista informado não foi encontrado na base de dados.");
	}

}
