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
public class Equipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Usuario responsavel;
	
	@ManyToMany
	@JoinTable(name="usuario_equipe",
		joinColumns=@JoinColumn(name="equipe_id"),
		inverseJoinColumns=@JoinColumn(name="usuario_id"))
	private List<Usuario> membros;
	
	public Equipe() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public List<Usuario> getMembros() {
		return membros;
	}

	public void setMembros(List<Usuario> membros) {
		this.membros = membros;
	}
	
}
