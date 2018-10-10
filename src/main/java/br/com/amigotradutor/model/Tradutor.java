package br.com.amigotradutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"idUsuario","idOrigem","idDestino"}))
public class Tradutor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="idOrigem", nullable=false)
	private Idioma origem;
	
	@ManyToOne
	@JoinColumn(name="idDestino", nullable=false)
	private Idioma destino;
	
	@Column(columnDefinition="boolean default true")
	private boolean ativo;
	
	public Tradutor() {
	}

	public Tradutor(long id, long usuario, long idiomaOrigem, long idiomaDestino, boolean ativo) {
		super();
		this.id = id;
		this.usuario = new Usuario(usuario);
		this.origem = new Idioma(idiomaOrigem, null, null);
		this.destino = new Idioma(idiomaDestino, null, null);
		this.ativo = ativo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Idioma getOrigem() {
		return origem;
	}

	public void setOrigem(Idioma origem) {
		this.origem = origem;
	}

	public Idioma getDestino() {
		return destino;
	}

	public void setDestino(Idioma destino) {
		this.destino = destino;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
