package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome"}))
public class PublicoAlvo extends BaseObjetoTipo {
	
	@ManyToMany(mappedBy="publicos")
	private List<Revista> revistas;
	
	public PublicoAlvo() {
	}

	public PublicoAlvo(long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public void setRevistas(List<Revista> revistas) {
		this.revistas = revistas;
	}
	
}
