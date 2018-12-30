package br.com.amigotradutor.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VolumeId implements Serializable{
	
	@ManyToOne
    @JoinColumn(name = "artigo_id")
    private Artigo artigo;
 
    private long numero;

    public VolumeId() {
    	// TODO Auto-generated constructor stub
    }
    
	public VolumeId(Artigo artigo, long numero) {
		super();
		this.artigo = artigo;
		this.numero = numero;
	}

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artigo == null) ? 0 : artigo.hashCode());
		result = prime * result + (int) (numero ^ (numero >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VolumeId other = (VolumeId) obj;
		if (artigo == null) {
			if (other.artigo != null)
				return false;
		} else if (!artigo.equals(other.artigo))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
}
