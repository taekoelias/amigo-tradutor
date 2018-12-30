package br.com.amigotradutor.validator;

import br.com.amigotradutor.exception.ValidacaoNegocioException;

public interface BaseValidator<TYPE,ID> {

	void requiredField(TYPE obj) throws ValidacaoNegocioException;
	
	void duplicated(TYPE obj) throws ValidacaoNegocioException;
	
	void notExists(ID id) throws ValidacaoNegocioException;
}
