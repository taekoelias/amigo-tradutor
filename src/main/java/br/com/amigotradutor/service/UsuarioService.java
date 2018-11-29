package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.exception.ValidacaoNegocioException;
import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelId;
import br.com.amigotradutor.repository.interfaces.UsuarioPapelRepository;
import br.com.amigotradutor.repository.interfaces.UsuarioRepository;
import br.com.amigotradutor.validator.UsuarioValidator;

@Service
public class UsuarioService implements CrudService<Usuario,Long>{

	@Autowired
	private UsuarioRepository dao;
	
	public List<Usuario> getAll(){
		List<Usuario> usuarios = new ArrayList<>();
		
		dao.findAll().forEach(usuarios::add);
		return usuarios;
	}
	
	public Usuario getUsuario(long usuarioId) throws ValidacaoNegocioException{
		UsuarioValidator validator = new UsuarioValidator(dao);
		validator.notExists(usuarioId);
		
		return dao.findOne(usuarioId);
	}
	
	public void add(Usuario u) throws ValidacaoNegocioException {
		
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.requiredField(u);
		validator.duplicated(u);
		
		u.setEmail(u.getEmail().trim().toLowerCase());
		u.setPapeis(new ArrayList<Papel>());
		u.getPapeis().add(Papel.getPapelUsuario());
		u = dao.save(u);
	}
	
	@Override
	public void update(Usuario u) throws ValidacaoNegocioException {
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.notExists(u.getId());
		validator.requiredField(u);
		validator.duplicated(u);
		
		u.setEmail(u.getEmail().trim().toLowerCase());
		
		u = dao.save(u);
	}

	@Override
	public void delete(Long u) throws ValidacaoNegocioException {
		UsuarioValidator validator = new UsuarioValidator(dao);
		
		validator.notExists(u);
		
		dao.delete(u);
	}

}
