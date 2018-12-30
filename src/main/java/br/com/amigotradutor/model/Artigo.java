package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = { "titulo","autor_id","revista_id" }))
public class Artigo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String titulo;
	
	@OneToOne
	private Autor autor;
	
	@OneToOne
	private Revista revista;
	
	@ManyToMany
    @JoinTable(name="artigo_genero_artigo", joinColumns=
    {@JoinColumn(name="artigo_id")}, inverseJoinColumns=
      {@JoinColumn(name="genero_artigo_id")})
	private List<GeneroArtigo> generos;
	
	private String enredo;
	
	public Artigo() {
	}

	public Artigo(long id) {
		super();
		this.id = id;
	}
	
	public Artigo(long id, String titulo, long autor, long revista, List<GeneroArtigo> generos, String enredo) {
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

	public List<GeneroArtigo> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroArtigo> generos) {
		this.generos = generos;
	}

	public String getEnredo() {
		return enredo;
	}

	public void setEnredo(String enredo) {
		this.enredo = enredo;
	}
	
}
