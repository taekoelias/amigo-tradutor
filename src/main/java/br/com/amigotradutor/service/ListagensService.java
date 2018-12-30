package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.repository.interfaces.IdiomaRepository;

@Service
public class ListagensService {

	@Autowired
	private IdiomaRepository idiomaDao;
	
	public List<Idioma> getAllIdiomas(){
		List<Idioma> retorno = new ArrayList<>();
		idiomaDao.findAll().forEach(retorno::add);
		return retorno;
	}
	
}
