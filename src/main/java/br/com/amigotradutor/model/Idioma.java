package br.com.amigotradutor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idioma {

	public static final long PT_BR = 1;
	
	public static final long EN_US = 2;
	
	public static final long JP = 3;
	
	@Id
	private long id;
	
	private String nome;
	
	private String sigla;
	
	public Idioma() {
	}

	public Idioma(long id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (obj instanceof Idioma)
			return ((Idioma) obj).getId() == this.id;
		
		return false;
	}
}
