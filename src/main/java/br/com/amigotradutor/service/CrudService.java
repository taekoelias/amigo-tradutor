package br.com.amigotradutor.service;

import java.util.List;

import br.com.amigotradutor.exception.ValidacaoNegocioException;

public interface CrudService<T,V>{

	List<T> getAll();
	
	void add(T t) throws ValidacaoNegocioException;
	
	void update(T t) throws ValidacaoNegocioException;
	
	void delete(V t) throws ValidacaoNegocioException;
}
