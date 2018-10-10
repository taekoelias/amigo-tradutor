package br.com.amigotradutor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Capitulo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long numero;
	
	private String titulo;
	
	@ManyToOne
	private Manga manga;
	
	@ManyToOne
	private Volume volume;
	
	@Temporal(TemporalType.DATE)
	private Date publicacao;

	public Capitulo(long id, long numero, String titulo, long volume, long manga, Date publicacao) {
		super();
		this.id = id;
		this.numero = numero;
		this.titulo = titulo;
		this.volume = new Volume(volume,0,null,0, manga);
		this.manga = new Manga(manga,null,0,0,null,null);
		this.publicacao = publicacao;
	}
	
	public Capitulo() {
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

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}
	
}
