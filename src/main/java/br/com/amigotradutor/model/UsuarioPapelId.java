package br.com.amigotradutor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPapelId implements Serializable{

	@Column(name = "usuarioId")
	private long usuarioId;
	
	@Column(name = "papelId")
	private long papelId;
	
	public UsuarioPapelId() {
	}
	
	public UsuarioPapelId(long usuarioId, long papelId) {
		super();
		this.usuarioId = usuarioId;
		this.papelId = papelId;
	}

	public int hashCode() {
	    return (int)(usuarioId + papelId);
	  }

	public boolean equals(Object object) {
		if (object instanceof UsuarioPapelId) {
			UsuarioPapelId otherId = (UsuarioPapelId) object;
			return (otherId.usuarioId == this.usuarioId) && (otherId.papelId == this.papelId);
		}
		return false;
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

}
