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

@Entity
public class Revista {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	@OneToOne
	private Editora editora;
	
	@ManyToMany
    @JoinTable(name="revista_publico_alvo", joinColumns=
    {@JoinColumn(name="revista_id")}, inverseJoinColumns=
      {@JoinColumn(name="publico_alvo_id")})
	private List<PublicoAlvo> publicos;
	
	@OneToOne
	private PeriodicidadePublicacao periodicidade;
	
	public Revista() {
	}

	public Revista(long id, String nome, Editora editora, List<PublicoAlvo> publicos, PeriodicidadePublicacao periodicidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.publicos = publicos;
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

	public List<PublicoAlvo> getPublicos() {
		return publicos;
	}

	public void setPublicos(List<PublicoAlvo> tipos) {
		this.publicos = tipos;
	}

	public PeriodicidadePublicacao getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(PeriodicidadePublicacao periodicidade) {
		this.periodicidade = periodicidade;
	}
	
}
