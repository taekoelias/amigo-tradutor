package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelId;
import br.com.amigotradutor.repository.interfaces.PapelRepository;
import br.com.amigotradutor.repository.interfaces.UsuarioPapelRepository;
import br.com.amigotradutor.repository.interfaces.UsuarioRepository;
import br.com.amigotradutor.validator.PapelValidator;
import br.com.amigotradutor.validator.UsuarioPapelValidator;
import br.com.amigotradutor.validator.UsuarioValidator;

@Service
public class UsuarioPapelService implements CrudService<UsuarioPapel, UsuarioPapelId> {

	@Autowired
	private UsuarioPapelRepository repository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioPapel> getAllPapelByUsuario(long id){
		
		List<UsuarioPapel> usuarioPapeis = new ArrayList<>();
		repository.findByUsuarioPapelIdUsuarioId(id).forEach(usuarioPapeis::add);
		return usuarioPapeis;
	}
	
	@Override
	public List<UsuarioPapel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(UsuarioPapel t) throws ValidacaoNegocioException {
		UsuarioPapelValidator validador = new UsuarioPapelValidator(repository);
		validador.requiredField(t);
		
		UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioRepository);
		usuarioValidator.notExists(t.getUsuarioPapelId().getUsuarioId());
		
		PapelValidator papelValidator = new PapelValidator(papelRepository);
		papelValidator.notExists(t.getUsuarioPapelId().getPapelId());
		
		UsuarioPapel up = repository.findOne(t.getUsuarioPapelId());
		if (up == null || !up.isAtivo()) {
			t.setAtivo(true);
			t = repository.save(t);
		}
	}

	@Override
	public void update(UsuarioPapelId id, UsuarioPapel t) throws ValidacaoNegocioException {
		UsuarioPapelValidator validador = new UsuarioPapelValidator(repository);
		validador.notExists(id);
		validador.requiredField(t);
		
		t.setUsuarioPapelId(id);
		
		t = repository.save(t);

	}

	@Override
	public void delete(UsuarioPapelId t) throws ValidacaoNegocioException {
		UsuarioPapelValidator validador = new UsuarioPapelValidator(repository);
		validador.notExists(t);
		
		repository.delete(t);
	}

}
