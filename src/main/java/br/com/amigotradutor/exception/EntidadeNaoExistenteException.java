package br.com.amigotradutor.exception;

public class EntidadeNaoExistenteException extends ValidacaoNegocioException {

	public EntidadeNaoExistenteException() {
		super("A entidade informada não existe.");
	}

	public EntidadeNaoExistenteException(String message) {
		super(message);
	}

	public EntidadeNaoExistenteException(Throwable cause) {
		super(cause);
	}

	public EntidadeNaoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeNaoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
