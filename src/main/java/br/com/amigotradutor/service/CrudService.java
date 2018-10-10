package br.com.amigotradutor.service;

import java.util.List;

public interface CrudService<T,V>{

	List<T> getAll();
	
	void add(T t);
	
	void update(T t);
	
	void delete(V t);
}
