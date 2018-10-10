package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoSituacaoProjeto {

	public final static long CADASTRADO = 1;
	
	public final static long TRADUCAO_INICIADA = 2;
	
	public final static long TRADUCAO_CONCLUIDA = 3;
	
	public final static long REVISAO_TRADUCAO_INICIADA = 4;
	
	public final static long REVISAO_TRADUCAO_CONCLUIDA = 5;
	
	public final static long RETORNADA_TRADUTOR = 6;
	
	public final static long EDICAO_INICIADA = 7;
	
	public final static long EDICAO_CONCLUIDA = 8;
	
	public final static long REVISAO_EDICAO_INICIADA = 9;
	
	public final static long REVISAO_EDICAO_CONCLUIDA = 10;
	
	public final static long RETORNADA_EDICAO = 11;
	
	public final static long PUBLICADA = 12;
	
	@Id
	private long id;
	
	private String nome;

	public TipoSituacaoProjeto(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
}
