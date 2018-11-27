package br.com.amigotradutor.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UsuarioPapel{

	@EmbeddedId
	private UsuarioPapelId usuarioPapelId;

	@Column(columnDefinition="boolean default true")
	private boolean ativo;
	
	public UsuarioPapel() {
	}
	
	public UsuarioPapel(long usuarioId, long papelId) {
		super();
		this.usuarioPapelId = new UsuarioPapelId(usuarioId, papelId);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public UsuarioPapelId getUsuarioPapelId() {
		return usuarioPapelId;
	}

	public void setUsuarioPapelId(UsuarioPapelId usuarioPapelId) {
		this.usuarioPapelId = usuarioPapelId;
	}
	
	
}
