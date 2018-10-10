package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.com.amigotradutor.types.EPeriodicidade;

@Entity
public class Revista {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	@OneToOne
	private Editora editora;
	
	@ManyToMany
    @JoinTable(name="revista_tipo_manga", joinColumns=
    {@JoinColumn(name="revista_id")}, inverseJoinColumns=
      {@JoinColumn(name="tipo_manga_id")})
	private List<TipoManga> tipos;
	
	@Enumerated(EnumType.STRING)
	private EPeriodicidade periodicidade;
	
	public Revista() {
	}

	public Revista(long id, String nome, Editora editora, List<TipoManga> tipos, EPeriodicidade periodicidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.tipos = tipos;
		this.periodicidade = periodicidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<TipoManga> getTipo() {
		return tipos;
	}

	public void setTipo(List<TipoManga> tipos) {
		this.tipos = tipos;
	}

	public EPeriodicidade getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(EPeriodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}
	
}
