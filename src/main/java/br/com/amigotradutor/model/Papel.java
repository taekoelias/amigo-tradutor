package br.com.amigotradutor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Papel {

	public static final long PAPEL_USUARIO = 1;
	
	public static final long PAPEL_ADMIN = 2;
	
	public static final long PAPEL_GERENTE = 3;
	
	public static final long PAPEL_TRADUTOR = 4;
	
	public static final long PAPEL_REVISOR = 5;
	
	public static final long PAPEL_EDITOR = 6;
	
	public static final long PAPEL_REV_EDICAO = 7;
	
	@Id
	private long id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToMany(mappedBy="papeis")
	private List<Usuario> usuarios;
	
	public Papel() {
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public static Papel getPapelUsuario(){
		Papel usuario = new Papel();
		usuario.setId(PAPEL_USUARIO);
		return usuario;
	}
	
	public static Papel getPapelAdmin(){
		Papel admin = new Papel();
		admin.setId(PAPEL_ADMIN);
		return admin;
	}
	
	public static Papel getPapelTradutor(){
		Papel admin = new Papel();
		admin.setId(PAPEL_TRADUTOR);
		return admin;
	}
}
