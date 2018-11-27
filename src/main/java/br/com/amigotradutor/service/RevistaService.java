package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Revista;
import br.com.amigotradutor.repository.interfaces.RevistaRepository;

@Service
public class RevistaService implements CrudService<Revista,Long>{

	@Autowired
	private RevistaRepository dao;

	@Override
	public List<Revista> getAll() {
		List<Revista> revistas = new ArrayList<Revista>();
		dao.findAll().forEach(revistas::add);
		return revistas;
	}

	public void add(Revista a){
		dao.save(a);
	}
	
	public void update(Long id, Revista a){
		dao.save(a);
	}
	
	public void delete(Long revistaId){
		dao.delete(revistaId);
	}
	
}
