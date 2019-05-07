package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.common.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.common.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.common.exception.ValidacaoNegocioException;
import br.com.amigotradutor.common.validator.BaseValidator;
import br.com.amigotradutor.model.Editora;
import br.com.amigotradutor.repository.interfaces.EditoraRepository;

public class EditoraValidator implements BaseValidator<Editora, Long> {

	private EditoraRepository repositorio;
	
	public EditoraValidator(EditoraRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void requiredField(Editora obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().isEmpty())
			throw new ValidacaoNegocioException("Dados obrigatório da editora não foram preenchidos.");

	}

	@Override
	public void duplicated(Editora obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		List<Editora> editoraBD = repositorio.findByNome(obj.getNome().toUpperCase());
		if (editoraBD != null) {
			for (Editora i : editoraBD) {
				if (i.getId() != obj.getId())
					throw new EntidadeUnicaExistenteException("Já existe uma editora cadastrado com mesmo nome.");
			}
		}

	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		if (!repositorio.existsById(id))
			throw new EntidadeNaoExistenteException("A editora informado não foi encontrado na base de dados.");
	}

}
