package br.com.amigotradutor.model;

import java.io.Serializable;

public class UsuarioPapelPK implements Serializable{

	private long usuarioId;
	
	private long papelId;
	
	public UsuarioPapelPK() {
	}
	
	public UsuarioPapelPK(long usuarioId, long papelId) {
		super();
		this.usuarioId = usuarioId;
		this.papelId = papelId;
	}

	public int hashCode() {
	    return (int)(usuarioId + papelId);
	  }

	public boolean equals(Object object) {
		if (object instanceof UsuarioPapelPK) {
			UsuarioPapelPK otherId = (UsuarioPapelPK) object;
			return (otherId.usuarioId == this.usuarioId) && (otherId.papelId == this.papelId);
		}
		return false;
	}

}
