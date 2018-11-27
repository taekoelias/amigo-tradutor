package br.com.amigotradutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"usuarioId", "papelId","idOrigem","idDestino"}))
public class Tradutor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@MapsId("usuarioPapelId")
    @JoinColumns({
        @JoinColumn(name="usuarioId", referencedColumnName="usuarioId"),
        @JoinColumn(name="papelId", referencedColumnName="papelId")
    })
    @ManyToOne
	private UsuarioPapel usuarioPapel;

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

	public Tradutor(long id, long usuario, long papel, long idiomaOrigem, long idiomaDestino, boolean ativo) {
		super();
		this.id = id;
		this.usuarioPapel = new UsuarioPapel(usuario, papel);
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

	public UsuarioPapel getUsuarioPapel() {
		return usuarioPapel;
	}

	public void setUsuarioPapel(UsuarioPapel usuarioPapel) {
		this.usuarioPapel = usuarioPapel;
	}
	
}
