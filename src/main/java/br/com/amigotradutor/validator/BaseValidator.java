package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.ValidacaoNegocioException;

public interface BaseValidator<T> {

	void requiredField(T obj) throws ValidacaoNegocioException;
	
}
