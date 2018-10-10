package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.amigotradutor.types.EGeneroManga;

@Entity
public class Manga {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String titulo;
	
	@OneToOne
	private Autor autor;
	
	@OneToOne
	private Revista revista;
	
	@ElementCollection(targetClass=EGeneroManga.class)
	@CollectionTable(name="MANGA_GENERO", joinColumns = @JoinColumn(name="mangaId"))
	private List<EGeneroManga> generos;
	
	private String enredo;
	
	public Manga() {
	}

	public Manga(long id, String titulo, long autor, long revista, List<EGeneroManga> generos, String enredo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = new Autor(autor,null);
		this.revista = new Revista(revista, null, null, null, null);
		this.generos = generos;
		this.enredo = enredo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public List<EGeneroManga> getGeneros() {
		return generos;
	}

	public void setGeneros(List<EGeneroManga> generos) {
		this.generos = generos;
	}

	public String getEnredo() {
		return enredo;
	}

	public void setEnredo(String enredo) {
		this.enredo = enredo;
	}
	
}
