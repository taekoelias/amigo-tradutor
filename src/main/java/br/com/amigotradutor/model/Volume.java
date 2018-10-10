package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Volume {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long numero;
	
	private String titulo;
	
	@ManyToOne
	private Manga manga;
	
	@ManyToOne
	private Colecao colecao;
	
	public Volume() {
	}

	public Volume(long id, long numero, String titulo, long colecao, long manga) {
		super();
		this.id = id;
		this.numero = numero;
		this.titulo = titulo;
		this.colecao = new Colecao(colecao,null,manga);
		this.manga = new Manga(manga,null,0,0,null,null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	
}
