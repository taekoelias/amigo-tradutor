package br.com.amigotradutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UsuarioPapelPK.class)
public class UsuarioPapel{

	@Id
	private long usuarioId;
	
	@Id
	private long papelId;
	
	@ManyToOne
	@JoinColumn(name = "usuarioId", updatable = false, insertable = false, referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "papelId", updatable = false, insertable = false, referencedColumnName = "id")
	private Papel papel;

	@Column(columnDefinition="boolean default true")
	private boolean ativo;
	
	public UsuarioPapel() {
	}
	
	public UsuarioPapel(long usuarioId, long papelId) {
		super();
		this.usuarioId = usuarioId;
		this.papelId = papelId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public long getPapelId() {
		return papelId;
	}

	public void setPapelId(long papelId) {
		this.papelId = papelId;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
