package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome"}))
public class PublicoAlvo extends BaseObjetoTipo {
	
	public PublicoAlvo() {
	}

	public PublicoAlvo(long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
}
