package br.com.amigotradutor.types;

public enum Egenero {
	MASCULINO('M'),
	FEMININO('F'),
	NAO_INFORMADO('X');
	
	private char sigla;
	
	private Egenero(char sigla) {
		this.sigla = sigla;
	}
	
	public char getSigla() {
		return sigla;
	}
	
}
