package br.com.amigotradutor.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Usuario extends Pessoa {

	@Column(unique=true,nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String senha;
	
	private boolean admin;
	
	@ManyToMany
	@JoinTable(name="UsuarioPapel",
		joinColumns=@JoinColumn(name="usuarioId", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="papelId", referencedColumnName="id"))
	private List<Papel> papeis;
	
	public Usuario() {
	}
	
	public Usuario(long id) {
		super(id, null, null, null);
	}
	
	public Usuario(long id, String nome, String nick, Date dataNascimento, String email, String senha, boolean admin) {
		super(id, nome, nick, dataNascimento);
		this.email = email;
		this.senha = senha;
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
}
