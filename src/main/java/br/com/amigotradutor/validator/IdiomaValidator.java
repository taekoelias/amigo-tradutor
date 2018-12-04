package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.repository.interfaces.IdiomaRepository;

public class IdiomaValidator implements BaseValidator<Idioma, Long> {

	private IdiomaRepository repository;
	
	public IdiomaValidator(IdiomaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Idioma obj) throws ValidacaoNegocioException {
		if (obj == null || obj.getNome() == null || obj.getNome().isEmpty() || obj.getSigla() == null || obj.getSigla().isEmpty())
			throw new ValidacaoNegocioException("Dados obrigatório do idioma não foram preenchidos.");
	}

	public void duplicated(Idioma obj) throws ValidacaoNegocioException {
		requiredField(obj);
		
		List<Idioma> idiomaBD = repository.findByNomeOrSigla(obj.getNome().toUpperCase(), obj.getSigla().toUpperCase());
		if (idiomaBD != null) {
			for (Idioma i : idiomaBD) {
				if (i.getId() != obj.getId())
					throw new EntidadeUnicaExistenteException("Já existe um idioma cadastrado com mesmo nome e/ou sigla.");
			}
		}
	}

	@Override
	public void notExists(Long id) throws ValidacaoNegocioException {
		
		if (repository.findOne(id) == null)
			throw new EntidadeNaoExistenteException("O idioma informado não foi encontrado na base de dados.");
	}
	
}
