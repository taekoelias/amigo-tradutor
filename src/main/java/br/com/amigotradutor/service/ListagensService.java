package br.com.amigotradutor.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigotradutor.model.Idioma;
import br.com.amigotradutor.repository.interfaces.IdiomaRepository;
import br.com.amigotradutor.types.EGeneroManga;
import br.com.amigotradutor.types.EPeriodicidade;

@Service
public class ListagensService {

	@Autowired
	private IdiomaRepository idiomaDao;
	
	public List<Idioma> getAllIdiomas(){
		List<Idioma> retorno = new ArrayList<>();
		idiomaDao.findAll().forEach(retorno::add);
		return retorno;
	}
	
	public List<EGeneroManga> getAllGenerosManga(){
		return Arrays.asList(EGeneroManga.values());
	}
	
	public List<EPeriodicidade> getAllPeriodicidades(){
		return Arrays.asList(EPeriodicidade.values());
	}
}
