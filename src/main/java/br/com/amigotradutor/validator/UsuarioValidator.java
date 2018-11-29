package br.com.amigotradutor.validator;

import java.util.List;

import br.com.amigotradutor.exception.EntidadeNaoExistenteException;
import br.com.amigotradutor.exception.EntidadeUnicaExistenteException;
import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.repository.interfaces.UsuarioRepository;

public class UsuarioValidator implements BaseValidator<Usuario>{

	UsuarioRepository repository;
	
	public UsuarioValidator(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void requiredField(Usuario obj) throws ValidacaoNegocioException {
		
		if (obj == null || obj.getNome() == null || obj.getEmail() == null || obj.getSenha() == null || obj.getApelido() == null || obj.getDataNascimento() == null)
			throw new ValidacaoNegocioException("Os dados obrigatórios do usuário não foram preenchidos.");
		
	}

	public void duplicated(Usuario obj) throws ValidacaoNegocioException {
		
		requiredField(obj);
		
		List<Usuario> usuarioBD = repository.findByEmailOrApelido(obj.getEmail().trim().toLowerCase(), obj.getApelido().trim());
		
		if (usuarioBD != null) {
			
			for (Usuario u : usuarioBD) {
				if (u.getId() != obj.getId()) {
					if (u.getEmail().equalsIgnoreCase(obj.getEmail()))
						throw new EntidadeUnicaExistenteException("Já existe um usuário cadastrado com o mesmo e-mail.");
					else
						throw new EntidadeUnicaExistenteException("Já existe um usuário cadastrado com o mesmo apelido.");
				}
			}
		}
	}
	
	public void notExists(long id) throws ValidacaoNegocioException {
		
		Usuario usuarioBD = repository.findOne(id);
		
		if (usuarioBD == null)
			throw new EntidadeNaoExistenteException("O usuário informado não foi encontrado na base de dados.");
		
	}
	
}
