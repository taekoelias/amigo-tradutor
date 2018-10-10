package br.com.amigotradutor.types;

public enum EPeriodicidade {

	SEMANAL('S'),MENSAL('M');
	
	private char tipo;
	
	private EPeriodicidade(char tipo) {
		this.tipo = tipo;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
