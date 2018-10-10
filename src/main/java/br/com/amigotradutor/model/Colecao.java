package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Colecao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String descricao;
	
	@ManyToOne
	private Manga manga;
	
	public Colecao() {
	}

	public Colecao(long id, String descricao, long manga) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.manga = new Manga(manga,null,0,0,null,null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
