package br.com.amigotradutor.exception;

public class EntidadeUnicaExistenteException extends ValidacaoNegocioException {

	public EntidadeUnicaExistenteException() {
		super();
	}

	public EntidadeUnicaExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntidadeUnicaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeUnicaExistenteException(String message) {
		super(message);
	}

	public EntidadeUnicaExistenteException(Throwable cause) {
		super(cause);
	}

}
