package br.com.amigotradutor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	private String apelido;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public Pessoa() {
	}

	public Pessoa(long id, String nome, String apelido, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return this.nome + " ("+apelido+")";
	}
}
