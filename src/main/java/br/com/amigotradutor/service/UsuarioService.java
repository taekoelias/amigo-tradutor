package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Papel;
import br.com.amigotradutor.model.Usuario;
import br.com.amigotradutor.model.UsuarioPapel;
import br.com.amigotradutor.model.UsuarioPapelPK;
import br.com.amigotradutor.repository.interfaces.UsuarioPapelRepository;
import br.com.amigotradutor.repository.interfaces.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository dao;
	
	@Autowired
	private UsuarioPapelRepository usuarioPapelDao;
	
	public void addUsuario(Usuario u) {
		
		u.setPapeis(new ArrayList<Papel>());
		u.getPapeis().add(Papel.getPapelUsuario());
		dao.save(u);
	}
	
	public List<Usuario> getAll(){
		List<Usuario> usuarios = new ArrayList<>();
		
		dao.findAll().forEach(usuarios::add);
		return usuarios;
	}
	
	public Usuario getUsuario(long usuarioId){
		return dao.findOne(usuarioId);
	}
	
	public List<Usuario> getAllAdmin(){
		return dao.findByPapeisId(Papel.PAPEL_ADMIN);
	}
	
	public void addAdmin(Usuario u){
		u.setPapeis(new ArrayList<Papel>());
		u.getPapeis().add(Papel.getPapelUsuario());
		u.getPapeis().add(Papel.getPapelAdmin());
		u.setAdmin(true);
		dao.save(u);
	}
	
	public void addPapelTradutor(Usuario u){
		addPapelUsuario(u, Papel.getPapelTradutor());		
	}
	
	public void addPapelUsuario(Usuario u, Papel p){
		UsuarioPapel up = usuarioPapelDao.findOne(new UsuarioPapelPK(u.getId(), p.getId()));
		if (up == null){
			up = new UsuarioPapel(u.getId(),p.getId());
		} 
		up.setAtivo(true);
		usuarioPapelDao.save(up);
	}
}
