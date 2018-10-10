package br.com.amigotradutor.types;

public enum EGeneroManga {

	ACAO("Ação"),FANTASIA("Fantasia"),HORROR("HORROR"),AVENTURA("Aventura");
	
	private String titulo;
	
	private EGeneroManga(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
