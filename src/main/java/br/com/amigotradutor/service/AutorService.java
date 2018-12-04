package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Autor;
import br.com.amigotradutor.repository.interfaces.AutorRepository;

@Service
public class AutorService implements CrudService<Autor,Long>{

	@Autowired
	private AutorRepository dao;

	@Override
	public List<Autor> getAll() {
		List<Autor> autores = new ArrayList<Autor>();
		dao.findAll().forEach(autores::add);
		return autores;
	}

	public void add(Autor a){
		dao.save(a);
	}
	
	public void update(Long id,Autor a){
		a.setId(id);
		dao.save(a);
	}
	
	public void delete(Long autorId){
		dao.delete(autorId);
	}
	
}
