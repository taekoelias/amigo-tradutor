package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TipoManga {
	
	@Id
	private long id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToMany(mappedBy="tipos")
	private List<Revista> revistas;
	
	public TipoManga() {
	}

	public TipoManga(long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public void setRevistas(List<Revista> revistas) {
		this.revistas = revistas;
	}
	
}
