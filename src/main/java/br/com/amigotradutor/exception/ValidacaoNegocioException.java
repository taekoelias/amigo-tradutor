package br.com.amigotradutor.exception;

public class ValidacaoNegocioException extends Exception {

	public ValidacaoNegocioException() {
		super("Infração de regra de négocio.");
	}

	public ValidacaoNegocioException(String message) {
		super(message);
	}

	public ValidacaoNegocioException(Throwable cause) {
		super(cause);
	}

	public ValidacaoNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidacaoNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
