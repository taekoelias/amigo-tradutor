package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.ValidacaoNegocioException;

public interface BaseValidator<T,V> {

	void requiredField(T obj) throws ValidacaoNegocioException;
	
	void duplicated(T obj) throws ValidacaoNegocioException;
	
	void notExists(V id) throws ValidacaoNegocioException;
}
